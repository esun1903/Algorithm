package day0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_D4 {
	private static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // p 스타일리쉬를 마스터한 사람의 코드 줄 수 (1 <= p q <= 10)
			int q = Integer.parseInt(st.nextToken()); // q 당신의 코드 줄 수 (1 <= p q <= 10)
//	RCS 모든 순열 을 구해서 , 스타일리쉬 코드에 답으로 사용할 수 있는지 확인후, 내 코드에 적용하겠음
//			소스코드를 매번(8000번) 읽어서 분석하는 것이아니라, 분석한 데이터만 저장해서 재활용
			m = new int[p][4]; // 소스코드의 한줄 [0].점들여쓰기, [1]소, [2]중, [3]대
			for (int i = 0; i < p; i++) { // 마스터의 스타일리쉬 코드 분석
				String line = br.readLine(); // 한줄
				
				// . 의 개수 세기
				int index = 0;
				while(line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index; // . 의 개수
			
				if (i > 0) {
					m[i][1] = m[i-1][1]; // 누적하기위해서 이전칸의 값을 가져옴
					m[i][2] = m[i-1][2];
					m[i][3] = m[i-1][3];
				}
				
//				점이 끝난 다음 소스코드의 위치가 : index~끝
//				여는 괄호의 개수- 닫는 괄호의 개수
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': m[i][1]++; break;
					case ')': m[i][1]--; break;
					case '{': m[i][2]++; break;
					case '}': m[i][2]--; break;
					case '[': m[i][3]++; break;
					case ']': m[i][3]--; break;
					}
				}
			} // end of for 마스터 스타일리쉬 코드분석
			
//			내 소스코드 분석
			dap = new int[q][4];
			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0;
//				. 의 개수는 없는 상태임
				if (i > 0) {
					dap[i][1] = dap[i-1][1]; // 누적하기위해서 이전행의 데이터 복붙
					dap[i][2] = dap[i-1][2];
					dap[i][3] = dap[i-1][3];
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': dap[i][1]++; break;
					case ')': dap[i][1]--; break;
					case '{': dap[i][2]++; break;
					case '}': dap[i][2]--; break;
					case '[': dap[i][3]++; break;
					case ']': dap[i][3]--; break;
					}
				}
			} // end of for 내 소스코드 분석
			
//			dap[i][0] : 들여쓰기 .의 개수를 기록하자 : 초기값을 사용하지 않는 숫자로 넣기 -2, 들여쓰기의 답이 유일하지 않으면 -1
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2; // 초기화
			}
//			중복순열
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R,C,S)) { // R, C, S 의 중복순열 쌍이 마스터 코드에 답으로 쓸수 있는지 체크
							cal(R,C,S); // 내 소스코드의 들여쓰기를 계산해보자
						}
					}
				}
			}
			
			sb.append('#').append(testCase).append(" 0"); // 첫번째 줄의 값은 항상 0
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			sb.append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
	/** 내 코드에서 R,C,S 값으로 .의 개수를 구하기 */
	private static void cal(int R, int C, int S) {
//		dap[i][0] : 들여쓰기 .의 개수를 기록하자 : 초기값을 사용하지 않는 숫자로 넣기 -2, 들여쓰기의 답이 유일하지 않으면 -1
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i-1][1]*R + dap[i-1][2]*C + dap[i-1][3]*S;
			if (dap[i][0] == -2) { // 답을 구한적이 없으면, 바로 저장함
				dap[i][0] = x;
			} else if (dap[i][0] != x) { // 답을 구한적이 있는데, 기존의 구했던 답과 다르면 (답이 유일하지 않다는 의미) -1 
				dap[i][0] = -1; // 유일하지 않음
			}
		}
	}
	/** 스타일리쉬 마스터 코드에서 R, C, S 가 답이 되는제 체크 */
	private static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			// 현재 행의 점의 개수는 이전행까지의 누적된 괄호의 개수로 연산한 결과 여야한다
			if (m[i][0] != m[i-1][1]*R + m[i-1][2]*C + m[i-1][3]*S) {
				return false;
			}
		}
		return true;
	}
} // end of class

