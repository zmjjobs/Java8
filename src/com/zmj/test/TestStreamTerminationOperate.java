package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.bean.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamTerminationOperate {
	// 创建流  >> 中间操作   >> 终止操作
	@Test
	public void testJava8_over(){//终止操作，此时才会一次性执行全部操作，相当于执行任务
		/*
		 * 操作1.查找与匹配
		 * allMatch(Predicate p)    检查是否匹配所有元素
		 * anyMatch( (Predicate p)  检查是否至少匹配一个元素
		 * noneMatch(Predicate p)   检查是否没有匹配所有元素
		 * findFirst()              返回第一个元素
		 * findAny()                返回当前流中的任意元素
		 * count()                  返回流中元素总数
		 * max(Comparator c)        返回流中最大值
		 * min(Comparator c)        返回流中最小值
		 * forEach(Consumer c)      内部迭代
		 */
		boolean allMatch = empList.stream().allMatch((e) -> Status.BUSY.equals(e.getStatus()));
		System.out.println("是否所以的员工都在忙=" +allMatch);
		boolean anyMatch = empList.stream().anyMatch((e) -> Status.FREE.equals(e.getStatus()));
		System.out.println("是否至少一名员工空闲=" +anyMatch);
		Optional<Employee> op = empList.stream().findFirst();
		System.out.println("第一个员工的信息 "+op.get());
		Optional<Employee> op2 = empList.parallelStream()
				.filter((e) -> Status.FREE.equals(e.getStatus()))
				.findAny();
		System.out.println("通过并行流随机找到一个目前处于空闲的员工  "+op2.get());
		Optional<Double> op3 = empList.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println("最低工资="+op3.get());

		/*
		 * 操作2.规约
		 * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
		 * reduce(BinaryOperator b)  可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
		 */
		Integer sum = integerList.stream().reduce(0,(x,y) -> x +y);
		System.out.println("求和=" + sum);
		Optional<Double> optional = empList.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println("求工资总和=" + optional.get());

		/*
		 * 操作3.收集
		 * collect(Collector c) 将流转换为其他形式
		 * 接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
		 * Collectors的静态方法：
		 *    toList          把流中元素收集到List
		 *    toList          把流中元素收集到List
		 *    toSet           把流中元素收集到Set
		 *    toCollection    把流中元素收集到创建的集合
		 *    partitioningBy  分区，满足条件的一部分，不满足条件的一部分
		 *    counting\averaging*\sum*\maxBy\groupingBy*\......
		 */
		empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toList())
				.forEach(System.out::println);

		empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new))
				.forEach(System.out::println);

		Optional<Double> maxSalaryOp = empList.stream().map(Employee::getSalary)
				.collect(Collectors.maxBy(Double::compare));
		System.out.println("最高工资=" + maxSalaryOp.get());

		Map<Boolean, List<Employee>> map = empList.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary() > 4000));
		System.out.println(map);
	}
	List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);

	List<Employee> empList = Arrays.asList(
			new Employee("张三",18,3333.5,Status.FREE),
			new Employee("李四",28,4444.5,Status.BUSY),
			new Employee("赵武",38,5555.5,Status.VOCATION),
			new Employee("王柳",68,6666.5,Status.FREE),
			new Employee("田七",78,7777.5,Status.BUSY)
	);
}
