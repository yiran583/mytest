package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiaotd
 * @since 2015年8月31日 下午5:32:07
 */
public class Before5minutes {
	public static void main(String[] args) throws Exception {
		String acceptDate = "2015-08-31 17:38:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(acceptDate);
		System.out.println((new Date().getTime()-date.getTime())/(60*1000)<=5);
	}
}
