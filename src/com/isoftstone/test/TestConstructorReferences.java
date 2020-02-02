package com.isoftstone.test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

import com.isoftstone.bean.Employee;

public class TestConstructorReferences {
	@Test
	public void testJava8(){
		//改进前
		Supplier<Employee> sup = () -> new Employee();
		
		//改进后 构造器引用     类名::new
		Supplier<Employee> sup2 = Employee::new;
	}
}
