package com.test;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月2日 下午2:50:47
 */

class AA {
	AA a = new AA();
	public AA() {
		System.out.println("AA");
	}
}

class BB {
	public BB() {
		System.out.println("BB");
	}
	BB a = new BB();
}

public class test6_11 extends AA {
	public static void main(String[] args) {
		BB a = new BB();
	}
}
