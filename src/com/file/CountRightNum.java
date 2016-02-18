package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 通过数据生成的更新语句与local是否一致
 * @author jiaotd@asiainfo.com
 * @since 2015年12月17日 上午9:47:43
 */
public class CountRightNum {

	public static void countRightNum() throws Exception {
		String path = "C:/Users/Yiran583/Desktop/plcy/19/out";
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			int count = 0;
			File f = files[i];
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.indexOf("T.ISSUING_AUTHORITY") != -1) {
					count++;
				}
			}
			System.out.println(f.getName() + "---------------" + count);
			br.close();
		}
	}

	public static void main(String[] args) throws Exception {
		countRightNum();
	}
}
