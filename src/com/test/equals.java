package com.test;

import java.math.BigInteger;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月27日 上午11:25:01
 */

class Value {
	int i = 47;

	/*
	 * public boolean equals(Object paramObject) { if (paramObject instanceof
	 * Value) { return ((Value) paramObject).i == i; } return false; }
	 * 
	 * public int hashCode() { super.hashCode(); return i; }
	 */
}

public class equals {
	public static void main(String[] args) {
		/*Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		System.out.println(v1.equals(v2));

		int a = -2;
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(1));

		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(2));
		int i = -1;
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(3)); 
		System.out.println("-------");
		System.out.println(Integer.parseInt("10000000000000000000000000001",2));
		
		BigInteger src1= new BigInteger("1000000000000000000000000000001",2);
		System.out.println(src1.toString());
		
		i >>>= 10;
		System.out.println(i);
		long l = -1;
		l >>>= 10;
		System.out.println(l);
		short s = -1;
		s >>>= 10;
		System.out.println(s);
		byte b = -1;
		b >>>= 10;
		System.out.println(b);*/
		
		System.out.println(2&3);
		
	}
}
