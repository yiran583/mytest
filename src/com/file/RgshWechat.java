package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月25日 上午11:15:35
 */
public class RgshWechat {

	public static void createFile() throws Exception {
		File in = new File("C:/rgshcore.txt");
		File out = new File("C:/Users/Yiran583/Desktop/rgsh/out.txt");

		List<Set<String>> list = new ArrayList<Set<String>>();
		
		Set<String> QDSet = new TreeSet<String>();QDSet.add("QD");
		Set<String> readySet = new TreeSet<String>();readySet.add("ready");
		Set<String> intoSet = new TreeSet<String>();intoSet.add("into");
		Set<String> querySet = new TreeSet<String>();querySet.add("query");
		Set<String> updateSet = new TreeSet<String>();updateSet.add("update");
		Set<String> insert1Set = new TreeSet<String>();insert1Set.add("insert1");
		Set<String> insert2Set = new TreeSet<String>();insert2Set.add("insert2");
		Set<String> insert3Set = new TreeSet<String>();insert3Set.add("insert3");
		Set<String> deleteSet = new TreeSet<String>();deleteSet.add("delete");
		Set<String> OkSet = new TreeSet<String>();OkSet.add("OK");
		
		list.add(QDSet);
		list.add(readySet);
		list.add(intoSet);
		list.add(querySet);
		list.add(updateSet);
		list.add(insert1Set);
		list.add(insert2Set);
		list.add(insert3Set);
		list.add(deleteSet);
		list.add(OkSet);
		
		BufferedReader br = new BufferedReader(new FileReader(in));
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		
		String line = "";
		while((line = br.readLine())!=null){
			addList(list,line);
		}
		
		int length = list.size();
		for(int i=0;i<length;i++){
			bw.write("===============================\r\n");
			Set<String> set = list.get(i);
			for(String s : set){
				bw.write(s+"\r\n");
			}
		}
		
		bw.close();
		br.close();

	}

