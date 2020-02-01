package com.isoftstone.test;

import java.util.Comparator;

import org.junit.Test;

public class TestLambda_03 {
	@Test
	public void testJava(){
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				System.out.println("函数式接口");
				return Integer.compare(x, y);
			}
		};
		int compare = com.compare(1, 2);
		System.out.println(compare);
		
		Comparator<Integer> com2 = new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return Integer.compare(x, y);
			}
		};
		int compare2 = com2.compare(1, 2);
		System.out.println(compare2);
	}
	
	@Test
	public void testJava8(){
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		int compare = com.compare(1, 2);
		System.out.println(compare);

		Comparator<Integer> com2 = (x,y) -> Integer.compare(x, y);
		int compare2 = com2.compare(1, 2);
		System.out.println(compare2);
	}
}
