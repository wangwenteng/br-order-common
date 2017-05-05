package br.order.common.utils;

import java.io.UnsupportedEncodingException;

public class TransCoding {
	/**
	 * 中文传值乱码工具类
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) {

		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
