package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SW_8382_방향전환 {

	static int x1, y1, x2, y2;
	static final int HOR = 0, VER = 1;

	static class Point {
		int x, y, d, cnt;

		public Point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			// 좌표에 100씩 더해 음수좌표 보정
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][][] visited = new boolean[2][201][201];

		visited[HOR][x1][y1] = true;
		queue.offer(new Point(x1, y1, HOR, 0));
		visited[VER][x1][y1] = true;
		queue.offer(new Point(x1, y1, VER, 0));

		Point cur;
		int nx, ny;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.x == x2 && cur.y == y2) return cur.cnt; // 우리가 원하는 도착좌표면  return 하기 
		     
			if(cur.d == HOR) { // 현재가 가로이동이었다면 
				// 세로이동처리
				nx = cur.x;
				ny = cur.y -1; 
				if(ny>=0 && !visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true; 
					queue.offer(new Point(nx,ny, VER, cur.cnt+1));
				}
				ny = cur.y + 1; 
				if(ny<= 200 && !visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true; 
					queue.offer(new Point(nx,ny,VER,cur.cnt+1));
				}
			} else {
				//가로이동처리 
				nx = cur.x-1; 
				ny = cur.y; 
				if(nx>= 0 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true; 
					queue.offer(new Point(nx,ny,HOR,cur.cnt+1));
				}
				nx = cur.x+1; 
				
				if(nx<= 200 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true; 
					queue.offer(new Point(nx,ny,HOR,cur.cnt+1));
				}
			}
		
		}
		return 0; // 의미 없음
		
		}
	
}
	

/*
 * 
 * x1,y1 에서 x2,y2로 이동하려고 한다. x,y에서 한 번 이동하면 (x+1,y ) , (x-1,y) , (x,y+1),
 * (x,y-1)로 이동 할 수 있다. 이 중에서 (x+1, y) ,(x-1,y)로 이동하는 것은 가로이동, (x,y+1), (x, y-1)로
 * 이동하는 것은 세로 이동이라고 한다. 정우는 그냥 (x1, y1)에서 (x2,y2)로 이동하는 것은 재미가 없다고 생각한다 그래서 이전
 * 이동이 가로 이동이었다면 이번에는 세로 이동으로 이동하고, 이전 이동이 세로 이동이었다면, 이번에는 가로 이동으로 이동하여 (x1,y1)
 * 에서 (x2,y2)로 이동하려고 한다. 가장 첫 이동은 어떤 이동이어도 상관 없다. 이 때 최소 몇 번의 이동을 해야 (x1,y1)에서
 * (x2,y2)로 이동 할 수 있는지 구하는 프로그램을 작성하라
 * 
 * 
 * 입력) 첫 번째 줄에 테스트 케이스의 수 T가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 네 정주 x1,y1,x2,y2 (-100 ~
 * <100) 이 공백 하나로 구분되어 주어진다.
 * 
 * 출력) 각 테스트 케이스마다 #x를 출력하고, 각 테스트 케이스마다 최소 몇 번의 이동을 해야 하는지 출력한다.
 * 
 */