package com.test.permutation;

public class RandomRange {
	public static void main(String[] args) {
		String str = "123";
		getString("", str);
	}

	private static void getString(String former, String latter) {
		if (latter.length() == 1) {
			System.out.println(former + latter);
		} else {
			int len = latter.length();
			for (int i = 0; i < len; i++) {
				String temp = latter.substring(i, i + 1);
				String tf = former + temp;
				String tl = latter.replace(temp, "");
				getString(tf, tl);
			}
		}
	}
}