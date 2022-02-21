import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_인접행렬{

	public static int N;
	public static int M;
	public static int V;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 간선의 개수
		M = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점의 번호
		V = Integer.parseInt(st.nextToken());

		boolean visited[] = new boolean[N + 1];
		int arr[][] = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			arr[one][two] = 1;
			arr[two][one] = 1;
		} // end of for

		dfs(V, arr, visited);
		sb.append('\n');
		visited = new boolean[N + 1];
		bfs(V, arr, visited);
		System.out.println(sb);
	}// end of main

	private static void dfs(int i, int[][] arr, boolean[] visited) {
		if (visited[i] == false) {
			visited[i] = true;
			sb.append(i + " ");
			for (int j = 1; j < N + 1; j++) {
				if (arr[i][j] == 1 && visited[j] == false) {
					dfs(j, arr, visited);
				}
			}
		}
	}

	private static void bfs(int v2, int[][] arr, boolean[] visited) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v2);
        visited[v2] = true; 
		while (!queue.isEmpty()) {
			int k = queue.poll();
			sb.append(k + " ");
			for (int i = 1; i < N + 1; i++) {
				if (visited[i] == false && arr[k][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			} // end of for
		}
	}

}// end of class
