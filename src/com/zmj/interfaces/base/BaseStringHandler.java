package com.zmj.interfaces.base;

@FunctionalInterface
public interface BaseStringHandler {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	public String handler(String str);
}
