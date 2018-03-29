package com.caoO.upload;

import java.util.UUID;

public class FileUUIDUtils {
	/**
	 * To get a unique fileName by the appointed fileName
	 * @param fileName
	 * @return unique fileName
	 */
	public static String getFileUUID(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		String suffix = fileName.substring(lastIndex, fileName.length());
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid + suffix;
	}
	
	/**
	 * To get the suffix of the appointed fileName
	 * @param fileName
	 * @return suffix
	 */
	public static String getSuffix(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		String suffix = fileName.substring(lastIndex, fileName.length());
		return suffix;
	}
}
