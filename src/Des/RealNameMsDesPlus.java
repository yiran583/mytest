package Des;


import java.security.Key;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;

/**
 * 
* @ClassName: RealNameMsDesPlus 
* @Description: DES加密类
* @date 2015年6月30日 下午8:18:08 
*
 */
public class RealNameMsDesPlus {
	private static String strDefaultKey = "DARUF";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	private String byteArrToHexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	private byte[] hexStrToByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 默认构造方法，使用默认密钥
	 * 
	 * @throws Exception
	 */
	public RealNameMsDesPlus() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * 指定密钥构造方法
	 * 
	 * @param strKey
	 *            指定的密钥
	 * @throws Exception
	 *//*
	public RealNameMsDesPlus(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strKey.getBytes());

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}*/
	
	/**
	 * 指定密钥构造方法
	 * 
	 * @param strKey
	 *            指定的密钥
	 * @throws Exception
	 */
	public RealNameMsDesPlus(String strKey) throws Exception {
		String jdkvs = System.getProperty("java.vm.vendor");
		if (null != jdkvs && jdkvs.startsWith("IBM")) {
			Security.addProvider((Provider) Class.forName("com.ibm.crypto.provider.IBMJCE").newInstance());
		}else{
			Security.addProvider((Provider) Class.forName("com.sun.crypto.provider.SunJCE").newInstance());
		}
		Key key = getKey(strKey.getBytes());
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**
	 * 加密字节数组
	 * 
	 * @param arrB
	 *            需加密的字节数组
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	private byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**
	 * 加密字符串
	 * 
	 * @param strIn
	 *            需加密的字符串
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public String encrypt(String strIn) throws Exception {
		return byteArrToHexStr(encrypt(strIn.getBytes("UTF-8")));
	}

	/**
	 * 解密字节数组
	 * 
	 * @param arrB
	 *            需解密的字节数组
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	private byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * 解密字符串
	 * 
	 * @param strIn
	 *            需解密的字符串
	 * @return 解密后的字符串,以UTF-8格式编码
	 * @throws Exception
	 */
	public String decrypt(String strIn) throws Exception {
		return new String(decrypt(hexStrToByteArr(strIn)), "UTF-8");
	}

	/**
	 * @param strIn
	 *            需解密的字符串
	 * @param encode
	 *            解密后的字符编码
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String strIn, String encode) throws Exception {
		return new String(decrypt(hexStrToByteArr(strIn)), encode);
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 * 
	 * @param arrBTmp
	 *            构成该字符串的字节数组
	 * @return 生成的密钥
	 * @throws java.lang.Exception
	 */
	private Key getKey(byte[] arrBTmp) throws Exception {
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}

	/**
	 *RNQDK 为默认密钥，平台会推送密钥到各省（规范5.6）,为了保证数据的安全请用各自的密钥
	 */
	public static void main(String[] args) throws Exception {
		RealNameMsDesPlus desPlus = new RealNameMsDesPlus("DARUF");
		//加密
		String str="20150716140759|111|233|17|测试";
		String str1 = desPlus.encrypt(str);
		System.out.println(str1);
		//解密
	    str1="5dcc44870bc578828a661733d0ad1f1b2fa1f6bb0d1f883ed3130b23793b1a21b8aa3b79e34fe5ce8f9db8bc7fe991826213f89a7ab95050c6e592735ac6295c0db44643eae638997ae0b26445353e55dcd9dbd233733524d64771298bfd127166e23ac2464c49eeeaad8a386677e607";
		String str3=desPlus.decrypt(str1);
		System.out.println(str3);

	}
}
