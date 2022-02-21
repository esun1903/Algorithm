import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236_아기상어 {  //시간초과남 

	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };
	public static int time = 0;
	public static int 아기상어크기count = 0;

	public static Queue<Pair> queue = new LinkedList<>(); // 아기상어의 위치

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) { // 만약, 아기상어의 위치라면 queue에 아기상어의 위치와 아기상어의 크기를 넣어주기
					queue.add(new Pair(i, j, 2,0,time));
				}
			}
		} // end of for

		// 아기 상어가 어디로 이동할지를 정하기
		// 만약, 이동할 수 있다면?
		while (!queue.isEmpty()) {
			Pair 아기상어 = queue.poll();
//			System.out.println("아기상어의 위치 " + 아기상어.r + " " + 아기상어.c + " " + 아기상어.size+" "+아기상어.sizecount+" "+아기상어.time);
			int count = 0;
			Queue<Pair> 먹을수있는물고기 = new LinkedList<>();

			// 물고기가 있는지 없는지 체크하기 =====================
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > 0 && arr[i][j] != 9) {
						flag = true;
					}
				}
			}
		
			if (flag == false) {
				System.out.println(time);
				return;
			}
	
			// ========================================

			for (int i = 0; i < 4; i++) {
				int nr = 아기상어.r + dr[i];
				int nc = 아기상어.c + dc[i];

				// 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

				// 범위안에 있어 물고기가 있다면?
				if (0 <= nr && 0 <= nc && nr < N && nc < N && arr[nr][nc] < 아기상어.size && arr[nr][nc] > 0) {
					count++;
					// 먹을 수 있는 물고기의 위치와 크기를 넣는다
					먹을수있는물고기.add(new Pair(nr, nc, arr[nr][nc],0,아기상어.time+1));
					if(time<아기상어.time+1)
						time = 아기상어.time+1; 
//					System.out.println("먹을 수 있는 물고기에 추가됨" + nr + " " + nc + " " + 아기상어.size+" "+아기상어.sizecount+" "+(아기상어.time+1));
				}
			}

			if (count > 1) {
				// 먹을 수 있는 아기상어가 많다?
				// 거리가 가장 가까운 물고기를 먹으러 간다.
				Pair 가장가까운물고기 = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,  Integer.MAX_VALUE, Integer.MAX_VALUE);
				int rd, cd, d;
				int d2 = Integer.MAX_VALUE;
				for (Pair p : 먹을수있는물고기) {
					rd = (int) Math.pow(p.r, 아기상어.r);
					cd = (int) Math.pow(p.c, 아기상어.c);
					d = (int) Math.sqrt(rd + cd);
					if (d2 > d) {
						d2 = d;
						가장가까운물고기.r = p.r;
						가장가까운물고기.c = p.c;
						가장가까운물고기.size = p.size;
					} else if (d2 == d) {
//                    만약에 거리가 가까운 물고기가 많다면 
//						가장 위에있는 물고기, 
//						그러한 물고기가 여러마리라면 가자 왼쪽에 있는 물고기를 먹는다. 
						if (가장가까운물고기.r > p.r) {
							가장가까운물고기.r = p.r;
							가장가까운물고기.c = p.c;
							가장가까운물고기.size = p.size;
						} else if (가장가까운물고기.r == p.r) {
							if (가장가까운물고기.c > p.c) {
								가장가까운물고기.r = p.r;
								가장가까운물고기.c = p.c;
								가장가까운물고기.size = p.size;
							}
						}
					}
				}
				아기상어.r = 가장가까운물고기.r;
				아기상어.c = 가장가까운물고기.c;
				아기상어.sizecount++; 
				if(아기상어.sizecount == 아기상어.size) {
					아기상어.size++; 
					아기상어.sizecount=0; 
				}
				arr[아기상어.r][아기상어.c] = 0;

				queue.add(new Pair(아기상어.r, 아기상어.c, 아기상어.size,아기상어.sizecount, time+1));

			} else if (count == 1) {
				// 그 물고기를 먹으러 간다.
				Pair p = 먹을수있는물고기.poll();
				아기상어.r = p.r;
				아기상어.c = p.c;
				아기상어.sizecount ++; 
				아기상어.time = p.time; 
				arr[아기상어.r][아기상어.c] = 0;
				if(아기상어.sizecount == 아기상어.size) {
					아기상어.size++; 
					아기상어.sizecount=0; 
				}
//				System.out.println("여기에 추가할거야 ~ "+ p.r+" "+p.c+" "+아기상어.sizecount+" "+아기상어.time+" ");
				if(time<아기상어.time)
					time = 아기상어.time; 
				queue.add(new Pair(아기상어.r, 아기상어.c, 아기상어.size,아기상어.sizecount, 아기상어.time));
			} else { // count ==0 이라면

				for (int i = 0; i < 4; i++) {
					int nr = 아기상어.r + dr[i];
					int nc = 아기상어.c + dc[i];
                    
					// 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
					// 범위안에 있어 물고기가 있다면?
					if (0 <= nr && 0 <= nc && nr < N && nc < N && arr[nr][nc] <= 아기상어.size) {
						// 큐에 추가
						
						queue.add(new Pair(nr, nc, 아기상어.size,아기상어.sizecount,아기상어.time+1));
						if(time<아기상어.time+1)
							time = 아기상어.time+1; 
					}
				}
			}

		}
//아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
//		예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
		System.out.println(time);
		// 0: 빈 칸
		// 1,2,3,4,5,6, : 칸에 있는 물고기의 크기
		// 9 : 아기 상어의 위치

	}// end of main

	public static class Pair {
		int r;
		int c;
		int size;
		int sizecount; 
	    int time;
		public Pair(int r, int c, int size, int sizecount, int time) {

			this.r = r;
			this.c = c;
			this.size = size;
			this.sizecount = sizecount;
			this.time = time;
		} 

       

	}
}// end of class

/*
 * N*N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1*1크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가
 * 최대 1마리 존재한다.
 * 
 * 아기상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에
 * 상하좌우로 인접한 한 칸씩 이동한다.
 * 
 * 아기상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기상어는 자신의 크기보다 작은
 * 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
 * 
 * 아기상어가 어디로 이동할지 결정하는 방법은 아래와 같다. - 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게
 * 도움을 요청한다. - 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다. - 먹을 수 있는 물고기가 1마리보다 많다면, 거리가
 * 가장 가까운 물고기를 먹으러 간다. - 거리는 아기상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
 * - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 * 
 * - 아기상어의 이동은 1초가 걸리고, 물고기를 먹는데 걸리는 시간은 없담고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로
 * 이동했다면, 이동과 동시에 물고리를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다. 아기 상어는 자신의 크기와 같은 수의 물고리를 먹을
 * 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3 이 된다.
 * 
 * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을
 * 작성하시오
 * 
 * 첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
 * 
 * 둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은
 * 의미를 가진다.
 * 
 * 0: 빈 칸 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기 9: 아기 상어의 위치 아기 상어는 공간에 한 마리 있다.
 * 
 * 
 * 첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
 */
