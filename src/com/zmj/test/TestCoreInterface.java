package com.zmj.test;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestCoreInterface {
	//消费型接口 Consumer<T>
	private void buy(double money,Consumer<Double> c) {
		c.accept(money);
	}

	//供给型接口 Supplier<T>
	private List<Integer> getNumList(int count,Supplier<Integer> s) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(s.get());
		}
		return list;
	}

	//函数型接口 Function<T,R>
	private String strHandler(String str,Function<String, String> f) {
		return f.apply(str);
	}

	//断言型接口 Predicate<T>
	private List<String> filterStr(List<String> strList,Predicate<String> p) {
		List<String> list = new ArrayList<>();
		for (String str : strList) {
			if(p.test(str)) {
				list.add(str);
			}
		}
		return list;
	}

	@Test
	public void testJava(){
		//消费型接口 Consumer<T>
		buy(10000, new Consumer<Double>(){
			@Override
			public void accept(Double t) {
				System.out.println("花费="+t);
			}
		});

		//供给型接口 Supplier<T>
		List<Integer> list = getNumList(5, new Supplier<Integer>() {
			@Override
			public Integer get() {
				return (int) (Math.random()*100);
			}
		});
		for (Integer integer : list) {
			System.out.println(integer);
		}

		//函数型接口 Function<T,R>
		String trimStr = strHandler(" Where there is a will there is a way! ", new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.trim();
			}
		});
		System.out.println("trimStr="+trimStr);

		//断言型接口 Predicate<T>
		List<String> strList = Arrays.asList("Hello","World","!","I","Can","Do");
		List<String> filterStrList = filterStr(strList, new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() > 4;
			}
		});
		for (String string : filterStrList) {
			System.out.println(string);
		}
	}

	@Test
	public void testJava8(){
		//消费型接口 Consumer<T>
		buy(10000,(money) -> System.out.println("花费="+money));
		//供给型接口 Supplier<T>
		List<Integer> list = getNumList(5, () -> (int) (Math.random()*100));
		for (Integer integer : list) {
			System.out.println(integer);
		}

		//函数型接口 Function<T,R>
		String trimStr = strHandler(" Where there is a will there is a way! ", (str) -> str.trim());
		System.out.println("trimStr="+trimStr);

		//断言型接口 Predicate<T>
		List<String> strList = Arrays.asList("Hello","World","!","I","Can","Do");
		List<String> filterStrList = filterStr(strList, (str) -> str.length() > 4);
		for (String string : filterStrList) {
			System.out.println(string);
		}
	}
}
