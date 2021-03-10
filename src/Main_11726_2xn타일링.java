import java.util.Scanner;

public class Main_11726_2xn타일링 { //피보나치  map[1] = 1, map[2] = 2, map[3]  = 3, map[4] = 5 ~~~~

	public static int map[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[1001]; // n이 1000까지 가능하다고 나와있음
		map[0] = 1;
		map[1] = 1;
		map[2] = 2;
		tailing(n);
		System.out.println(map[n]);
	}

	private static void tailing(int n) {
		for (int i = 2; i <= n; i++) {
			map[i] = (map[i - 2] + map[i - 1]) % 10007;
		}
	}
}

/*
 * 2*n 크기의 직사각형을 1 * 2 , 2 * 1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오 아래 그림은 2 * 5 크기의
 * 직사각형을 채운 한 가지 방법의 예이다.
 * 
 * 입력 : 첫째 줄에 n이 주어진다. 출력 : 첫째 줄에 2 * n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를
 * 출력한다.
 *
 *  map[1] = 1, map[2] = 2, map[3]  = 3, map[4] = 5
 *  = 피보나치의 성질을 가졌다. 
 */