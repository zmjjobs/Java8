package com.zmj.interfaces;

@FunctionalInterface
public interface MyCalculate {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	public double calculate(double a,double b);
}
