package com.test.permutation;

import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2 ,3};
		permute(array, 0);
	}

	public static void permute(int a[], int s) {
		if (s == a.length) {
			System.out.println(Arrays.toString(a));
		} else
			for (int i = s; i < a.length; ++i) {
				swap(a, s, i);
				permute(a, s + 1);

				swap(a, s, i);

			}
	}

	private static void swap(int[] a, int s, int i) {
		int t = a[s];
		a[s] = a[i];
		a[i] = t;

	}
}
