package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int arr[][] = new int[4][8];
		int map[][];
		int max = 0;
		char result[]= new char[4];
		int count =0; 
		for (int i = 0; i < 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (max < arr[i][j])
					max = arr[i][j];
			}
		} // end of for

		// 하나씩
		for (int i = 0; i < 1; i++) {
			// 1) 일단 j가 0부터 -> 하나씩 채워넣기
			map = new int[max + 1][max + 1];
            count = 0;
            int count2= 0; 
			int x = arr[i][0];
			int y = arr[i][1];

			// ============
			
			int x2 = arr[i][2];
			int y2 = arr[i][3];
			
			for (int r = y; r < y2; r++) {
				for (int c = x; c < x2; c++) {
                      map[r][c] =1; 
				}
			}
			
			
			int x3 = arr[i][4];
			int y3 = arr[i][5];
			
			//============
			
			int x4 = arr[i][6];
			int y4 = arr[i][7];

			for (int r = y3; r < y4; r++) {
				for (int c = x3; c < x4; c++) {
                     if(map[r][c] == 1) {
                    	 count++;
                    	 map[r][c] = 2; 
                     }
                     else {
                    	 map[r][c] = 2; 
                     }
                      
				}
			}
			
			
			for (int r = y; r < y2; r++) {
				for (int c = x; c < x2; c++) {
                      if(map[r][c] == 2) {
                    	  count++; 
                      }
                      else if(map[r][c]==2 && r == x || r== x2 || c == y || c == y2 ) {
                    	  count2++;
                      }
				}
			}
			
		  
			if(count == 1 ) {
				result[i] = 'c';
			}
			else if(count==0 && count2 >0) {
				result[i] = 'b';
			}
			else if(count == 0 && count2 == 0) {
				result[i] = 'd';
			}
			else {
				result[i] = 'a';
			}
			
			
			
		}
		
		for (int j = 0; j < 4; j++) {
			System.out.println(result[j]);
		}

	}// end of main

}// end of class
