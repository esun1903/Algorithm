package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모콘 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 내가 가고자 하는 채널 

		st = new StringTokenizer(br.readLine()); 
		int M = Integer.parseInt(st.nextToken()); // 고장난 개수 

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end of for
		
		
		// 1) 만약, 100이라면 -> 0 , 
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		else if(N=)
		

	}

}

/*
 * 수빈이는 Tv를 보고있다. 수빈이는 채널을 돌리려고 했지만, 버튼이 너무 세게 누르는 바람에 일부 숫자 버튼이 고장났따 리모컨에는 버튼이
 * 0부터 9까지 숫자 +,-가 있따. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널
 * 0에서 -를 누른경우 채널이 변하지 않고, 채널은 무한대 만큼 있다
 * 
 * 수빈이가 지금 이동하려고 있는 채널은 N이다. 어떤 벙튼이 고장났는지 주어졌을 때 n으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지
 * 구하는 프로그램을 작성하시오
 * 
 * 수빈이가 지금 보고 있는 채널은 100번이다.
 * 
 * 입력) 첫째 줄에 수빈이가 이동하려고 하는 채널N이 주어진다. 둘째 줄에는 고장난 버튼의 개수가 주어진다 고장난 버튼이 있는 경우에는 세째
 * 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
 * 
 * 5457 3 6 7 8
 */
