package com.caoO.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class for Encrypting
 * @author caoO
 *
 */
public class MD5 {
	/**
	 * Encrypt the appointed string by MD5
	 * @param plainText original string
	 * @return encrypted string
	 */
	public static String encrypt(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有找到MD5算法！");
		}
		String md5Code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5Code.length(); i++) {
			md5Code = "0" + md5Code;
		}
		return md5Code;
	}
}
