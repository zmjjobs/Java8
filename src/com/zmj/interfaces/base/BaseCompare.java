package com.zmj.interfaces.base;

@FunctionalInterface
public interface BaseCompare<T> {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	boolean compare(T t);
}
