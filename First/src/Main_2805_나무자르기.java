import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이

		int tree[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);

		// 20 15 10 17
		// 10 15 17 20

		int start = 1; // 가장 작은 값
		int end = tree[N - 1]; // 가장 큰 값
		int mid = 0;
		long total = 0;
		while (start <= end) {
			// 일단, 중간값을 정해두고
			total = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				if (tree[i]>=mid) { // 만약 중간값보다 tree[i]가 더 크면 그값만큼 삭제해서
					total += (tree[i] - mid); // 높이 지정 
				} // end of if
			}
			if (total >= M) { // 나무들이 큰 것들이 > = 내가 원하는숫자보다 많다,
				start = mid + 1;
			} else if (total < M) { // total 보다 내가 원하는 게 더 크다면
				end = mid - 1;
			}
		} // end of while
		System.out.println(end);
	}// end of main

}
/*
 * 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는
 * 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다)
 * 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
 * 
 */
