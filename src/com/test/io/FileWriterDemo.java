package com.test.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author jiaotd
 * @since 2015年10月9日 下午8:55:36
 */
public class FileWriterDemo {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("d://text.txt");
			int length = 0;
			char[] buf = new char[1024];
			length = reader.read(buf);
			System.out.println(length);
			System.out.println(new String(buf));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
