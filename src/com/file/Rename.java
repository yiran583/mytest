package com.file;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月10日 上午10:11:58
 */
public class Rename {
	public static void main(String[] args) {
		File file = new File("E:\\视频学习\\Strust");
		File[] files = file.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".avi");
			}
		});
		for (int i = 0; i < files.length; i++) {
			// System.out.println(files[i].getName());
			files[i].renameTo(new File("E:\\视频学习\\Strust\\" + (i < 9 ? "0" + (i + 1) : i + 1) + "-" + files[i].getName()));
		}
		
	}
}
