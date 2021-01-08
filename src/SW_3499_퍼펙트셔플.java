package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class SW_3499_퍼펙트셔플 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 카드를 퍼펙트셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱은 만드는 것이다. 정확한
		 * 방식은 다음 그림과 같다 N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성하라 만약
		 * N이 홀수라면, 교대로 놓을 때 먼저 놓는 쪽에 한장이 더들어가게 하면 된다.
		 * 
		 * 첫번째 줄에 테스트케이스의 수T가 주어진다. 각 테스트 케이스의 첫번째 줄에는 자연수 N이 주어진다. 두 번째 줄에는 덱에 카드가 놓인
		 * 순서대로 n개의 카드이름이 공백으로 구분되어 주어진다. 카드의 이름은 알파벳 대문자와 '-'만으로 이루어져 있으면, 길이는 80이하이다.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		Stack<String> stack;
		Stack<String> stack2;
		Stack<String> result;
		// 정확히 절반으로 나누고
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			stack = new Stack<>(); // 스택 3개 생성 (String으로 3개)
			stack2 = new Stack<>();
			result = new Stack<>();
			
			// 절반으로 나눠서 stack 두 개에 나누기
			for (int i = 0; i < N; i++) { // 0부터 n까지 for문 반복
				String str = sc.next(); // 공백까지 str을 방다
				if (N % 2 == 0) { //N이 짝수라면 
					if (i < N / 2) { // 0,1,2까진 stack.push
						stack.push(str);
						// System.out.print(stack.peek());
					} else {// 나머지는 여기서 stack2에 push해줌
						stack2.push(str);
					}
				} else { //N이 홀수하면 
					if (i < (N / 2) + 1) { // 0,1,2까진 stack.push
						stack.push(str);
						// System.out.print(stack.peek());
					} else {// 나머지는 여기서 stack2에 push해줌
						stack2.push(str);
					}
				}

			}

			// 뒤스택 -> 첫하나씩 꺼내서 결과스택에 하나씩
			for (int i = 0; i < N; i++) {
					
				if(N%2 == 1) {
				   if (i % 2 == 0) {
						String s = stack.pop();
						result.push(s);
					} else {
						String s = stack2.pop();
						result.push(s);
					}
				} 
				else {   
					if (i % 2 == 1) {
				
					String s = stack.pop();
					result.push(s);
				} else {
					String s = stack2.pop();
					result.push(s);
				}
					
				}
				

			

			}
			// 결과 값 출력

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				String s = result.pop();
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}


}
