package com.algorithm.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_SW_5643_키순서 {

	public static int result;
	private static int N;
	private static int M;
	private static int [][] flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // BufferedReader 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n + 1][n + 1];
		int result = 0;
		
		for (int i = 0; i < m; i++) {  // m만큼 돌기 
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b][a] = 1;
			arr[a][b] = -1;
		}

		for (int k = 1; k <= n; k++) {     // 플루이드 와샬 방법 ( 이 공식을 몰라서 계속 헤맸다.. ) 
			for (int i = 1; i <= n; i++) {  
				for (int j = 1; j <= n; j++) { 
					if (arr[i][k] == 1 && arr[k][j] == 1) // 두개가 1이라면 1이다. 
						arr[i][j] = 1;        // 크면 
					else if (arr[i][k] == -1 && arr[k][j] == -1)
						arr[i][j] = -1;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					if (arr[i][j] == 1 || arr[i][j] == -1)
						count++;
				}
			}
			if (count == n - 1)
				result++;
		}

		//System.out.println(result);
		
	}// end of dfs

}

/**
 * 1번부터 N번까지 번호가 붙여져 있는 학생들에 대하여 두 학생끼리 키를 비교한 결과의 일부가 주어져 있다. 단, N명의 학생들의 키는 모두
 * 다르다고 가정한다. 예를 들어, 6명의 학생들에 대하여 6번만 키를 비교하였고, 그 결과가 다음과 같다고 하자. 1번 학생의 키 < 5번
 * 학생의 키 3번 학생의 키 < 4번 학생의 키 5번 학생의 키 < 4번 학생의 키 4번 학생의 키 < 2번 학생의 키 4번 학생의 키 <
 * 6번 학생의 키 5번 학생의 키 < 2번 학생의 키 이 비교 결과로부터 모든 학생 중에서 키가 가장 작은 학생부터 자신이 몇 번째인지 알
 * 수 있는 학생들도 있고 그렇지 못한 학생들도 있다는 사실을 아래처럼 그림을 그려 쉽게 확인 할 수 있다. A번 학생의 키가 B번 학생의
 * 키보다 작다면 , a에서 b로 화살표를 그려서 표현하였다.
 * 
 * 1번은 5번보다 키가 작고, 5번은 4번보다 작기 때문에 1번은 4번보다 작게 된다. 그러면 1번, 3번, 5번은 모두 4번보다 작게
 * 된다. 또한 4번은 2번과 6번보다 작기 떄문에, 4번 학생은 자기보다 작은 학생이 3명이 있고 자기보다 큰 학생이 2명이 있게 되어
 * 자신의 키가 몇 번째인지 정확히 알 수 있다. 학생들의 키를 비교한 결과가 주어질때, 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두
 * 몇 명인지 계싼하여 출력하는 프로그램을 작성하시오
 * 
 * 입력 : 첫 줄에 T가 주어진다. 각 테스트케이스의 첫 번쨰 줄에 학생들의 수 N이 주어진다. 각 테스트 케이스의 두 번째 줄에 두 학생의
 * 키를 비교한 횟수 M이 주어진다. 각 테스트 케이스의 세 번째 줄부터 M개의 줄에 걸쳐 두 학생의 키를 비교한 결과를 나타내는 두 양의
 * 정수 A,B가 주어진다. 이는 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미한다. 이 때, 입력은 항상 모순이 없도록
 * 주어진다.
 * 
 */
