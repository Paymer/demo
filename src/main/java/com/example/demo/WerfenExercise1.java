package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author payme
 *
 */
public class WerfenExercise1 {

	/**
	 * 
	 * Complete the function which takes two arguments and returns all numbers which are divisible by the given divisor. 
	 * First argument is an array of numbers and the second is the divisor.
	 * 
	 * @param numbers
	 * @param divider
	 * @return
	 */
	  public static int[] divisibleBy(int[] numbers, int divider) {
		  
		  //generación de la lista de numeros divisibles
		  List<Integer> list = new ArrayList<>();
		  for (int i=0; i<numbers.length;i++) {
			  if (numbers[i]%divider==0 ) {
				  list.add(numbers[i]);
			  }
		  }
		  
		return ListToArray(list);  
	  }
	  
	  /**
	   * List of Integers to int[i]
	   * 
	   * @param list
	   * @return int[]
	   */
	  public static int[] ListToArray (List<Integer> list) {
		  int[] array = new int[list.size()];
		  for(int i = 0;i < array.length;i++) {
			  array[i] = list.get(i);
		  }
		  return array;
	  }
}
