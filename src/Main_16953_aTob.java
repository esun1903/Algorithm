import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16953_aTob {

	public static long A;
	public static long B;
	public static long result;

	//  long인것때문에 계속틀렸던 문제 ㅠ 어떤게 long이고 int인지 확인해봐야겠다( 구분할수있는것 ) 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		result = Integer.MAX_VALUE;

		bfs();
        if(result == Integer.MAX_VALUE)
        	 System.out.println(-1);
        else
	    	System.out.println(result);
	}

	private static void bfs() {

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(A, 1));

		while (!queue.isEmpty()) {
			Pair P = queue.poll();

		//	System.out.println("===========");
			for (int i = 0; i < 2; i++) {
				long num = 0;
				if (i == 0) { // 2를 곱한다,.
					num = P.n * 2;
			//		System.out.println("1번 "+num); 
					if (num < B) {
						queue.add(new Pair(num, P.count + 1));
					} else if (num == B) {
			//			System.out.println(num+" "+num+" "+(P.count+1));
					    result =   Math.min(result, P.count+1);
					}

				} else { // 1을 수의 가장 오른쪽에 추가한다.
					num = P.n *10 + 1;
		//			System.out.println("2번 "+num);
					if (num < B) {
						queue.add(new Pair(num, P.count + 1));
					} else if (num == B) {
			//			System.out.println(num+" "+num+" "+(P.count+1));
					    result =   Math.min(result, P.count+1);
					}
				}
			}

		} // end of while

	}

	public static class Pair {
		long n;
		long count;
		
		public Pair(long n, long count) {
			super();
			this.n = n;
			this.count = count;
		}
		public long getN() {
			return n;
		}
		public void setN(long n) {
			this.n = n;
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}


	}

}

/*
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다. 1. 2를 곱한다. 2. 1를 수의 가장 오른쪽에 추가한다.
 * 
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자
 * 
 * 첫째 줄에, A,B가 주어진다. A를 B로 바꾸는데 필요한 연산의 최솟값에 1를 더한 값을 출력한다. 만들 수 없는 경우에는 -1를
 * 출력한다.
 */
