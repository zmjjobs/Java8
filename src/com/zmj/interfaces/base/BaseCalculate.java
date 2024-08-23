package com.zmj.interfaces.base;

@FunctionalInterface
public interface BaseCalculate {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	double calculate(double a,double b);
}
