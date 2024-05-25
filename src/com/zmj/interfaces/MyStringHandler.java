package com.zmj.interfaces;

@FunctionalInterface
public interface MyStringHandler {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	public String handler(String str);
}
