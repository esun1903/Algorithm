package com.algorithm.a;

import java.util.Scanner;

public class Main_10809_알파벳찾기 {

	static int[] alphabet = new int[26];
    static int n = 97; 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //  baekjoon 
		
		// -1 로 setting 해놓기
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}
	
		// str 하나씩 꺼내면서 넣기 
		for (int i = 0; i < str.length(); i++) {
		   char ch = str.charAt(i);
		   int num = (int)ch - n ;
		   if(alphabet[num]== -1)
		      alphabet[num]  = i; 
		}
		
		// 마지막 출력
		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}

	}

}

/*
 * 알파벳 소문자로만 이루어진 단어 s가 주어진다. 각각의 알파젯에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를 포함되어있지
 * 않은 경우에는 -1를 출력하는 프로그램을 작성하시오
 * 
 * 입력) 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
 * 
 * 출력) 각각의 알파벳에 대해서 , a가 처음 등장하는 위치, b가 처음등장하는 위치 z가 처음 등장하는 위치를 , 포함되어 있지 않은
 * 경우엔 -1 을 출력한다. 단어의 첫 번쨰 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 */
