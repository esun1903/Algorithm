package com.algorithm.a;

import java.util.Scanner;

public class Main_13235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 팰린드롬

		/*
		 * 팰린드롬은 앞에서부터 읽을 때와 뒤에서부터 읽을 때가 똑같은 단어를 의미한다. 예를 들어, eve, eevee 는 팰린드롬 , eeve는
		 * 팰린드롬이 아니다. 단어가 주어졌을 떄, 팰린드롬인지 아닌지 판단해보자 길이가 20보다 작거나 같은 단어가 주어진다. 단어는 알파벳
		 * 소문자로 이루어져있다.
		 */

		Scanner sc = new Scanner(System.in);

		String str = sc.next(); // a, eevee ,owo , bbbbbbbbb

		int length = str.length();
        boolean flag = true;
		if (str.length() == 1)
			 System.out.println(flag);
		else {
			for (int i = 0; i < length / 2; i++) {

				if (str.charAt(i) != str.charAt(length - 1 - i)) {
					flag  = false;
				     break;
				}
				
				
			}
			System.out.println(flag);
			}
		}

	}
