package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2920_음계 {
 
	public static void main(String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int[] inputs = new int[8];
	        for (int i = 0; i < inputs.length; i++) {
	            inputs[i] = sc.nextInt();
	        }
	        sc.close();
	         
	        String output = "";
	        for (int i = 0; i < inputs.length - 1; i++) {
	            if (inputs[i] == inputs[i + 1] - 1) {
	                output = "ascending";
	            } else if (inputs[i] == inputs[i + 1] + 1) {
	                output = "descending";
	            } else {
	                output = "mixed";
	                break;
	            }
	        }
	        System.out.println(output);
	    
	}
}

/*
 * 다장조는 c d e f g a b C,  총 8개 음으로 이루어져있다. 
 * 이 문제에서 8개 음은 다은과 같이 숫자로 바꾸어 표기한다. 
 * c는 1로, d는 2로, ... , C를 8로 바꾼다. 
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed이다
 * 연주한 순서가 주어졌을때, 이것이 ascending 인지, descending인지 , 
 * 아니면 mixed인지 판별하는 프로그램을 작성하시오
 * 
 * 입력) 첫째 줄에 8개의 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며 1부터 8까지 숫자가 
 * 한 번씩 등장한다. 
 * 
 * 출력) 첫째 줄에 ascending, descending , mixed 중 하나를 선택한다. 
 * 
 * 
 * 
 */
