package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author jiaotd
 * @since 2015年9月16日 上午8:58:53
 */
public class DownLoadBaiduCloub {

	// 下载地址
	private static final String path = "http://bj.poms.baidupcs.com/file/b0fae132da9db8421919129c73ffd99f?bkt=p2-nj02-706&fid=1647091862-250528-242998753528360&time=1442388350&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-7oA8nHakU6repGUQx%2FLBZM22DQU%3D&to=bb&fm=Nan,B,M,mn&sta_dx=0&sta_cs=0&sta_ft=zip&sta_ct=0&fm2=Nanjing02,B,M,mn&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=1400b0fae132da9db8421919129c73ffd99f939a36c60000000001ac&sl=80412751&expires=8h&rt=sh&r=951497258&mlogid=809067212&vuk=1647091862&vbdid=1614222821&fin=test.zip&fn=test.zip&slt=pm&uta=0&rtype=1&iv=0&isw=0&dp-logid=234052550299457443&dp-callid=0.1";

	public static File downLaod(String path) throws MalformedURLException {
		int bytesum = 0;
		int byteread = 0;
		File file = null;
		try {
			URL url = new URL(path);
			URLConnection connection = url.openConnection();
			// 从url中获取输入流
			InputStream in = connection.getInputStream();
			// 保存文件
			file = new File("d:/test.zip");
			FileOutputStream out = new FileOutputStream(file);

			// 写文件
			byte[] buffer = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				bytesum += byteread;
				System.out.println(bytesum);
				out.write(buffer, 0, byteread);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static File unzip(File zipFile) {
		// 保存路径
		String path = "d://";
		File dirs = new File(path, zipFile.getName().substring(0, zipFile.getName().indexOf(".")));
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
		File file = null;
		try {
			// zip格式的输入流
			ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
			BufferedInputStream bin = new BufferedInputStream(zipIn);
			// ZIP 文件条目
			ZipEntry entry = null;
			try {
				// 获取压缩文件条目
				while ((entry = zipIn.getNextEntry()) != null && !entry.isDirectory()) {
					// 生成文件
					file = new File(dirs, entry.getName());
					if (!file.exists()) {
						new File(file.getParent()).mkdirs();
					}
					FileOutputStream out = new FileOutputStream(file);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					int b = 0;
					while ((b = bin.read()) != -1) {
						bout.write(b);
					}
					bout.close();
					out.close();
					System.out.println("解压成功");
				}
				bin.close();
				zipIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return dirs;
	}

	public static void main(String[] args) {
		try {
			File file = unzip(downLaod(path));
			System.out.println("文件目录：" + file.getName());

			File[] files = file.listFiles();
			BufferedReader bin = null;
			for (int i = 0; i < files.length; i++) {
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(files[i]), "GBK"));
				String line = null;
				try {
					while ((line = bin.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bin.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
