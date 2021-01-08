
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657 {

	public static int N;
	public static int M;
	public static int[] one;
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;

	public static void Combination(int[] two, int count) { // two가 combination으로 옴

		// 만약 m count가 같다면
		if (M == count) { // if( 1 == count)
			for (int a : one)
				sb.append(a + " ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {

			one[count] = two[i];
			if (count == 0)
				Combination(two, count + 1);
			if (count > 0 && one[count] >= one[count - 1])
				Combination(two, count + 1);
		

		}
		return;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] two = new int[N];
		one = new int[M];
		visit = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			two[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(two);
		Combination(two, 0);
		System.out.println(sb);
	}

}
