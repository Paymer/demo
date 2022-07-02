package com.example.demo;
/**
 * 
 * Your task is to create a function that turns a string into a Wave. 
 * You will be passed a string and you must return that string in an array where an uppercase letter is a person standing up.
 * 
 * @author payme
 *
 */
public class WerfenExercise3 {
	
	/**
	 * 1.  The input string will always be lower case but maybe empty.
	 * 2.  If the character in the string is whitespace then pass over it as if it was an empty seat.
	 * 
	 * @param str
	 * @return
	 */
    public static String[] wave(String str) {
    	
    	int nspaces = str.length() - str.replaceAll(" ", "").length();
    	String[] result = new String[str.length()-nspaces];
    	
    	int spaces = 0;
    	for (int i=0; i<str.length(); i++) {
    		if (' ' != str.charAt(i)) {
    			Character ch = str.charAt(i);
        		result[i-spaces] = str.substring(0,i)+Character.toUpperCase(ch)+str.substring(i+1,str.length());	
    		}  else {
    			spaces++;
    		}
    	}
        return result;
    }


}
