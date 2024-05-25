package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.bean.Employee.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamMiddleOperate {
	// 创建流  >> 中间操作   >> 终止操作
	@Test
	public void testJava8_middle(){//中间操作,此时不会执行任何操作，相当于安排任务
		/*
		 * 操作1. 筛选与切片
		 * filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
		 * distinct()          筛选，通过流所生成元素的 hashCode()和 equals()去除重复元素
		 * limit(long maxSize) 截断流，使其元素不超过给定数量
		 * skip(long n)        跳过元素，返回一个扔掉了前 n个元素的流。若流中元素不足 n个，则返回一个空流。与 limit(n)互补
		 */
		Stream<Employee> stream = empList.stream()
				.filter((e) -> e.getAge() > 35)
				.skip(1)
				.limit(3)
				.distinct();

		/*
		 * 操作2.映射
		 * map(Function f)                  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
		 * mapToDouble(ToDoubleFunction f)  接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream
		 * mapToInt(ToIntFunction f)        接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream
		 * mapToLong(ToLongFunction f)      接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream
		 * flatMap(Function f)              接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
		 * map与flatMap区别   可以用add(list)与addAll(list)来对比理解，前面是一个整体加进来；后面的并不是把一个整体加过来，而是将这个整体切分成每一份加进来
		 */
		Stream<String> stream21 = strList.stream().map((str) -> str.toUpperCase());
		Stream<String> stream22 = empList.stream().map(Employee::getName);
		Stream<Stream<Character>> stream23 = strList.stream().map(TestStreamMiddleOperate::filterCharacter);
		Stream<Character> stream24 = strList.stream().flatMap(TestStreamMiddleOperate::filterCharacter);

		/*
		 * 操作3.排序
		 * sorted()                    产生一个新流，其中按自然顺序排序（Comparable）
		 * sorted(Comparator  comp)    产生一个新流，其中按比较器顺序排序（Comparator）
		 */
		Stream<Employee> stream3 = empList.stream().sorted((e1,e2) -> {
			if (e1.getAge() != e2.getAge()) {
				return e1.getAge() - e2.getAge();
			} else {
				return e1.getName().compareTo(e2.getName());
			}
		});

		//测试结果
		System.out.println("----操作1. 筛选与切片-----");
		stream.forEach(System.out::println);
		System.out.println("\n----操作2.映射map_1-----");
		stream21.forEach(System.out::println);
		System.out.println("\n----操作2.映射map_2-----");
		stream22.forEach(System.out::println);
		System.out.println("\n----操作2.映射map_3-----");
		stream23.forEach((sm) -> {sm.forEach(System.out::println);});
		System.out.println("\n----操作2.映射flatMap-----");
		stream24.forEach(System.out::println);
		System.out.println("\n----操作3.排序-----");
		stream3.forEach(System.out::println);
	}

	List<Employee> empList = Arrays.asList(
			new Employee("张三",18,3333.5,Status.FREE),
			new Employee("李四",28,4444.5,Status.BUSY),
			new Employee("赵武",38,5555.5,Status.VOCATION),
			new Employee("王柳",68,6666.5,Status.FREE),
			new Employee("田七",78,7777.5,Status.BUSY),
			new Employee("田七",78,7777.5,Status.BUSY)
	);
	List<String> strList = Arrays.asList("aaa","bbb","ccc","ddd","eee");

	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		char[] charArray = str.toCharArray();
		for (Character character : charArray) {
			list.add(character);
		}
		return list.stream();
	}
}
