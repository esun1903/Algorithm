import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main_15651_N과M_4 {

	public static int M, N;
	public static boolean[] visited;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		int[] arr = new int[M + 1];
		calculator(0,  0, arr);
		System.out.println(sb);
	}

	private static void calculator(int count, int x, int[] arr) {
		if (count == M) {
			for (int j = 0; j < M; j++) {
				sb.append((arr[j] + 1) + " ");
			}
			sb.append("\n");
			return;
		}
		for (int j = x; j < N; j++) {
			arr[count] = j;
			calculator(count + 1, j, arr);
		}
	}

}

/*
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오 - 1부터 N까지 자연수 중에서
 * 중복 없이 M개를 고른 수열
 * 
 * 입력 : 첫째 줄에 자연수 N과 M이 주어진다. ( 1<=M<=N<=8) 출력 :한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다. 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 * 
 * 
 */