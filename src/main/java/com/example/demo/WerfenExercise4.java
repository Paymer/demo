package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author payme
 *
 */
public class WerfenExercise4 {

	static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	/**
	 * Your task is to add up letters to one letter.
	 * The function will be given an array of single character Strings, each one being a letter to add.
	 * 
	 * @author payme
	 *
	 */
	    public static String addLetters(String... letters) {
	    	
	    	//If it's empty we return z
	    	if(letters.length == 0) {
	    		return "z";
	    	}
	    	
	    	//Calculation of the addition
	    	List<Integer> listValues = new ArrayList<>();
	    	for(int i = 0; i<letters.length; i++) {	
	    		listValues.add(ALPHABET.indexOf(letters[i]));
	    	}
	    
	    	Integer indexAlphabet =  listValues.stream().map(x->x+1).reduce(0, Integer::sum)%26;
	    	
	        return indexAlphabet>0? ALPHABET.substring(indexAlphabet-1, indexAlphabet): ALPHABET.substring(25, 26);
	    }
	}


