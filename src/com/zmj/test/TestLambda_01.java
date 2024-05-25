package com.zmj.test;

import org.junit.Test;

public class TestLambda_01 {
	@Test
	public void testJava(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				//只有一条语句
				System.out.println(Thread.currentThread().getName());
			}
		},"A").start();
	}

	@Test
	public void testJava8(){
		//只有一条语句
		new Thread(() -> System.out.println(Thread.currentThread().getName()),"A").start();
	}

	@Test
	public void testJava_2(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				//有多条语句
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName());
			}
		},"A").start();
	}

	@Test
	public void testJava8_2(){
		new Thread(() -> {
			//有多条语句
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName());
		},"A").start();
	}
}
