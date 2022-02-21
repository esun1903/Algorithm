package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 시간초과가 나서 정답을 봤던 문제
 * -> Comparator 를 잘쓰자! */
public class Main_10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	String [][] arr = new String[N][2];
	
	
	for (int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		arr[i][0] = st.nextToken(); // 나이가 입력되고 
	    arr[i][1] = st.nextToken(); // 이름들이 입력됩니다. 
	}// end of for
	
	
		Arrays.sort(arr, new Comparator<String[]>() {
           //나이 순으로 정렬
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
			
		});
		
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	
	
	
	} // end of main

} // end of class


/*
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 
 * 이때, 회원들을 나이가 증가하는 순으로 , 나이가 1보다 크거나 같으며, 200보다 작거나 같은 ㅅ정수미녀
 * 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다
 * 
 * 출력) 첫째 줄부터 총 N개의 줄에 걸쳐 나이순, 나이가 같으면 가입한 술으로 한 줄에 한 명씩 나이와
 * 이름을 공백으로 구분해 출력한다. 
 * 
 * 
 * else if(n == arr[j]) {
				// 만약 나이가 같으면 가입 순으로 바꾸기 
			  if(위치>j) { // j가 적으니 j를 해야함 !!!
				  n= arr[j];
				  위치=j;
			  }else if(위치<j){
				  n= arr[위치];
			  }
			}
 * */
