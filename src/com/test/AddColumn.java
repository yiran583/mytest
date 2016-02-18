package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月18日 下午2:30:56 3-12
 */
public class AddColumn {
	private static String proCode = "100|200|210|220|230|240|250|270|280|290|311|351|371|431|451|471|531|551|591|571|731|771|791|851|871|891|898|931|951|971|991";

	public static StringBuffer print(String[] proCodes, String temp) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < proCodes.length; i++) {
			for (int j = 12; j <= 12; j++) {
				sb.append(String.format(temp, proCodes[i], j >= 10 ? j : "0" + j)).append("\r\n");
			}
		}
		return sb;
	}

	public static void main(String[] args) throws Exception {
		String temp = "alter table db_ap_rgsh_vertify_log_%s_2015%s ADD COLUMN IS_UPDATE char(1) not null DEFAULT '0' COMMENT '是否在抢单页面由审核人修改过的工单，默认0没有修改，1修改';";
		String[] proCodes = proCode.split("\\|");
		StringBuffer sb = print(proCodes, temp);
		File file = new File("C:\\Users\\Yiran583\\Desktop\\test\\wechat.sql");
		if (!file.exists())
			file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		bw.write(sb.toString());
		bw.close();
	}
}
