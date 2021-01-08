package com.algorithm.a;

import java.util.Scanner;

public class Main_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*알파벳개수
		 * 알파벳 소문자로만 이루어진 단어s가 주어진다.
		 * 각 알파벳이 단어에 몇 개가ㅏ 포함되어 있는지 구하는 프러그램을 작성하세요.
		 *첫 째줄에 단어 s가 주어진다. 단어의 길이는 100을 넘지 
		  않는다. */
		
      Scanner sc = new Scanner(System.in);
      int alphabet [] = new int[26]; //알파벳 
      String s = sc.next();
      char ad = 'a';
      char d; 
      int j;
      int calculation;
      char dt; 
      for(int i =0; i<s.length(); i++) {
    	    d  = s.charAt(i); //char형으로 입력되기 
    	  
    	    dt = (char) (d +ad);
             j = dt-'0';
            calculation = j-146;
            alphabet[calculation]++;
      }
      
      for(int i=0; i<alphabet.length; i++) {
    	  System.out.print(alphabet[i]+" ");
      }
   
 
   
		
	}

}
