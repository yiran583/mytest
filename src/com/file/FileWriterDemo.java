package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月17日 上午9:11:29
 */
public class FileWriterDemo {
	public static void writer1(String path) throws Exception {
		File fileIn = new File(path+"out.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileIn));
		
		File fileOut = new File(path+"out_compare.txt");
		if(fileOut.exists())
			fileOut.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		String line = "";
		while((line = br.readLine())!=null){
			bw.write(line.split("\\|")[0]+","+line.split("\\|")[1]+"\r\n");
		}
		bw.close();
		br.close();
	}

	public static void writer2(String path) throws Exception {
		File fileIn = new File(path+"451_732_file.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileIn));
		
		File fileOut = new File(path+"451_732_file_compare.txt");
		if(fileOut.exists())
			fileOut.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		String line = "";
		while((line = br.readLine())!=null){
			bw.write(line.split("\\,")[1]+","+line.split("\\,")[2]+"\r\n");
		}
		bw.close();
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		String path = "C:/Users/Yiran583/Desktop/plcy/compare/";
		writer1(path);
		writer2(path);
	}
}
