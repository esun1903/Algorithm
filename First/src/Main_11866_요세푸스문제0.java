import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		int count =1; 
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}// end of for 
		
		
		
		
		while(!queue.isEmpty()) { // 만약, 큐가 비어있지 않다면
			if(count == K) {
				count = 1; 
			    result.add(queue.poll());
			}else {
				count ++; 
				int c = queue.poll();
				queue.add(c);
			}
		}//end of while
		
        System.out.print("<");
       while(!result.isEmpty()) {
		System.out.print(result.poll());
		if(!result.isEmpty()) {
			System.out.print(", ");
		}
	}
       System.out.print(">");
    
	}// end of main

}// end of class 



/*
 * 
 * 문제 순서 N과 K의 입력을 받기 Queue를 만들어서 Queue를 초기설정해준다,.
 * 
 * 
 * 반복시키면서 k번째가 나왔을때 지우고 배열에 하나 넣기 반복 
 * 만약, 큐의 끝이 왔다면 다시 처음으로 오기
 *  만약, 큐에 값이 없다면 배열
 * 출력
 * 
 * 
 * 
 * 
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K가 주어진다. 이제 순서대로 K번째 사람을 제거한다 한 사람이
 * 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서
 * 사람들이 제거되는 순서를 N, K - 요세푸스 순열이라고 한다 예를 들어 (7,3) - 요세푸스 순열은 <3,6,2,7,5,1,4,> N과
 * K가 주어지면 (N,K) - 요세푸스 순열을 구하는 프로그램을 작성하시오
 * 
 * 입력 : 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다.
 * 
 * 출력 : 예제와 같이 요세푸스 순열을 출력한다./
 * 
 * 
 */
