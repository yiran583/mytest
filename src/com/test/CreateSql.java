package com.test;

/**
 * @author jiaotd
 * @since 2015年8月31日 下午7:14:59
 */
public class CreateSql {
	private static String provCode = "100|200|210|220|230|240|250|270|280|290|311|351|371|431|451|471|531|551|591|571|731|771|791|851|871|891|898|931|951|971|991";

	public static void createAddColumnSql(String table, String column, String type, String desc) {
		System.out.println("ALTER TABLE " + table + " ADD COLUMN " + column + " " + type + " COMMENT '" + desc + "'");
	}
	
	public static void createAddColumnSql2(String table, String column) {
		for (String prov : provCode.split("\\|")) {
			for (int i = 1; i <= 12; i++) {
				System.out.println("ALTER TABLE " + table + "_" + prov + "_2016" + (i < 10 ? ("0" + i) : i) +" "+ column+";");
			}
		}
	}
	
	public static void createAddColumnSql3(String table) {
		for (String prov : provCode.split("\\|")) {
			for (int i = 1; i <= 2; i++) {
				System.out.println("create table " + table + "_" + prov + "_2016" + (i < 10 ? ("0" + i) : i) +" LIKE "+ table+";");
			}
		}
	}
	
	public static void createAddColumnSql4(String table) {
		for (String prov : provCode.split("\\|")) {
			for (int i = 9; i <= 11; i++) {
				System.out.println("alter table " + table + "_" + prov + "_2015" + (i < 10 ? ("0" + i) : i) +" change MS_PHONE OPERATOR_OPCODE varchar(20);");
			}
		}
	}

	
	public static void createAddColumnSql5(String table, String column) {
		for (int i = 1; i <= 12; i++) {
			System.out.println("ALTER TABLE " + table + "_371_2013" + (i < 10 ? ("0" + i) : i) + " " + column + ";");
		}
	}
	
	public static void main(String[] args) {
		createAddColumnSql2("db_ap_rgsh_vertify_log","ADD COLUMN VIN VARCHAR(20) COMMENT '车辆识别代号',ADD COLUMN PIC_NAME_V VARCHAR(20) COMMENT '行驶证图片路径',ADD COLUMN OWNER_NAME VARCHAR(20) COMMENT '车主姓名 '");
		
	}
}
