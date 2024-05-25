package com.zmj.test;

import com.zmj.bean.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestMethodReferences {
	@Test
	public void testJava8(){
		//改进前
		Consumer<String> c1 = (str) -> System.out.println(str);
		c1.accept("c1");
		//改进后  对象::实例方法名
		Consumer<String> c2 = System.out::println;
		c2.accept("c2");

		//改进前
		Employee emp = new Employee("张三",25,10000);
		Supplier<String> s = () -> emp.getName();
		System.out.println(s.get());
		//改进后  对象::实例方法名
		Employee emp2 = new Employee("李四",25,10000);
		Supplier<String> s2 = emp2::getName;
		System.out.println(s2.get());

		//改进前
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		//改进后   类名::静态方法名
		Comparator<Integer> com2 = Integer::compare;

		//改进前
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		//改进后  类名::实例方法名
		//只有在第一个参数是实例方法调用者且第二个参数是实例方法的参数时，才可以这么写
		BiPredicate<String, String> bp2 = String::equals;
	}
}
