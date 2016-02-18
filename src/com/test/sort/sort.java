package com.test.sort;

/**
 * @author jiaotd
 * @since 2015年10月5日 上午8:24:21
 */
public class sort {
	/**
	 * 冒泡
	 */
	public static int[] maopao(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j + 1];
					a[j + 1] = a[j];
					a[j] = t;
				}
			}
			for (int aa : a) {
				System.out.print(aa + "  ");
			}
			System.out.println("");
		}
		return a;
	}

	/**
	 * 直接插入排序
	 */
	public static int[] zhijieCharu(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				int target = a[i];
				int j = i - 1;
				while (j >= 0 && target < a[j]) {
					a[j+1] = a[j]; // 后移
					j--;
				}
				a[j+1] = target;
			}
			for (int aa : a) {
				System.out.print(aa + "  ");
			}
			System.out.println("");
		}
		return a;
	}

	public static void main(String[] args) {
		int[] num = { 12, 1, 431, 123, 45, 123, 5798};
		// maopao(num);
		zhijieCharu(num);
		for (int a : num) {
			System.out.print(a + "  ");
		}
	}
}
