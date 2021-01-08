package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_SW_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		
         for (int t = 1; t <=T ; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int C = N/4;  // 한변의 길이 : 2-7 ==> 회전횟수 결정 
			int K = Integer.parseInt(st.nextToken()); 
			char [] nums= in.readLine().toCharArray();
			
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1); // 정수일때 : o2-o1
				}
			});
			
			int c = 0; 
			while(++c<C) { // 회전관련 처리 C번
			 
				//현 상태에서 각 변의 길이만큼의 문자열비밀번호 추출하여 set에 넣기 
				for (int i = 0; i < N; i+=C) {
					String s = "";
					for (int j = 0; j <C; j++) {
						s+= nums[i+j];
					}
				}
				
			}
		}

	}

}
