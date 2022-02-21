package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int one = Integer.parseInt(st.nextToken());
		 int two = Integer.parseInt(st.nextToken());
		 int result = gcd(one,two);
		 // 최대공약수를 구하기 
	      System.out.println(result);	 
	     System.out.println((one*two)/result);
	}

	private static int gcd(int one, int two) {
	 
		 if(two==0) return one; 
		 else { 
			 return gcd( two,one%two);
		 }
		
	}
	
	

}
// 두 개의 자연수를 입력받아 최대공약수와 최소공배수를 출력하는 프로그램을 작성하시오 


/* 
유클리드 호제법를 사용하면 시간복잡도를 O(logN) 으로 줄일 수 있다. 
 
  2개의 자연수 a,b에 대해서 
1. a를 b로 나눈 나머지를 r이라고 하면 (단 a>b) , 
2. a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 
3. 이 성질에 따라 b를 r로 나눈 나머지 r0을 구하고 
4. 다시 r을 r0로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을때
나누는 수가 a와 b의 최대공약수이다. 이는 명시적으로 기술된 가장 오래된 알고리즘으로서도 알려져 있다. 

*/ 