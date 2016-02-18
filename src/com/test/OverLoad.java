package com.test;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月30日 下午3:12:24
 */

class Person {
	public void say() {
		System.out.println("say");
	}

	public void say(int i) {
		System.out.println(i);
	}

	private String say(String s) {
		return s + "aaaaaaa";
	}
}

public class OverLoad extends Person{
	public static void main(String[] args) {
		OverLoad overLoad =  new OverLoad();
		overLoad.say();
	}
}
