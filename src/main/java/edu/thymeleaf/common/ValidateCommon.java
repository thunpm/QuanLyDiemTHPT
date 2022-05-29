package edu.thymeleaf.common;

public class ValidateCommon {

	public static boolean checkRequiredFileds (String...strings) {
		String[] strs = strings;
		
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == null || "".equals(strs[i])) {
				return false;
			}
		}	
		return true;
		
	}
}
