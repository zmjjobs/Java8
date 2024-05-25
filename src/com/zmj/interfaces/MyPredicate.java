package com.zmj.interfaces;

@FunctionalInterface
public interface MyPredicate<T> {
	//@FunctionalInterface修饰的类，只能有一个抽象方法
	public boolean test(T t);
}
