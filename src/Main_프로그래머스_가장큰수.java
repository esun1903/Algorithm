
public class Main_프로그래머스_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	public static int solution(int[] numbers) {
		int answer = 0;
		int n = numbers.length - 1;
		boolean visited[] = new boolean[n];
		int arr[] = new int[n];
		long compare = Integer.MAX_VALUE;
		calculator(0, n, compare, visited, numbers, arr);

		return answer;
	}

	private static void calculator(int i, int n, long compare, boolean visited[], int[] numbers, int[] arr) {
		if (i == n) { // 만약, 도달했다면? 이제 비교 
//           for( )
			
		} else {
			for (int j = 0; j < n; j++) {
				if (visited[j] == false) {
					visited[j] = true;
					arr[i] = j;
                    calculator(i+1, n, compare, visited, numbers, arr);
                    visited[j] = false; 
				}
			}

		}
	}

}
//순열로 풀기 
// index로 순열을 받아 
// 그 순열대로의 값을 넣어 비교하기 -> n과 m기억이 안남,,, 

/*
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중
 * 가장 큰 수는 6210입니다.
 * 
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 1. n과 m 처럼 순열
 */
