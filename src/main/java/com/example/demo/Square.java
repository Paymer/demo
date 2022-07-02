package com.example.demo;

/**
 * You're a square!
 * 
 * @see https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
 * @author payme
 *
 */

public class Square {
	  
	    public static boolean isSquare(int n) { 
	    	
		    double raiz = 	Math.sqrt(n);
	
		    return Math.rint(raiz) == raiz;

	    }
	

}
