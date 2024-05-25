package com.zmj.test;

import com.zmj.bean.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestConstructorReferences {
	@Test
	public void testJava8_1(){
		//改进前
		Supplier<Employee> sup = () -> new Employee();

		//改进后 构造器引用     类名::new
		Supplier<Employee> sup2 = Employee::new;
	}
	@Test
	public void testJava8_2(){
		//改进前
		Function<Integer, Employee> fun = (x) -> new Employee(x);

		//改进后  构造器只要存在就会自动匹配
		Function<Integer,Employee> fun2 = Employee::new;

		//如果匹配Employee的两个int的构造器
		BiFunction<Integer, Integer, Employee> bf = Employee::new;

	}
}
