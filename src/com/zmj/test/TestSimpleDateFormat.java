package com.zmj.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {
	@Test
	public void testJava8_DateTimeFormatter() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				//新的日期格式化API可以解决线程安全问题
				return LocalDate.parse("2019-02-16",dtf);
			}
		};
		List<Future<LocalDate>> resultList = new ArrayList<>();
		ExecutorService pool = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				resultList.add(pool.submit(task));
			}
			for (Future<LocalDate> future : resultList) {
				System.out.println(future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
	}

	@Test
	public void testSimpleDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				//传统的日期格式化API存在线程安全问题
				//return dateFormat.parse("2020-02-16");

				//还需要自己定义一个ThreadLocal才能解决线程安全问题
				return DateFormatThreadLocal.convert("2020-02-16");
			}
		};
		List<Future<Date>> resultList = new ArrayList<>();
		ExecutorService pool = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				resultList.add(pool.submit(task));
			}
			for (Future<Date> future : resultList) {
				System.out.println(future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
	}
}
class DateFormatThreadLocal {
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	public static Date convert(String source) throws ParseException {
		return df.get().parse(source);
	}
}
