package com.test;

import java.util.Random;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月27日 上午10:10:55
 */

class A {
	static int i = 0;
	final static int j = 0;
}

public class staticData {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(A.i);
		A.i++;
		System.out.println(A.i);
		
		Random random = new Random();
		System.out.println(Math.abs(random.nextInt()%8));
		System.out.println(Math.random());
	}
}
