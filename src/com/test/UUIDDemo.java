package com.test;

import java.util.UUID;

/**
 * @author jiaotd@asiainfo.com
 * @since 2016年1月18日 下午3:42:05
 */
public class UUIDDemo {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}
}
