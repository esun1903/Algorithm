package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1259_펠린드롬수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j = 0; 
        boolean flag; 
        
		while (true) {
			flag = true;
			String str =br.readLine();
			if (str.equals("0"))
				break;
			else if(str.length()%2 == 0) { // 만약, 길이가 짝수이다 -> 길이/2 
				j = str.length()/2;
				int x = j-1; 
			    for (int i = j; i < str.length();) {
					if(str.charAt(i) !=str.charAt(x)) {
						flag = false; 
						break; 
					}
						 i++;
					     x--;
			    } 
			    if(flag==true) System.out.println("yes");
			    else System.out.println("no");
			}// end of 짝수 
			else { // 길이가 홀수 일때 
				 j = str.length()/2;
					int x = j-1; 
				    for (int i = j+1; i < str.length();) {
						if(str.charAt(i) !=str.charAt(x)) {
							flag = false; 
							break; 
						}
							 i++;
						     x--;
				    } 
				    if(flag==true) System.out.println("yes");
				    else System.out.println("no");
			}
		} // end of while
 

	}

}

/*
 * 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar'. 수도 팰린드롬으로 취급할 수 있다. 각 줄마다
 * 주어진 수가 팰린드롬수면 'yes' , 아니면 'no'를 출력한다.
 */
