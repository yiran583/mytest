package stringtokenizer;

import java.util.StringTokenizer;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月16日 上午11:13:08
 */
public class StringtokenizerDemo1 {
	public static void main(String[] args) {
		String str = "The,Java,platform,is the ideal platform for network computing";
		StringTokenizer st = new StringTokenizer(str,",",true);
		System.out.println(st.nextToken("is"));
//		System.out.println(st.countTokens());
//		while (st.hasMoreTokens())
//			System.out.println(st.nextToken(","));
		System.out.println("----------------------------");
	}
}
