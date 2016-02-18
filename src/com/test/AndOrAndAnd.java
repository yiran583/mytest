package com.test;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年10月31日 下午4:03:32
 */
public class AndOrAndAnd {
	public static void main(String[] args) {
		int a = 1;
		int b = 3;
		
		final StringBuffer  i = new StringBuffer("d");
		i.append('s');
		System.out.println(i.toString());
		
		final int c = 1;
		System.out.println(a & b);
		
		String username = null;
		System.out.println("s".equals(username));
		System.out.println(username.equals("s"));
	}
}
