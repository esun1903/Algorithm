package com.ssafy.algo;

import java.util.Scanner;

public class Main_2789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = "CAMBRIDGE";
		String input = sc.next(); // LOVA
		char[] input_arr = new char[input.length()];
		char[] result = new char[input.length()];
        int count = 0; 
        int result_index = 0;
        for (int i = 0; i < input.length(); i++)
			input_arr[i] = input.charAt(i); // LAAAL
 
		for (int i = 0; i < input_arr.length; i++) { 
			 count = 0; // LAAAL
			for (int j = 0; j < str.length(); j++) { // CAMBRIDGE
			 if(input_arr[i] == str.charAt(j))
				 count ++;
             
			 if(count == 0&& j==str.length()-1) {
			 if (input_arr[i] != str.charAt(j)) { // if) LAAAL , CAMBRIDGE
					result[result_index] = input_arr[i];  
					result_index++;
				}
			 }
			}
		}
		for (int i = 0; i<result.length; i++) {
		    if(result[i] >='A')
			System.out.print(result[i]);
		}
	}

}
