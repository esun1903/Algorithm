package com.algorithm.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main_13023 {

	public static int N;
	public static int M;
	public static StringBuilder sb = new StringBuilder();
	public static boolean visited[];
	public static ArrayList<Integer>[] members;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * 이게 dfs인지 몰랐음 ( 파악하는데 시간걸릴것같다)
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수

		members = new ArrayList[N + 1]; // 정점의 수 +1만큼 arraylist 생성하기

		visited = new boolean[M + 1]; // boolean 형 m간선의 수만큼

		for (int i = 0; i < N; i++) { // 정점의 수 만큼 arraylist생성
			members[i] = new ArrayList<Integer>();
		}

		
		for (int i = 0; i < M; i++) { // 간선의 수만큼
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			members[a].add(b);
			members[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,0);

		}

		System.out.println(0);
	}

	public static void dfs(int m, int count) {

		if (count == 4) { // 만약 count == 4 라면
			System.out.println(1);
			System.exit(0);
		}
		for (int i : members[m]) {
			if(!visited[i]) {
			visited[i] = true; // true로 변경해주기
			dfs(i, count + 1);
			visited[i] = false;
		}
	}

}
}
