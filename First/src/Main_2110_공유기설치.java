import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2110_공유기설치 {

	/*
	 * 안풀리다가 겨우 마이구미님 블로그 보고 해결,,,,
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 집의 개수
		int C = sc.nextInt(); // 공유기 개수
		int[] arr = new int[N]; // 집의 개수 만큼 배열 생성

		// 1) 집의 좌표들을 입력받기
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr); // 배열을 정렬하므로써 오름차순으로 정려랗기

		// 2) 최소거리
		int min = 1;
		// 3) 최대거리
		int max = arr[N - 1] - arr[0];
		int distance = 0;

		int ans = 0; 
		while (min <= max) { // 최소거리에서 부터 최대거리
			// 최소거리부터 최대거리까지 while 문으로 반복하면서
			int mid = (min + max) / 2; // 중간값 
			int start = arr[0]; // 스타트
			int cnt = 1; 
			
			for (int i = 1; i < N; i++) { // 5까지  
				distance = arr[i] - start; // arr[i] - start 를 하면 -> 2 - 1 = 1 이 나올 것 .
                 if(mid <= distance) {  // if 까지 mid <= distance 
                	 ++cnt; // cnt ++ 하기 
                	 start = arr[i]; 
                 } 
			} //end of for 
			
			if(cnt >= C) {  // 공유기의 수를 줄이자 => 간격 넓히기
				ans = mid; 
				min = mid + 1; 
			}
			else {  // 공유기가 더 설치되어야한다. => 간격 좁히기
				max = mid -1; 
			}
			
		}
  
	      System.out.println(ans);	 
	} 
}

/*
 * 하지만 좌표의 수의 최대값이 1000000000 이라서 시간 초과를 경험할 수 있다.
 * 
 * 즉, 단순한 탐색(O(n^2)) 으로는 해결 할 수 없다.
 * 
 * 시간을 줄이기 위해 우리는 이분 탐색을 사용할 수 있다. 각 간격을 기준으로 일일이 확인하는 것이 아닌 이분 탐색의 방식을 이용하는
 * 것이다. 1. 특정 간격을 기준으로 가능한 위치에 공유기를 설치한다. 설치한 후에는 다음과 판단한다. 2. 공유기 수가 더 설치되어야
 * 한다면, 간격을 줄인다. 3. 공유기 수를 줄여야한다면, 간격을 늘린다.
 * 
 * 
 * 출처: https://mygumi.tistory.com/301 [마이구미의 HelloWorld]
 */
