package org.exercises.string.replacement;

/**
 * Write a Java program to replace certain characters from String like
 * Read more: http://www.java67.com/2012/08/10-java-coding-interview-questions-and.html#ixzz58353AXg7
 * @author Tuany
 */
public class StringReplace {
	
	/**
	 * Replace the given char for new char in a string using iterative solution.
	 * If parameters are blank or empty, return the given string.
	 * 
	 * THIS METHOD IS CASE SENSITIVE
	 *  
	 * @param str Original {@link String} where char should be replaced
	 * @param ch char that should be replaced
	 * @param nch new char
	 * @return {@link String}
	 */
	public static String replaceIterative(String str, char ch, char nch) {
		
		// null checks
		if(str == null || str.length() == 0) return str;
		if((Character.MIN_VALUE == ch || Character.MIN_VALUE == nch) || ch == nch) return str;
		
		// check if the char to be replaced exists in the string
		if(str.indexOf(ch) < 0) return str;
		
		int n = str.length();
		int start = 0;
		int end = str.indexOf(ch);
		StringBuilder strb = new StringBuilder(str.length());
		
		while(end < n && end >= 0) {
			strb.append(str.substring(start, end)).append(nch);
			start = end + 1;
			end = str.indexOf(ch, start);
		}
		strb.append(str.substring(start));
		return strb.toString();
	}
	
	public static String replaceRecursive(String str, char ch, char nch) {
		// null checks
		if (str == null || str.length() == 0) return str;
		if ((Character.MIN_VALUE == ch || Character.MIN_VALUE == nch) || ch == nch) return str;

		// check if the char to be replaced exists in the string
		if (str.indexOf(ch) < 0) return str;

		int start = 0;
		int end = str.indexOf(ch);
		
		StringBuilder strb = new StringBuilder(str.length());
		if(end >= 0) {
			strb.append(str.substring(start, end)).append(nch);
		}
		strb.append(replaceRecursive(str.substring(end + 1), ch, nch));
		return strb.toString();
	}
}
