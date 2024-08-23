package com.zmj.test;

import org.junit.Test;

import com.zmj.interfaces.base.BaseCalculate;

public class TestLambda_04 {
	private double operation(double a, double b, BaseCalculate myCalculate) {
		return myCalculate.calculate(a, b);
	}

	@Test
	public void testJava(){
		double value = operation(1.5,2.5,new BaseCalculate(){
			@Override
			public double calculate(double a, double b) {
				return a + b;
			}});
		System.out.println(value);
		value = operation(9,3,new BaseCalculate(){
			@Override
			public double calculate(double a, double b) {
				return a - b;
			}});
		System.out.println(value);
	}


	@Test
	public void testJava8(){
		double value = operation(1.5,2.5,(x,y) -> x + y);
		System.out.println(value);
		value = operation(9,3,(x,y) -> x - y);
		System.out.println(value);
	}
}
