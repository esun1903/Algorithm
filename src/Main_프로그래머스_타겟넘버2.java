import java.util.*;

public class Main_프로그래머스_타겟넘버2 {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	public static boolean visited[];
	public static int result = 0;
	public static int sum = 0;

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		visited = new boolean[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			func(i, i + 1, numbers, target);
		}
		return result;
	}

	private static void func(int x, int depth, int[] numbers, int target) {
		if (x == depth) {
			sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (visited[i] == true) {
					System.out.print(i + " ");
					sum += numbers[i];
				} else {
					sum -= numbers[i];
				}
			}
			System.out.println();
			if (sum == target)
				result++;
			return;
		}

		for (int i = x; i < numbers.length; i++) {
			visited[i] = true;
			func(i + 1, depth, numbers, target);
			visited[i] = false;
		}

	}

}// end of func

// 첫 번째 생각
// 1.  0000 0001 ~ 1111까지 세팅을 모두 해준다. 
// 2.  이를 기반으로 + - 를 세팅해준다. 
// 3.  만약, 1이냐 0이냐의 따라 음의 정수와 양의 정수를 세팅한다. 
// -> 하지만, 시간이 너무 오래걸릴 것 같다는 생각을 하게 됨

// 두 번째 생각 
// 1. 조합으로 풀기 
// 2.

//		System.out.println("===============");
//		for (int i = 0; i < x; i++) {
//			System.out.print(arr[i] + " ");
//		}