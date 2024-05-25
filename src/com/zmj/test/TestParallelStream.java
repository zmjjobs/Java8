package com.zmj.test;

import org.junit.Test;

import java.util.stream.LongStream;

public class TestParallelStream {
	@Test
	public void test(){
		long start = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0L; i <= 10000000000L; i++) {
			sum += i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start)); //耗费的时间为: 12096-13533
	}

	@Test
	public void test2(){
		long start = System.currentTimeMillis();
		Long sum = LongStream.rangeClosed(0L, 10000000000L)
				.parallel()
				.sum();
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start)); //耗费的时间为: 9115-10477
	}
}
