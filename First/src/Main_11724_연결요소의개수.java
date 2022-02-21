import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	public static ArrayList<ArrayList<Integer>> arrayList;
	public static boolean visited[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = 0;
		int left; int right;
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		visited = new boolean[N + 1]; // 정점 방문의 개수

		arrayList = new ArrayList<ArrayList<Integer>>();

		for (int i = 1; i <= N + 1; i++) {
			arrayList.add(new ArrayList<Integer>());
		}

		// for문으로 반복하며 -> 입력받고 -> 추가하기
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken()); // 왼쪽
			right = Integer.parseInt(st.nextToken()); // 오른쪽

			arrayList.get(left).add(right);
			arrayList.get(right).add(left);
		} // end of for

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	private static void dfs(final int i) {
		visited[i] = true;
		for (int j = 0; j < arrayList.get(i).size(); j++) {
			int p = arrayList.get(i).get(j);
			if(visited[p] ==  false)
				dfs(p);
		}
	}

}// end of class

/*
 * 방향 없는 그래프가 주어졌을때, 연결 요소의 개수를 구하는 프로그램을 작성하시오
 * 
 * 입력: 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1<=N<=1,000 , 0<=M<=N*(N-1)/2 ) 둘째 줄부터
 * M개의 ㅈ루에 간선의 양 끝점 u와 v가 주어진다
 * 
 * 출력: 첫째 줄에 연결 요소의 개수를 출력한다.
 */

// 테스트
//for (int i = 0; i < N; i++) {
//	for (int j = 0; j < arrayList.get(i).size(); j++) {
//	  System.out.print(arrayList.get(i).get(j)+" ");
//	}
//	System.out.println();
//}