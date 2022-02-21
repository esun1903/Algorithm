package com.algorithm.a;

import java.util.Scanner;

public class Main_1157_단어공부 {

	public static void main(String[] args) {
	// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오
    // 단 , 대소문자와 소문자를 구분하지 않는다. 
    // 입력) 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어ㅇ의 길이는 1,000,000 을 넘지 않는다. 
	
    // 출력) 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 
             // ? 를 출력한다. 
		int s[] = new int[26];
		int sn = 97; //  소문자 
		int dn = 65; // 대문자 
		int max = 0; 
		int wi =0; 
		String result = "?";
		Scanner sc = new Scanner(System.in);
		String sentence  =sc.next();
		
	    for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			int num = (int)c ; 
			if (num>=97) { // 만약, 소문자라면?
				num =  num - sn; // 몇 번째인지 
			}else {
				num = num - dn; 
			}
			
			s[num] ++; 		
		} // end of for 
	    
	    for(int i= 0; i<26; i++) {
	    	 if( s[i] > max) {
	    		 max = s[i];
	    		 wi = i; 
	    	 }
	    }
	    int count = 0; 
	    for(int i= 0; i<26; i++) {
	    	if(s[i] == max) {
	    		count ++; 
	    	}
	    }
	    if(count >1) {
	    	System.out.println("?");
	    }else
	    { 
	    	int res = dn + wi; 
	    	System.out.println((char)res);
	    }
	} // end of main

}// end of class
