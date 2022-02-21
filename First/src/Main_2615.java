package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2615 {
 
	
	//하는데까지 해봤지만 ㅠㅠ 못하고 제출합니다 ㅠㅠ 죄송합니다 ㅠㅠ
	
	public static int[] dx = { 0, 1, 1, 1 };
	public static int[] dy = { 1, 1, 0, -1 };
	public static int map[][];
	public static boolean visited[][];
	public static int count ;
	public static void main(String[] args) throws IOException {
		map = new int[19][19];
		visited = new boolean[19][19];
        count = 0; 
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
	}

	private static void dfs(int x , int y) {
         visited[x][y] = true;
         Queue<Pair> queue = new LinkedList();
         queue.offer(new Pair(x,y));
         Pair p = queue.poll();
         
         
         for(int i =0 ;i<4; i++) {
        	 int nx = p.x + dx[i];
        	 int ny = p.y + dy[i];

        	 //범위만들기 
        	 if(map[nx][ny] == 1 && visited[nx][ny] == false)
        		 dfs(nx,ny);
         }  	 
	}

	public static class Pair {
		int x;
		int y;
        
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
