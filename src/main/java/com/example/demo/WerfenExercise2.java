package com.example.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WerfenExercise2 {
	
	private static final String NORTH = "NORTH";
	private static final String SOUTH = "SOUTH";
	private static final String WEST = "WEST";
	private static final String EAST = "EAST";

	
	/**
	 * Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed.
	 * 
	 * @param arr
	 * @return
	 */
    public static String[] dirReduc(String[] arr) {
    	List<String> reduc = new LinkedList<String>(Arrays.asList(arr));
    	
    	int before = reduc.size();
    	int after = 0;
    	
    	while (before != after) {
    		before = reduc.size();
        	reduc = reduction(reduc);
        	after = reduc.size();
    	}

        Object[] objectAarray = reduc.toArray();
        int length = objectAarray.length;
        String [] stringArray = new String[length];
        for(int i =0; i < length; i++) {
           stringArray[i] = (String) objectAarray[i];
        }
        
        return stringArray;
    }
    
    /**
     * Removal of the opposite options
     * 
     * @param reduc
     * @return
     */
    public static List<String> reduction (List<String> reduc) {
 
    	for (int i = 1; i<reduc.size(); i++) {
    		if (isOpposite(reduc.get(i-1), reduc.get(i))) {
    			reduc.remove(i);
    			reduc.remove(i-1);
    		}
    	}
    	return reduc;
    }
    
    /**
     * Given two directions this method will validate that  they are not opposites
     * 
     * @param dir1
     * @param dir2
     * @return
     */
    public static boolean isOpposite (String dir1, String dir2) {
    	
    	if (!dir1.equals(dir2)) {
    		List<String> dirs = Arrays.asList(dir1, dir2);
    
    		return (dirs.contains(SOUTH) && dirs.contains(NORTH)) || (dirs.contains(WEST) && dirs.contains(EAST));
    	}
    	return false;
    }

}
