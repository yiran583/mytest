package com.test.permutation;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月31日 下午5:28:52
 */
public class MethodOne {

	public static int[] convert(String str) {
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.valueOf(str.substring(i, i + 1));
		}
		return arr;
	}

	public static void one(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j])
					continue;
				for (int k = 0; k < a.length; k++) {
					if (a[i] == a[k] || a[j] == a[k]) {
						continue;
					} else
						System.out.println("" + a[i] + a[j] + a[k]);
				}
			}
			System.out.println("--");
		}
	}

	public static void main(String[] args) {
		String str = "1234";
		int[] convert = convert(str);
		one(convert);
	}
}
