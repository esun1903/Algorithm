package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		/*
		 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오
		 * 
		 * 1. 길이가 짧은 것부터 2. 길이가 같으면 사전 순으로
		 * 
		 * 입력) 첫째 줄에 단어의 개수 N이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
		 * 주어지는 문자열의 길이는 50을 넘지 않는다. 출력) 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는
		 * 한 번씩만 출력한다.
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String[] word = new String[N];
		String[] result = new String[N];
		for (int i = 0; i < N; i++) {
			int j = i;
			st = new StringTokenizer(br.readLine());
			word[i] = st.nextToken();
			while (j > 0 && word[j - 1].length() > word[j].length()) { // 내 길이가 더 짧다면 서로 바꾸기
				String str = word[j];
				word[j] = word[j - 1];
				word[j - 1] = str;
				j--;
			}
		} // end of for

		Arrays.sort(word, new Comparator<String>() { // 길이가 같다면 사전순으로

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				else {
					return 0;
				}
			}
		});
		System.out.println(word[0]);
		for (int i = 1; i < N; i++ ) {
			if(!word[i].equals(word[i-1]) ) {
			  System.out.println(word[i]);
			}
		} // end of for

	}// end of main

} // end of class
