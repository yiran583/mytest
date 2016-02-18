package com.test;

/**
 * @author jiaotd
 * @since 2015年10月12日 下午4:14:21
 */

class persen {
	public persen() {
		System.out.println(this.getClass().getName());
	}
	
	public persen(int a) {
		System.out.println(this.getClass().getName());
	}
	
	public static void a(){
	}
}

public class thisIsWhat extends persen{
	public thisIsWhat() {
		super(2);
		System.out.println(this.getClass().getName());
		super.a();
	}
	public static void main(String[] args) {
		new thisIsWhat();
		System.out.println("------------------");
		new persen();
	}
}
