package com.test;

/**
 * @author jiaotd
 * @since 2015年9月5日 上午10:44:23
 */
public class Analyze {
	
	public static void main(String[] args){
		int i = 0;
		int j = 0;
		int a = i++;
		int b = ++j;
		System.out.println("a = " + a);
		System.out.println("i = " +(i));
		System.out.println("b = " + b);
		System.out.println("++j = " +(j));
	}
}
