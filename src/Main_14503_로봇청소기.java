import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	public static int arr[][];
	public static boolean visited[][];
	public static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서 왼쪽이면 <-
	public static int[] dc = { 0, 1, 0, -1 };
	public static int result = 0;
	public static int N;
	public static int M;

	
	// 내가 했던 방식. -> 예외처리가 안되서 결국 dfs방식으로 변경해서 풀 예정 . 
	// 내가 했던 방식은 시뮬레이션으로 if문을 계속 돌아가면서 반복하는 방식이었다. (dfs방식와 거의 비슷) 
	// 하지만, 내 코드의 단점 : 모든 곳을 다 돈다. -> 후진조건에서 잘못된 것같은데 결국 포긔,, 
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기

		arr = new int[N][M];
		visited = new boolean[N][M];

		// 로봇 청소기의 위치 r,c와 바라보는 방향 d가 주어진다.
		st = new StringTokenizer(br.readLine());
		int robot_r = Integer.parseInt(st.nextToken());
		int robot_c = Integer.parseInt(st.nextToken());
		int robot_d = Integer.parseInt(st.nextToken());

		// 입력하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleaning(robot_r, robot_c, robot_d); // 로봇청소기의 위치,  방향을 입력하기 
		System.out.println(result);

	}

	private static void cleaning(int robot_r, int robot_c, int robot_d) {
		if (arr[robot_r][robot_c] == 0 && visited[robot_r][robot_c] == false) { 
			visited[robot_r][robot_c] = true;  // 1. 현재 위치를 청소한다. 
			arr[robot_r][robot_c] = 2;  // 1. 현재 위치를 청소한다. 
			result++;

			int check = 0;
			int left_d = 0;
	
			for (int i = 0; i < 4; i++) { // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
				if (robot_d == 0)	left_d = 3;  
				else 	left_d = robot_d - 1;
		

				// 왼쪽방향의 위치와 0이라면 
				if (visited[robot_r + dr[left_d]][robot_c + dc[left_d]] == false	&& arr[robot_r + dr[left_d]][robot_c + dc[left_d]] == 0) {
					cleaning(robot_r + dr[left_d], robot_c + dc[left_d], left_d);  // 청소하기 
				}  
				else { 
					robot_d = left_d;
					if (i == 3) 
					{
						left_d = (robot_d + 3) % 4; // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는,
						                                               //바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다
						if (arr[robot_r + dr[left_d]][robot_c + dc[left_d]] == 1) {  //후진을 한다. 
							return; 
						}
//						arr[robot_r + dr[left_d]][robot_c + dc[left_d]] = 0 ;
//						visited[robot_r + dr[left_d]][robot_c + dc[left_d]]  = false;
						cleaning(robot_r + dr[left_d], robot_c + dc[left_d], left_d);
					}
					continue;
				}
			} // end of for 
		   return ; 
		}// end of if 

	}

}

/*
	
				System.out.println("result : " + result);		
				for (int r = 0; r < N; r++) {
					System.out.println();
					for (int c = 0; c < M; c++) {
						System.out.print(arr[r][c] + "  ");
					}
				}

			System.out.println("========================================");

 */
