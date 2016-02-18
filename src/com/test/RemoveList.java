package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月29日 下午4:21:00
 */
public class RemoveList {
	static List<Integer> list = new ArrayList<>();

	public static void init() {
		for (int i = 0; i < 10; i++)
			list.add(i);
	}

	public static void main(String[] args) {
		init();
		for (int i = 0; i < list.size(); i++) {
			if (3 == list.get(i)) {
				list.remove(i);
				i--;
				continue;
			}
			System.out.println(list.get(i));
		}
	}
}
