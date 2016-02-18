package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月4日 下午10:17:46
 */

public class RemoveRepeat {
	public static void main(String[] args) throws IOException {

		String line = "/rgshcore/src/main/java/com/ai/rgshcore/service/ISelectDataService.java";
		System.out.println(line.lastIndexOf("/"));
		System.out.println(line.lastIndexOf(".java"));
		System.out.println(line.substring(line.lastIndexOf("/") + 1, line.lastIndexOf(".java")));

		// setMethod();
		// setMethod2();
		mapMethod();
	}

	private static void mapMethod() throws IOException {
		File file = new File("D:\\23.txt");
		BufferedReader reader = null;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			Map<String, String> rgsh = new HashMap<>();
			Map<String, String> rgshcore = new HashMap<>();
			String str = null;
			while ((str = reader.readLine()) != null) {
				String key = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".java"));
				if (str.lastIndexOf("rgshcore") != -1)
					rgshcore.put(key, str);
				else
					rgsh.put(key, str);
			}

			writer1 = new BufferedWriter(new FileWriter(new File("D:\\rgsh.txt")));
			writer2 = new BufferedWriter(new FileWriter(new File("D:\\rgshcore.txt")));
			for (String s : rgsh.keySet()) {
				writer1.write(rgsh.get(s) + "\n");
			}
			for (String s : rgshcore.keySet()) {
				writer2.write(rgshcore.get(s) + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != writer2)
				writer2.close();

			if (null != writer1)
				writer1.close();

			if (null != reader)
				reader.close();
		}
	}

	private static void setMethod() throws IOException {
		File file = new File("D:\\23.txt");
		BufferedReader reader = null;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			Set<String> rgsh = new TreeSet<>();
			Set<String> rgshcore = new HashSet<>();
			String str;
			while ((str = reader.readLine()) != null) {
				if (str.lastIndexOf("rgshcore") != -1)
					rgshcore.add(str.trim());
				else
					rgsh.add(str.trim());
			}

			writer1 = new BufferedWriter(new FileWriter(new File("D:\\rgsh.txt")));
			writer2 = new BufferedWriter(new FileWriter(new File("D:\\rgshcore.txt")));
			for (String s : rgsh) {
				writer1.write(s + "\n");
			}
			for (String s : rgshcore) {
				writer2.write(s + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != writer2)
				writer2.close();

			if (null != writer1)
				writer1.close();

			if (null != reader)
				reader.close();
		}
	}

	private static void setMethod2() throws IOException {
		File file = new File("D:\\23.txt");
		BufferedReader reader = null;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			Set<String> rgsh = new TreeSet<>();
			Set<String> rgshcore = new HashSet<>();
			String str;
			while ((str = reader.readLine()) != null) {
				if (str.lastIndexOf("rgshcore") != -1)
					rgshcore.add(str.trim());
				else
					rgsh.add(str.trim());
			}

			writer1 = new BufferedWriter(new FileWriter(new File("D:\\rgsh.txt")));
			writer2 = new BufferedWriter(new FileWriter(new File("D:\\rgshcore.txt")));
			for (String s : rgsh) {
				writer1.write(s + "\n");
			}
			for (String s : rgshcore) {
				writer2.write(s + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != writer2)
				writer2.close();

			if (null != writer1)
				writer1.close();

			if (null != reader)
				reader.close();
		}
	}
}
