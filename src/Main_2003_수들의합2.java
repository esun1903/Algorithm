import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2003_수들의합2 { // 시간초과남

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

	}
}
/*
 * [나에게 가장 부족한 부분인 투포인터 - 1] 
 * 이 문제에서 각 원소는 자연수이고 M 또한 자연수인데,
 * 이 조건이 성립하면 사용할 수 있는 알고리즘은 다음과 같다.
 * 
 * 포인터 2개를 준비한다. 시작과 끝을 나타낼 수 있도록 start, end라고 하겠다. 맨 처음에는 start = end = 0이며, 항상
 * start<=end 을 만족해야 한다. 이 두개의 포인터는 현재 부분 배열의 시작과 끝을 가리키는 역할을 한다. N개의 수로 된 수열
 * A[1], A[2] , ... , A[N]이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A] [i+1] + ... +
 * A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오
 * 
 * 
 * 입력 첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2],
 * …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.
 */
