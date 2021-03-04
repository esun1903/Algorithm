import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_8972_미친아두이노 {

	public static char map[][]; // 보드의 [][]
	public static int r1, c1; // 종수의 위치
	public static int s1,s2; // 미친 아두이노의 위치 

	public static int[] dr = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 }; // 1부터 시작해야하고
	public static int[] dc = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	public static int num = 0; // 미친 아두이노의 갯수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<Integer, Pair> hash = new HashMap<>(); // 미친 아두이노 갯수와 위치를 저장

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int min = 0;
		int math = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j); // R은 미친 아두이노, I는 종수의 위치를 나타낸다.

				// 종수의 위치일때
				if (map[i][j] == 'I') {
					r1 = i;
					c1 = j;
				}
				// 미친 아두이노의 위치일때
				if (map[i][j] == 'R') {
					hash.put(num, new Pair(i, j));
				}
				num++; 
			}
		}

		// 5는 그 자리에 그래도 있는 것을 나타내고, 나머지는 아래와 같은 방향을 나타낸다.
		String direction = br.readLine();

		// 1. 해당되는 종수의 이동
		for (int j = 0; j < direction.length(); j++) {

			char c = direction.charAt(j);
			int t = c - '0';
			// System.out.println(t);
			int nr = r1 + dr[t];
			int nc = c1 + dc[t];

//			 System.out.println(t+" 방법으로   "+nr+" "+nc+"로 옯긴다.");
			// 2. 만약, 아두이노가 있는 칸이었다면
			if (map[nr][nc] == 'R') {
				System.out.println("kraj " + j);
				System.exit(0);
			}
			// 위치변경
			map[r1][c1] = '.';
			map[nr][nc] = 'I';
			r1 = nr;
			c1 = nc;
             int minr = 0; 
             int minc = 0; 
			
             // 3. 미친 아두이노의 이동
			for (int move : hash.keySet()) { // 모든 k값 반환
				// 여기에 저장되어있는 위치값들을 반환해서
				min = Integer.MAX_VALUE;
				Pair p = hash.get(move);
				for (int i = 1; i < 10; i++) { // r1 . c1 : 종수의 위치 . p.r . p.c : 미친 아두이노의 위치 
					  s1 = p.r + dr[i];  // 양쪽으로 다 변환 
					  s2 = p.c + dc[i];
					  
					  math = Math.abs(r1-s1) + Math.abs(c1-s2);   
					  if(math<min) { // 만약, math < min 까지 
						 min = math;   // w종수의 위치  + 미친 아두이노 
					     minr = s1;
					     minc = s2; 
					  }	 
				}
				
				map[p.r][p.c] = '.';
			
				if(map[minr][minc] =='R') {
					//만약, 2개 또는 그 이상의 아두이노가 같은 칸에 있는 경우 큰 폭발
					map[minr][minc] ='.';  //만약, minr , minc 가 . 이라면 
					map[p.r][p.c] = '.';
				}
				else {
				map[minr][minc] = 'R';
				}
				
//				System.out.println("========================");
//				for (int o = 0; o < R; o++) {
//					System.out.println();
//			   	 for (int h = 0; h <C ; h++) {
//						System.out.print(map[o][h]+" ");
//					}
//				}
//				System.out.println("========================");
//			
			}
		}
		
//		System.out.println("===========");
		for (int o = 0; o < R; o++) {
			System.out.println();
	   	 for (int h = 0; h <C ; h++) {
				System.out.print(map[o][h]);
			}
		}


	}

	public static class Pair { // 미친 아두이노를 저장할 클래스
		int r;
		int c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
// 1.  먼저 종수가 아두이노를 8가지 방향 (수직, 수평, 대각선)으로 이동시키거나, 그 위치에 그래도 놔둔다. 
// 2.  종수의 아두이노를 미친 아누이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되며, 종수는 게임을 지게 된다. 
// 3. 미친 아두이노는 8가지 방향에서 종수의 아두이노와 가장 가까워 지는 방향으로 한 칸 이동한다. 
// 즉, 종수의 위치를 (r1, s1) , 미친 아두이노의 위치를 (r2,s2)라고 했을 때, |r1-r2| + |s1-s2| 가
// 가장 작아지는 방향으로 이동한다. 
// 4. 미친 아두이노가 

/*
 * 		for (int i = 0; i < R; i++) {
			System.out.println();
	 	 for (int j = 0; j <C ; j++) {
				System.out.print(map[i][j]+" ");
			}
		}
 */
