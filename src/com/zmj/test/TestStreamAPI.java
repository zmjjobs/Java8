package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.bean.Employee.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {

	//给定一个数字列表，得到每个数字的平方的 列表
	@Test
	public void test1() {
		Integer[] nums = new Integer[]{1,3,5,7,9};
		Arrays.stream(nums)
				.map((x) -> x * x)
				.forEach(System.out::println);
	}

	//用map和reduce方法数一下有多少个Employee
	@Test
	public void test2() {
		Optional<Integer> sumOp = empList.stream()
				.map((e) -> 1)
				.reduce(Integer::sum);
		System.out.println(sumOp.get());
	}

	List<Employee> empList = Arrays.asList(
			new Employee("张三",18,3333.5,Status.FREE),
			new Employee("李四",28,4444.5,Status.BUSY),
			new Employee("赵武",38,5555.5,Status.VOCATION),
			new Employee("王柳",68,6666.5,Status.FREE),
			new Employee("田七",78,7777.5,Status.BUSY)
	);
}
