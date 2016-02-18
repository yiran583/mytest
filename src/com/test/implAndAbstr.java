package com.test;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月1日 上午10:43:31
 */

interface B {
}

interface B2 {
}

public class implAndAbstr implements B, B2 {
	public static void main(String[] args) {
		B b = new implAndAbstr();
		B2 b1 = new implAndAbstr();
	}
}
