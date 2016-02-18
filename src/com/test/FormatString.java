package com.test;

import java.util.Calendar;

/**
 * @author jiaotd
 * @since 2015年9月23日 下午7:05:43
 */
public class FormatString {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();  
		String s = String.format("今天是：%1$tY年%1$tm月%1$te日", c);
		System.out.println(s);
		
		String a = null;
		System.out.println(String.format("输出%s结果", a));
	}
}
