package com.example.demo;

/**
 * Mumbling!
 * 
 * 
 * @see https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/java
 * @author payme
 *
 */
public class Mumbling {
	
	public static String accum(String s) {
		StringBuilder accum = new StringBuilder();
		for (int i=0; i < s.length(); i++) {
			Character ch =	s.charAt(i);
			accum = i==0? accum.append(String.valueOf(Character.toUpperCase(ch))) : accum.append("-" + Character.toUpperCase(ch));
				for (int j=0; j<=i-1; j++) {
					accum = accum.append(Character.toLowerCase(ch));
				}
		}
		return accum.toString();
	    }

}
