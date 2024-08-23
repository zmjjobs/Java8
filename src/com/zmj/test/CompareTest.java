package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.interfaces.FilterEmpByAge;
import com.zmj.interfaces.FilterEmpBySalary;
import com.zmj.interfaces.base.BaseCompare;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//需求：根据条件过滤员工信息
public class CompareTest {

	List<Employee> emps = Arrays.asList(
			new Employee("张三",18,3333.5),
			new Employee("李四",28,4444.5),
			new Employee("赵武",38,5555.5),
			new Employee("王柳",68,6666.5),
			new Employee("田七",78,7777.5)
	);

	public List<Employee> filterEmployee(List<Employee> emps, BaseCompare<Employee> mp) {
		List<Employee> empList = new ArrayList<>();
		for (Employee employee : emps) {
			if (mp.compare(employee)) {
				empList.add(employee);
			}
		}
		return empList;
	}

	/**
	 * 方式一： 策略设计模式
	 */
	@Test
	public void testFilterEmp1(){
		List<Employee> filterEmployee = filterEmployee(emps,new FilterEmpByAge());
		for (Employee employee : filterEmployee) {
			System.out.println(employee);
		}
		System.out.println("******************");
		filterEmployee = filterEmployee(emps,new FilterEmpBySalary());
		for (Employee employee : filterEmployee) {
			System.out.println(employee);
		}
	}

	/**
	 * 方式二： 匿名内部类
	 */
	@Test
	public void testFilter2(){
		List<Employee> filterEmployee = filterEmployee(emps,new BaseCompare<Employee>() {
			@Override
			public boolean compare(Employee t) {
				return t.getAge() > 30;
			}
		});
		for (Employee employee : filterEmployee) {
			System.out.println(employee);
		}
		System.out.println("******************");
		filterEmployee = filterEmployee(emps,new BaseCompare<Employee>() {
			@Override
			public boolean compare(Employee t) {
				return t.getSalary() > 3000;
			}
		});
		for (Employee employee : filterEmployee) {
			System.out.println(employee);
		}
	}

	/**
	 * 方式三： Lambda表达式
	 */
	@Test
	public void testFilter3(){
		List<Employee> filterEmployee = filterEmployee(emps,(e) -> e.getAge() > 30);
		filterEmployee.forEach(System.out::println);
		System.out.println("*******************");
		filterEmployee = filterEmployee(emps,(e) -> e.getSalary() > 3000);
		filterEmployee.forEach(System.out::println);
	}

	/**
	 * 方式四： Stream API
	 */
	@Test
	public void testFilter4(){
		emps.stream()
				.filter((e) -> e.getSalary() > 3000)
				.limit(2)
				.forEach(System.out::println);
		System.out.println("***************");
		emps.stream()
				.filter((e) -> e.getAge() > 30)
				.forEach(System.out::println);
		System.out.println("***************");
		emps.stream()
				.map(Employee::getName)
				.forEach(System.out::println);
	}
}
