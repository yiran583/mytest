package com.test;

/**
 * @author jiaotd
 * @since 2015年9月18日 下午4:38:52
 */
public class ComparableDemo implements Comparable<Integer> {

	private Integer digit;

	public Integer getDigit() {
		return digit;
	}

	public void setDigit(Integer digit) {
		this.digit = digit;
	}

	public int compareTo(Integer paramT) {
		return this.digit - paramT;
	}

	public static void main(String[] args) {
		ComparableDemo c = new ComparableDemo();
		c.setDigit(new Integer("2"));
		System.out.println(c.compareTo(new Integer("1")));
	}
}
