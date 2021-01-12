
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17281_야구 {

	// 46인데 58나옴
	private static int N;
	private static int[][] arr;
	private static int[] order;
	private static boolean visited[];
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][10];
		visited = new boolean[10];
		order = new int[10];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) { // 1루부터 9루까지 반복하기
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 1); // 1루에 첫번째를 할 예정
		System.out.println(result);

	} // end of main

	// dfs + 순열을 만들어서 -> 이것에 대해 점수를 내기
	private static void dfs(final int index, final int count) { // index

		if (count == 9) { // 9루까지 왔다는 것 + 예전에 했던 순열문제를 (n과m)
			int[] newOrder = new int[10]; // 순열을 만들기 위한 것들을 만들기
			int temp = 1;
			for (int i = 1; i <= 3; i++) {
				newOrder[temp++] = order[i];
			}
			newOrder[temp++] = 1; // 4번째는 무조건 1번이니깐 이렇게 한 것
			for (int i = 4; i <= 8; i++) { // 9까지 모두 입력됨
				newOrder[temp++] = order[i];
			}
			func2(newOrder);
			return;

		}

		// 2루에서부터 시작하는 것
		for (int position = 2; position <= 9; position++) {
			if (!visited[position]) { // 방문한 정점체크
				visited[position] = true;
				order[index] = position;
				dfs(index + 1, count + 1);
				order[index] = 0;
				visited[position] = false;
			}
		}
	}

	// 여기서 매개변수를 받아 ( newOrder) 를 토대로 점수를 매기기
	private static void func2(int[] nowOrder) {
		int innings = 1;
		int index = 1;
		int score = 0;

		while (innings <= N) { // in
			int base_1 = 0, base_2 = 0, base_3 = 0;
			int outCount = 0;

			while (true) {
				if (index == 10)
					index = 1; // (한 이닝이 끝나지 않았다면 1번 타자로 되는 것 )
				int now = nowOrder[index++];
				int attack = arr[innings][now];

				switch (attack) {
				case 1: { // 안타를 기록했는데 3루가 비어있지 않았다면 -> 점수기록
					if (base_3 != 0) { // 3루가 0 이아니라면
						score++;
						base_3 = 0;
					}
					if (base_2 != 0) {
						base_3 = base_2;
						base_2 = 0;
					}
					if (base_1 != 0) {
						base_2 = base_1;
					}
					base_1 = now;
					break;
				}
				case 2: {
					if (base_3 != 0) {
						score++;
						base_3 = 0;
					}
					if (base_2 != 0) {
						score++;
						base_2 = 0;
					}
					if (base_1 != 0) {
						base_3 = base_1;
						base_1 = 0;
					}
					base_2 = now;
					break;
				}
				case 3: {
					if (base_3 != 0) {
						score++;
						base_3 = 0;
					}
					if (base_2 != 0) {
						score++;
						base_2 = 0;
					}
					if (base_1 != 0) {
						score++;
						base_1 = 0;
					}
					base_3 = now;
				}
				case 4: {
					if (base_3 != 0) {
						score++;
						base_3 = 0;
					}
					if (base_2 != 0) {
						score++;
						base_2 = 0;
					}
					if (base_1 != 0) {
						score++;
						base_1 = 0;
					}
					score++;
					break;
				}
				case 0: {
					outCount++;
					break;
				}
				}
				if (outCount == 3)
					break;
			} // end of while
			innings++;
		}
		result = Math.max(result, score);
	} // end of func2

}
