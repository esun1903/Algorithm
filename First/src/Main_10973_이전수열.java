package day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10973_이전수열 {

	
	 static int N; 
	 static int [] input;
	public static void main(String[] args) throws IOException {
  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
		  input[i] = Integer.parseInt(st.nextToken());
	}
       nextPermutation(input);
  
	}
	private static void nextPermutation(int[] numbers) {
		//Step1. 꼭대기 찾기 
		int i = N-1;
		while(i>0 && numbers[i-1]<=numbers[i]) --i;   //부등호 변경
		if(i==0) {  //만약 오름차순이 되어있다면 -1를 sout하고 return 하기 
			System.out.println(-1);
			return; 
		}
		
	   //Step2. 꼭대기 값중 작은값중 가장 큰값을 찾기 
		int j = N-1; 
		while(numbers[i-1]<=numbers[j]) --j;  //부등호 변경 
		
		//Step3. 꼭대기값과 그값을 바꾸기 
		swap(numbers,i-1,j);
		
		//Step4. 그값 뒤로 오름차순으로 바꾸기 
	    int k = N-1; 
	    while(i<k)
	    	swap(numbers, i++, k--);

		for (int t = 0; t < numbers.length; t++)
			System.out.print(numbers[t] + " ");
	    	
	}
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
