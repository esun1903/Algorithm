import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절대값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int num1 = Math.abs(o1);
			int num2 = Math.abs(o2);
			// 절댓값을 구해 만약 크면 o1 > o2 면 1을 리턴 , -1을 리턴
			// 기준 값과 비교대상이 동일하면 0 , 기준 값이 비교대상 보다 작은 경우는 -1, 기준값이 비교대상 보다 큰 경우는 1
			if (num1 == num2) {
				if (o1 > o2)
					return 1; // 뒤로가기 ~ 
				else
					return -1; //앞으로가긔 ~ 
			}

			return num1 - num2; // 같지않으면 뺀걸로 return(우선순위로 정렬)

		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (queue.isEmpty()) // 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
					System.out.println(0);
				else // 아니면 큐에 있는거 하나 꺼내기
					System.out.println(queue.poll());
			} else { // x가 0이 아니라면 큐에 x값을 넣기
				queue.add(x);
			}
		} // end of for

	}// end of main

} // end of class

/*
 * 절대값 힙은 다음과 같은 연산을 지원하는 자료구조이다,
 * 
 * 1. 배열에 정수 x를 넣는다 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러
 * 개일 때는 가장 작은 수를 출력하고 그값을 배열에서 제거한다.
 * 
 * 프로그램이 처음에 비어있는 배열에서 시작하게 된다.
 * 
 * 입력) 첫째 줄에 연산의 개수N이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다 만약 x가 0이 아니라면
 * 배열에 x라는 값을 넣는 연산이고 , x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
 * 입력되는 정수는 -2 31승 보다 크고, 2 31승보다 작다,.
 * 
 * 출력) 입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0 을
 * 출력하면 된다.
 */
