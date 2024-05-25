package com.zmj.test;

import com.zmj.bean.Employee;
import com.zmj.bean.Employee.Status;
import org.junit.Test;

import java.util.Optional;

public class TestOptional {
	/*
	 常用方法：
		Optional.of(T t) : 创建一个 Optional 实例
		Optional.empty() : 创建一个空的 Optional 实例
		Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
		isPresent() : 判断是否包含值
		orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
		orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
		map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
		flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
	 */
	@Test
	public void test() {
		Optional<Employee> op = Optional.ofNullable(new Employee());
		if(op.isPresent()) {
			System.out.println("如果op有值，"+op.get());
		}
		//一般这里如果传过来的值是null时，会在这里就报空指针异常，快速锁定，而不像以前还要找是哪里发生了
		op = Optional.of(null);   System.out.println(op.get());
	}
	@Test
	public void test2() {
		Optional<String> strOp = Optional
				.ofNullable(new Employee("zzz",22,345.5,Status.BUSY))
				.map((e) -> e.getName());
		System.out.println(strOp.get());
		strOp = Optional
				.ofNullable(new Employee("zzz",22,345.5,Status.BUSY))
				.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(strOp.get());
	}
	@Test
	public void test3() {
		Optional<Man> op = Optional.ofNullable(null);
		//如果是null,则在使用这个方法orElse时，不会引起空指针，而是输出指定的默认值
		String name = getGodnessName(op);
		System.out.println(name);
	}
	public String getGodnessName(Optional<Man> man) {
		return man.orElse(new Man()).getGodnessOp().orElse(new Godness("苍老师")).getName();
	}
	class Man {
		private Optional<Godness> godnessOp = Optional.empty();
		public Man() {
		}
		public Man(Optional<Godness> godnessOp) {
			this.godnessOp = godnessOp;
		}
		public Optional<Godness> getGodnessOp() {
			return godnessOp;
		}
		public void setGodnessOp(Optional<Godness> godnessOp) {
			this.godnessOp = godnessOp;
		}
	}
	class Godness {
		private String name;
		public Godness(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
