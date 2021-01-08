package com.algorithm.a;

import java.util.Scanner;

public class Main_1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	
		Scanner sc = new Scanner(System.in);
		
	   int x = sc.nextInt();
	   int y = sc.nextInt();
	   
	    int sum = 0; 
	    int arr[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};  // 월별로 가장 마지막 날을 저장
	    String result[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"}; //요일을 저장 
	 
	    for(int i= 1; i<x; i++) {  //날짜가 3/14이라면, 2월까지 더하기
	    	sum+=arr[i];  
	    }
	    sum+=y; //14를 더한 뒤 나누기 !
	    int  div = sum%7;
	    System.out.println(result[div]);
	    
	     
	}

}
