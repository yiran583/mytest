package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月17日 下午2:49:24
 */
public class CreateLocalJson {
	public static void createJson() throws Exception {
		// UPDATE OL.DB_AP_PLCY_BUSI_210 T SET
		// T.ISSUING_AUTHORITY = '广东省广州市黄埔区',
		// T.CUSTCERT_ADDRESS = '广东省广州市黄埔区黄埔东路2803号大院32号202房',
		// T.GENDER = '1', T.NATION = '汉族',
		// T.BIRTHDAY = '1975-11-14',
		// T.CERT_RESULT = '0',
		// T.OID = 'xipdnidth',
		// T.PIC_T = '/data03/certfile/44/01/12/440112197511140617.jpg',
		// T.VERIFY_RESULT = '1' WHERE
		// T.CUST_NAME = '张福全' AND
		// T.CUST_CERTNO = '440112197511140617';

		// {seqno=2166294, oid=xipeid3m2, idcode=512301197108168136, name=唐艮禄,
		// origAdress=四川省涪陵地区涪陵市, resultCode=00, gender=男性, birthday=19710816,
		// nationality=汉族, address=南沱镇金鸡村3组27号,
		// picT=/data03/certfile/51/23/01/512301197108168136.jpg}
		File file = new File("C:/Users/Yiran583/Desktop/plcy/19/local");
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[0];
			if (f.getName().indexOf("local") == -1) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
						f.getParent() + f.getName() + "_e") + ".txt"));
				String line = "";
				while ((line = br.readLine()) != null) {
					if (line.indexOf("ISSUING_AUTHORITY") != -1) {
						Pattern p = Pattern.compile("\'(.*?)\'");
						Matcher m = p.matcher(line);
						Map<String, String> map = new HashMap<String, String>();
						int j = 0;
						while (m.find()) {
							map.put(j + "", m.group(1));
							j++;
						}
						j = 0;
						StringBuffer sb = new StringBuffer();
						sb.append("{seqno=").append(map.get(""));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		String str = "UPDATE OL.DB_AP_PLCY_BUSI_210 T SET T.ISSUING_AUTHORITY   = '广东省广州市黄埔区',  T.CUSTCERT_ADDRESS   = '广东省广州市黄埔区黄埔东路2803号大院32号202房',  T.GENDER   = '1',  T.NATION   = '汉族',  T.BIRTHDAY   = '1975-11-14',  T.CERT_RESULT   = '0',  T.OID   = 'xipdnidth',  T.PIC_T   = '/data03/certfile/44/01/12/440112197511140617.jpg',  T.VERIFY_RESULT     = '1'  WHERE T.CUST_NAME  = '张福全' AND T.CUST_CERTNO   = '440112197511140617';";

		Pattern p = Pattern.compile("\'(.*?)\'");
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
