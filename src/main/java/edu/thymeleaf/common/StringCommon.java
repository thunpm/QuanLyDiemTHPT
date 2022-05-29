package edu.thymeleaf.common;

public class StringCommon {
	
	public static String convertNumberToString(long number, int digit) {
		number += 10000000000000000L;
		String returnedStr = String.valueOf(number);
		
		return returnedStr.substring(returnedStr.length() - digit);
	}

}
