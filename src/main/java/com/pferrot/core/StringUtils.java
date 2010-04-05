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
}
