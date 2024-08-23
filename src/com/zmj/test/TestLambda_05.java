package com.zmj.test;

import org.junit.Test;

import com.zmj.interfaces.base.BaseStringHandler;

public class TestLambda_05 {
	private String strHandler(String str, BaseStringHandler ms) {
		return ms.handler(str);
	}

	@Test
	public void testJava(){
		String trimStr = strHandler(" [My Name is ZMJ!] ", new BaseStringHandler() {
			@Override
			public String handler(String str) {
				return str.trim();
			}
		});
		System.out.println("trimStr="+trimStr);
		String substring = strHandler(" [My Name is ZMJ!] ", new BaseStringHandler() {
			@Override
			public String handler(String str) {
				return str.substring(2,5);
			}
		});
		System.out.println("substring="+substring);
	}


	@Test
	public void testJava8(){
		String trimStr = strHandler(" [My Name is ZMJ!] ", (x) -> x.trim());
		System.out.println("trimStr="+trimStr);
		String substring = strHandler(" [My Name is ZMJ!] ", (x) -> x.substring(2,5));
		System.out.println("substring="+substring);
	}
}
