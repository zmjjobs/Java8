package com.zmj.test;

import org.junit.Test;

import java.util.function.Function;

public class TestArrayReferences {
	@Test
	public void testJava8(){
		//改进前
		Function<Integer, String[]> fun = (x) -> new String[x];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);

		//改进后
		Function<Integer, String[]> fun2 = String[]::new;
		String[] strs2 = fun2.apply(10);
		System.out.println(strs2.length);
	}
}
