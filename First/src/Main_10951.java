package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_10951 {

	public static void main(String[] args) throws IOException {

		
		Scanner sc =new Scanner(System.in);
		while(sc.hasNextInt()) {
			int one  = sc.nextInt(); 
			int two = sc.nextInt(); 
			
			System.out.println(one+two);
		}// end of while
		sc.close();
	}// end of main

}
