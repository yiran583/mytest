package com.test;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月2日 上午11:04:58
 */

class Fi {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class FinalTest {
	public static void main(String[] args) {
		final Fi f = new Fi();
		f.setAge(1);
	}
}
