package com.zmj.test;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {
	@Test
	public void test1() {
		System.out.println("当前系统日期时间="+LocalDateTime.now());//格式：2020-02-16T17:47:38.910

		LocalDate nowDate = LocalDate.now();
		System.out.println("当前系统日期="+nowDate);//格式：2020-02-16
		System.out.println(nowDate.getYear()+"-"+nowDate.getMonthValue()+"-"+nowDate.getDayOfMonth());//格式：2020-2-16
		System.out.println("相差="+Period.between(LocalDate.of(2019, 11, 1), nowDate));//格式：P3M15D

		LocalTime nowTime = LocalTime.now();
		System.out.println("当前系统时间="+nowTime);//格式：18:03:36.363
		System.out.println(nowTime.getHour()+":"+nowTime.getMinute()+":"+nowTime.getSecond());//格式：18:5:10

		LocalDateTime dt = LocalDateTime.of(2020, 02,16,17,24,33);
		System.out.println("拼接好的日期时间="+dt);//值：2020-02-16T17:24:33
		System.out.println("加上两年的结果="+ dt.plusYears(2));//值：2022-02-16T17:24:33
		System.out.println("减去两个月的结果="+ dt.minusMonths(2));//值：2019-12-16T17:24:33

		Instant instant = Instant.now();
		System.out.println("时间戳="+instant.toEpochMilli());
		System.out.println("北京时间="+ instant.atOffset(ZoneOffset.ofHours(8)));//格式：2020-02-16T18:10:42.884+08:00
		System.out.println("从1970年1月1日加上60秒="+Instant.ofEpochSecond(60));//格式：1970-01-01T00:01:00Z
		System.out.println("相差的毫秒数="+Duration.between(instant, Instant.now()).toMillis());
	}
}
