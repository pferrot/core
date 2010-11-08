package com.pferrot.core;

/**
 * Useful methods for working with String objects.
 *
 * @author pferrot
 *
 */
public class StringUtils {
	
	public static boolean isNull(final String s) {
		return s == null;		
	}

	public static boolean isNullOrEmpty(final String s) {
		return s == null || s.trim().length() == 0;
	}

	public static boolean isNullOrEmptyWithoutTrim(final String s) {
		return s == null || s.length() == 0;
	}
	
	public static String getNullIfEmpty(final String s) {
		if (s == null) {
			return null;
		}
		String temp = s.trim();
		if (temp.length() == 0) {
			return null;
		}
		return temp;
	}
	
	public static String getNullIfEmptyWithoutTrim(final String s) {
		if (s == null) {
			return null;
		}
		if (s.length() == 0) {
			return null;
		}
		return s;
	}
}
