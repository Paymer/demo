package com.example.demo;

public class Tree {

	
	public static void buildTree (int lines){
		int i=1;
		while (i<=lines){
			espaces (lines, i);
			x(lines, i);
			i++;
		}
	}


	private static void espaces (int n, int i){
		int numEsp = n-(i-1);
		int z = 1;
		String line = new String();
		while (z<=numEsp){
			line = line + " ";
			z++;
		}
		System.out.print(line);
	}

	private static void x (int n, int i){
		int x = 1+(i-1)*2;
		int z = 1;
		String line = new String();
		while (z<=x){
			line = line + "x";
			z++;
		}
		System.out.println(line);
	}
	
}
