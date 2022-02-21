import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_단지번호붙이기2 {

	public static boolean visited[][];
	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };
	public static int N;
	public static int[][] arr;
	public static int count = 0;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int result = 0;
		List<Pair> queue = new LinkedList<Pair>();
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				arr[i][j] = c - '0';
				visited[i][j] = false; 
			}
		} // end of for

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					count = 0;
					dfs(i, j);
					queue.add(new Pair(count));
					result++;
				}
			}
		}

		Collections.sort(queue);
        System.out.println(result);
        for (int i = 0; i < queue.size(); i++) {
        	Pair p = queue.get(i);
        	System.out.println(p.count);
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		count++;
		for (int dir = 0; dir < 4; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];

			if (0 <= nr && 0 <= nc && nr < N && nc < N && arr[nr][nc] == 1 && visited[nr][nc] == false) {
                 dfs(nr,nc); 
			}
		}
	}

	public static class Pair implements Comparable<Pair> {
		int count;

		public Pair(int count) {
			super();
			this.count = count;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}

	}

}
