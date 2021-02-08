import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	public static int gong1_r = -1;
	public static int gong1_c = -1;
	public static int gong2_r = -1;
	public static int gong2_c = -1;

	public static int dust = 0;
	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };
	public static int map[][];
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && gong1_r == -1) { // 공기청정기 위치 체크
					gong1_r = i;
					gong1_c = j;
				} else if (map[i][j] == -1 && gong1_r != -1) {
					gong2_r = i;
					gong2_c = j;
				}
			}
		}

		for (int time = 1; time <= T; time++) { // 시간이 가고있다.
        
			 // 미세먼지의 확산을 체크할 함수 
			 Diffusion(R,C);
	
		}
    
		for (int i = 0; i < R; i++) {
			System.out.println();
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
		}
	}

	private static void Diffusion(int R, int C) {
		
		 /*
		    1. for문을 두개 돌아가면서 만약 0보다 큰 값이 이라면 
	        2. 5로 나누어서 그 나눈 몫을 for 문 그 4방향으로 한다. 
	        3. 그 다음 4방향이 범위가 안넘으면 안넘은 것들을 count해주고 자기의 미세먼지에 +값을 해준다. 
	        4. Ar,c - (Ar,c/5)×(확산된 방향의 개수) 를 해주고 반복한다. 
	      */
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				 
				  if(map[r][c] > 0) {
					 int num =  map[r][c] / 5;
					 if(num == 0 )
						 continue; 
					 int count = 0; 
					 for(int i= 0; i<4; i++) {
						 int nr = dr[i] + r; 
						 int nc = dc[i]+ c; 
						 if(nr<R && nc <C && nr >= 0 && nc >= 0 &&  map[nr][nc]!=-1) {
							  map[nr][nc]+= num; 
							  count++; 
						 }
						 map[r][c] = map[r][c] - (num*count);
					 }
				  }
				  
			}
		} // end of for 
	 
		
		
	}

}// end of class

/*
 * 미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R * C인
 * 격자판으로 나타냈고, 1*1크기의 칸으로 나누었다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸(r,c)에 있는 미세먼지의 양을 실시간으로
 * 모니터링하는 시스템을 개발했다. (r,c)는 r행과 c열을 의미한다 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다.
 * 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고 (r,c)에 있는 미세먼지의 양은 Ar,c이다
 * 
 * 1초 동안 아래 적힌 일이 순서대로 일어난다
 * 
 * 1. 미세먼지가 확산된다.확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다. - (r, c)에 있는 미세먼지는 인접한 네 방향으로
 * 확산된다. - 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다. - 확산되는 양은 Ar,c/5이고
 * 소수점은 버린다. - (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
 * 
 * 2. 공기청정기가 작동한다. - 공기청정기에서는 바람이 나온다. - 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의
 * 바람은 시계방향으로 순환한다. - 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다. - 공기청정기에서 부는 바람은 미세먼지가
 * 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
 * 
 * 다음은 확산의 예시이다.
 * 
 * 방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.
 * 
 * 첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
 * 
 * 둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지
 * 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
 */
