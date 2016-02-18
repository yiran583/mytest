package com.test;


/**
 * @author jiaotd
 * @since 2015年9月2日 下午10:22:35
 */
public class AgeMore2 {
	public int getAge(int count) {
		if (count == 1) {
			return 10;
		}
		return getAge(count - 1) + 2;
	}

	private static String[] unit = { "","十", "百", "千", "万", };
	private static String[] number = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	
	public String convert(int num){
		String str = "";
		int step = 0;
		while(num!=0){
			int j = num%10;
			num = num/10;
			if(j!=0){
				str = number[j] + unit[step] + str;
			}else if(step != 0 && j==0){
				if(!"零".equals(str.substring(0,1)))
					str = "零" + str;
			}
			step++;
		}
		return str;
	}

	public static void main(String[] args) {
		AgeMore2 a = new AgeMore2();
		System.out.println(a.getAge(8));
		System.out.println(a.convert(19876));
		
	}
}
