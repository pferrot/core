package com.pferrot.core;

/**
 * Some utils methods.
 * 
 * @author Patrice
 *
 */
public class CoreUtils {
	
	/**
	 * Throws an AssertionError if the String parameter is null or empty.
	 * 
	 * @param pString
	 */
	public static void assertNotNullOrEmptyString(final String pString) {
		if (pString == null || pString.trim().length() == 0) {
			throw new AssertionError("Not a valid non-empty string.");
		}
	}
	
	/**
	 * Throws an AssertionError if the parameter is null.
	 * 
	 * @param pObject
	 */
	public static void assertNotNull(final Object pObject) {
		if (pObject == null) {
			throw new AssertionError("Null value not allowed.");
		}
	}

	/**
	 * Throws an AssersionError if the parameter is not true.
	 *
	 * @param pBoolean
	 */
	public static void assertTrue(final boolean pBoolean) {
		if (!pBoolean) {
			throw new AssertionError("Value should be true.");
		}
	}

	/**
	 * Throws an AssersionError if the parameter is not true.
	 *
	 * @param pBoolean
	 */
	public static void assertTrue(final Boolean pBoolean) {
		if (! Boolean.TRUE.equals(pBoolean)) {
			throw new AssertionError("Value should be true.");
		}
	}
}