	private static void addList(List<Set<String>> list, String line) {
		if(line.indexOf("######")!=-1){
			if(line.indexOf("QD######")!=-1){
				list.get(0).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("ready######")!=-1){
				list.get(1).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("into######")!=-1){
				list.get(2).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("query######")!=-1){
				list.get(3).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("update######")!=-1){
				list.get(4).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("insert1######")!=-1){
				list.get(5).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("insert2######")!=-1){
				list.get(6).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("insert3######")!=-1){
				list.get(7).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("delete######")!=-1){
				list.get(8).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}else if(line.indexOf("OK######")!=-1){
				list.get(9).add(line.substring(line.lastIndexOf("#")+1, line.length()));
			}
		}
	}

	
	public static void page() {
		Set<String> page = new TreeSet<String>();

		page.add("展示:14489365272170067642");
		page.add("发送:14489365272170067642");
		page.add("发送:14489365272170067642");
		page.add("展示:14489365914400067754");
		page.add("发送:14489365914400067754");
		page.add("发送:14489365914400067754");
		page.add("展示:14489365982350066585");
		page.add("展示:14489366519090067685");
		page.add("发送:14489366519090067685");
		page.add("发送:14489366519090067685");
		page.add("发送:14489366519090067685");
		page.add("展示:14489366867920067697");
		page.add("展示:14489366988720068003");
		page.add("发送:14489366988720068003");
		page.add("发送:14489366988720068003");
		page.add("发送:14489366988720068003");
		page.add("展示:14489367131180067787");
		page.add("展示:14489367251930067794");
		page.add("发送:14489367251930067794");
		page.add("发送:14489367251930067794");
		page.add("发送:14489367251930067794");
		page.add("发送:14489367251930067794");
		page.add("发送:14489367251930067794");
		page.add("展示:14489367292330067796");
		page.add("发送:14489367292330067796");
		page.add("展示:14489367568350068025");
		page.add("发送:14489367568350068025");
		page.add("展示:14489367594180067724");
		page.add("发送:14489367594180067724");
		page.add("展示:14489367876470067864");
		page.add("发送:14489367876470067864");
		page.add("展示:14489367879730066642");
		page.add("展示:14489367957920067730");
		page.add("发送:14489367957920067730");
		page.add("发送:14489367957920067730");
		page.add("发送:14489367957920067730");
		page.add("展示:14489368022510067812");
		page.add("发送:14489368022510067812");
		page.add("发送:14489368022510067812");
		page.add("展示:14489368061820068042");
		page.add("发送:14489368061820068042");
		page.add("展示:14489368204880067872");
		page.add("展示:14489368221360066657");
		page.add("发送:14489368221360066657");
		page.add("发送:14489368221360066657");
		page.add("发送:14489368221360066657");
		page.add("展示:14489368230390067742");
		page.add("发送:14489368230390067742");
		page.add("发送:14489368230390067742");
		page.add("发送:14489368230390067742");
		page.add("展示:14489368230540068046");
		page.add("发送:14489368230540068046");
		page.add("发送:14489368230540068046");
		page.add("发送:14489368230540068046");
		page.add("展示:14489368319300068049");
		page.add("发送:14489368319300068049");
		page.add("发送:14489368319300068049");
		page.add("展示:14489368348100067746");
		page.add("展示:14489368364040067823");
		page.add("发送:14489368364040067823");
		page.add("发送:14489368364040067823");
		page.add("展示:14489368443510067887");
		page.add("展示:14489368517700067750");
		page.add("发送:14489368517700067750");
		page.add("展示:14489368692300067886");
		page.add("发送:14489368692300067886");
		page.add("发送:14489368692300067886");
		page.add("发送:14489368692300067886");
		page.add("展示:14489368739270067896");
		page.add("发送:14489368739270067896");
		page.add("发送:14489368739270067896");
		page.add("发送:14489368739270067896");
		page.add("展示:14489368779810067898");
		page.add("发送:14489368779810067898");
		page.add("发送:14489368779810067898");
		page.add("展示:14489368794020068068");
		page.add("发送:14489368794020068068");
		page.add("展示:14489368880380066681");
		page.add("发送:14489368880380066681");
		page.add("发送:14489368880380066681");
		page.add("展示:14489368892040068070");
		page.add("展示:14489368968480067896");
		page.add("发送:14489368968480067896");
		page.add("展示:14489369013640067906");
		page.add("发送:14489369013640067906");
		page.add("发送:14489369013640067906");
		page.add("发送:14489369013640067906");
		page.add("展示:14489369062510067843");
		page.add("发送:14489369062510067843");
		page.add("发送:14489369062510067843");
		page.add("展示:14489369198740068084");
		page.add("发送:14489369198740068084");
		page.add("发送:14489369198740068084");
		page.add("展示:14489369202210067847");
		page.add("展示:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("发送:14489369230360066691");
		page.add("展示:14489369245300067769");
		page.add("发送:14489369245300067769");
		page.add("展示:14489369256540066693");
		page.add("发送:14489369256540066693");
		page.add("展示:14489369429170067776");
		page.add("发送:14489369429170067776");
		page.add("展示:14489369467930067865");
		page.add("发送:14489369467930067865");
		page.add("发送:14489369467930067865");
		page.add("展示:14489369476920067924");
		page.add("发送:14489369476920067924");
		page.add("发送:14489369476920067924");
		page.add("发送:14489369476920067924");
		page.add("展示:14489369479190066702");
		page.add("发送:14489369479190066702");
		page.add("展示:14489369534590067869");
		page.add("展示:14489369548360068091");
		page.add("发送:14489369548360068091");
		page.add("发送:14489369548360068091");
		page.add("展示:14489369649480067932");
		page.add("发送:14489369649480067932");
		page.add("展示:14489369717210067785");
		page.add("发送:14489369717210067785");
		page.add("展示:14489369731280067924");
		page.add("发送:14489369731280067924");
		page.add("发送:14489369731280067924");
		page.add("发送:14489369731280067924");
		page.add("展示:14489369816440066715");
		page.add("发送:14489369816440066715");
		page.add("发送:14489369816440066715");
		page.add("展示:14489369823890067938");
		page.add("发送:14489369823890067938");


		for (String s : page) {
			if (s.indexOf("展示") != -1)
				System.out.println(s.substring(3, s.length()));
		}
		System.out.println("++++++++++++++++++++++++++++++++++++");
		for (String s : page) {
			if (s.indexOf("发送") != -1)
				System.out.println(s.substring(3, s.length()));
		}

	}
	
	public static void remove() {
		Set<String> page = new TreeSet<String>();

		page.add("14489335918000066829");
		page.add("14489335918000066829");
		page.add("14489336095060066767");
		page.add("14489336095060066767");
		page.add("14489336173330066770");
		page.add("14489336173330066770");
		page.add("14489336285600066967");
		page.add("14489336361480066968");
		page.add("14489336515660066720");
		page.add("14489336515660066720");
		page.add("14489337108470065660");
		page.add("14489337108470065660");
		page.add("14489337123640066797");
		page.add("14489337163060065663");
		page.add("14489337211770066878");
		page.add("14489337211770066878");
		page.add("14489337287440066887");
		page.add("14489337287440066887");
		page.add("14489337367770065671");
		page.add("14489337383250066750");
		page.add("14489337454560066751");
		page.add("14489337454560066751");
		page.add("14489337635300067015");
		page.add("14489337879570065688");
		page.add("14489337879570065688");
		page.add("14489337908730066822");
		page.add("14489337912970066823");
		page.add("14489338087060066774");
		page.add("14489338087060066774");
		page.add("14489338138120067032");
		page.add("14489338138120067032");
		page.add("14489338138120067032");
		page.add("14489338173440066776");
		page.add("14489338197500066920");
		page.add("14489338197500066920");
		page.add("14489338243640067033");
		page.add("14489338335250066837");
		page.add("14489338590450066878");
		page.add("14489338590450066878");
		page.add("14489338782590066847");
		page.add("14489338830580066941");
		page.add("14489338938680066795");
		page.add("14489338938680066795");
		page.add("14489339010720067056");
		page.add("14489339175280066898");
		page.add("14489339204500066951");
		page.add("14489339250650066901");
		page.add("14489339250650066901");
		page.add("14489339366320066874");
		page.add("14489339409680067075");
		page.add("14489339431250066807");


		for (String s : page) {
			System.out.println(s);
		}

	}
	
	
	
	public static void main(String[] args) throws Exception {
		//createFile();
		page();
		//remove();
	}
}
