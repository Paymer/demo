package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hexadecimal numbers
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/yet-another-easy-problem-1f3273a0/
 * 
 * @author paymer
 *
 */
public class Hexa {
	
	
	/**
	 * Devuelve el total de numeros que cumplen con un resultado de la función mayor de uno
	 * 
	 * @param l
	 * @param h
	 * @return
	 */
	public static int hexa (int l, int h) {
		List<Integer> list = new ArrayList<>();
		for(int i=l; i<=h; i++) {
			String hexa = Integer.toHexString(i);
			int b = function(hexa);
			if (gcd(i,b)>1)  {
				list.add(b);
			}
		}

		return list.size();	
	}
	
	/**
	 * Función sumar cada componente de la línea hexadecimal
	 * 
	 * @param hexa
	 * @return
	 */
	public static int  function (String hexa) {
		
		int x = 0;
		for(int i=0; i<hexa.length();i++) {
			x +=Integer.parseInt(Character.toString(hexa.charAt(i)),16);
		}
		return x;
	}
	
	/**
	 * Calculo del maximo commun divisor
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd(int x, int y){

		if(y==0) return x;

		return gcd(y,x%y);

		}
	

}
