package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.bean.Employee.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestCreateStream {
	// 创建流  >> 中间操作   >> 终止操作
	@Test
	public void testJava8_create(){//创建Stream流的四种方式
		//方式一： 通过 Collection 系列集合提供的stream()或parallelStream()
		List<Employee> empList = Arrays.asList(
				new Employee("张三",18,3333.5,Status.FREE),
				new Employee("李四",28,4444.5,Status.BUSY),
				new Employee("赵武",38,5555.5,Status.VOCATION),
				new Employee("王柳",68,6666.5,Status.FREE),
				new Employee("田七",78,7777.5,Status.BUSY)
		);
		Stream<Employee> stream = empList.stream();

		//方式二：通过 Arrays 中的静态方法 stream()获取数组流
		Employee[] empArr = new Employee[2];
		empArr[0] = new Employee("WWW", 22, 5000, Status.BUSY);
		empArr[1] = new Employee("MMM", 33, 6000, Status.FREE);
		Stream<Employee> stream2 = Arrays.stream(empArr);

		//方式三：通过Stream 类中的静态方法 of()
		Stream<String> stream3 = Stream.of("aaa","bbb","ccc");

		//方式四：创建一个无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		Stream<Double> stream5 = Stream.generate(() -> Math.random());

		//测试 输出结果
		System.out.println("------通过 Collection 系列集合提供的stream()或parallelStream()-----");
		stream.forEach(System.out::println);
		System.out.println("\n------通过 Arrays 中的静态方法 stream()获取数组流-----");
		stream2.forEach(System.out::println);
		System.out.println("\n------通过Stream 类中的静态方法 of()-----");
		stream3.forEach(System.out::println);
		System.out.println("\n------创建一个无限流 stream4-----");
		stream4.limit(3).forEach(System.out::println);
		System.out.println("\n------创建一个无限流 stream5-----");
		stream5.limit(3).forEach(System.out::println);
	}
}
