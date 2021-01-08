package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {

	public static int N;
	public static int M;
	public static int arr[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println();
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}

	public static void bfs(int x, int y) {

		Queue<Pair> queue = new LinkedList();
		queue.offer(new Pair(x, y));

	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
