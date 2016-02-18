package com.test;

/**
 * @author jiaotd
 * @since 2015年9月29日 下午5:14:37
 */
public class Count1num {
	public static int age(int N) {
		int b = 0;
		if (N % 2 != 0) {
			b++;
		}
		if (N > 0) {
			b += age(N / 2);
		}
		return b;
	}

	public static void main(String[] args) {
		int a = 1344234235;
		long start = System.currentTimeMillis();
		System.out.println(Integer.toBinaryString(a));
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(age(a));
	}
}
