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
	 * @param pParamValue
	 * @param pParamName
	 */
	public static void assertNotEmptyStringParameter(final String pParamValue, final String pParamName) {
		if (pParamValue == null || pParamValue.trim().length() == 0) {
			throw new AssertionError("Parameter is not a valid non-empty string: " + pParamName);
		}
	}
	
	/**
	 * Throws an AssertionError if the parameter is null.
	 * 
	 * @param pParamValue
	 * @param pParamName
	 */
	public static void assertNotNullParameter(final Object pParamValue, final String pParamName) {
		if (pParamValue == null) {
			throw new AssertionError("Parameter must not be null: " + pParamName);
		}
	}
}
