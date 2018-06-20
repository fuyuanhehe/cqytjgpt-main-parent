package com.ccttic.util.common;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
   功能说明：     基于DES方式的加密、解密工具类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.helper.DESHelper.java
 @date  2016年12月3日
 */
public class DESHelper {
	private final Logger logger = LoggerFactory.getLogger(DESHelper.class);
	private static DESHelper instance;
	//DES密钥字符串
	private static final String strDefaultKey = "CQYTJGPT";
	//加密对象
	private Cipher encryptCipher = null;
	//解密对象
	private Cipher decryptCipher = null;

	/**
	 * DES构造方法
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	private DESHelper() throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		String strKey = strDefaultKey;
		logger.debug("strKey=" + strKey);
		Key key = getKey(strKey.getBytes());
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**
	 * 利用单利模式获取一个DESPlus对象
	 * 
	 * @return DESPlus
	 *		-DESPlus对象	
	 * @throws Exception
	 */
	public static synchronized DESHelper getInstance() throws Exception {
		if (ObjectHelper.isEmpty(instance))
			instance = new DESHelper();
		return instance;
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 * 
	 * @param arrBTmp
	 *      -构成该字符串的字节数组
	 * @return Key
	 * 		-生成的密钥
	 * @throws Exception
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
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和private byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *      -需要转换的byte数组
	 * @return String
	 * 		-转换后的字符串
	 * @throws Exception
	 */
	private String byteArr2HexStr(byte[] arrB) throws Exception {
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
	 * 将表示16进制值的字符串转换为byte数组， 和private String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *      -需要转换的字符串
	 * @return byte[]
	 * 		-转换后的byte数组
	 * @throws Exception
	 */
	private byte[] hexStr2ByteArr(String strIn) throws Exception {
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
	 * 加密字节数组
	 * 
	 * @param arrB
	 *      -需加密的字节数组
	 * @return byte[]
	 * 		-加密后的字节数组
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**
	 * 加密字符串
	 * 
	 * @param strIn
	 *      -需加密的字符串
	 * @return String
	 * 		-加密后的字符串
	 * @throws Exception
	 */
	public String encrypt(String strIn) throws Exception {
		if (ObjectHelper.isEmpty(strIn))
			return null;
		return byteArr2HexStr(encrypt(strIn.trim().getBytes()));
	}

	/**
	 * 解密字节数组
	 * 
	 * @param arrB
	 *      -需解密的字节数组
	 * @return byte[]
	 * 		-解密后的字节数组
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * 解密字符串
	 * 
	 * @param strIn
	 *      -需解密的字符串
	 * @return String
	 * 		-解密后的字符串
	 * @throws Exception
	 */
	public String decrypt(String strIn) throws Exception {
		if (ObjectHelper.isEmpty(strIn))
			return null;
		return new String(decrypt(hexStr2ByteArr(strIn.trim())));
	}

	
	/**
	 * 加密字符串
	 * 
	 * @param ms
	 *            -加密密钥
	 * @param str
	 *            -加密字符串
	 * @return String -加密后的字符串
	 * @throws Exception
	 */
	public static String str2HexStr(String ms, String str) {
		if (ms == null || ms.equals("") || str == null) {
			return str;
		}
		char[] chars = ms.toCharArray();
		StringBuilder sb = new StringBuilder();
		byte[] bs = str.getBytes();
		for (int i = 0; i < bs.length; ++i) {
			int bit = (bs[i] & 0xF0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0xF;
			sb.append(chars[bit]);
		}
		return sb.toString();
	}
}