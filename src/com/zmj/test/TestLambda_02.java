package com.zmj.test;

import org.junit.Test;

import java.util.function.Consumer;

public class TestLambda_02 {
	@Test
	public void testJava(){
		Consumer<String> con = new Consumer<String>() {
			//只有一个参数
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		con.accept("我的地盘听我的！");
	}

	@Test
	public void testJava8(){
		//只有一个参数
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("我的地盘听我的！");

		//只有一个参数
		//参数(x) 可以省略为 x
		Consumer<String> con2 = x -> System.out.println(x);
		con2.accept("我的地盘听我的2222！");

		//只有一个参数
		//参数(x) 可加可不加类型,这里加String，默认推断这里也是String
		Consumer<String> con3 = (String x) -> System.out.println(x);
		con3.accept("我的地盘听我的3333！");

	}
}
