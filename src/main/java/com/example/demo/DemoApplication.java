package com.example.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(DemoApplication.class, args);
		/** 
		 * Construir un arbol (triangulo)
		 */
		//Tree.buildTree(8);
		
		/** 
		 * Hexa
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of requests:");  
        int num = Integer.valueOf(br.readLine());
        List<Integer> list = new ArrayList();

        for (int i=1; i<=num; i++){
        	System.out.println("Range:"); 
            String range = br.readLine();
            int h = Integer.valueOf(range.substring(range.indexOf(' ') + 1, range.length())); 
            int l = Integer.valueOf(range.substring(0, range.indexOf(' ')));
            //System.out.println(Hexa.hexa(l,h));   
            //System.out.println(hexa(l,h)); 
            list.add(hexa(l,h));
        }
        list.stream().mapToInt(i -> i).forEach( x -> System.out.println(x));
        
        /*
         * Names
         */
        
	}
	
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
