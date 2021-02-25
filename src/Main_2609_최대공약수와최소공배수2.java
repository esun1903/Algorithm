import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수2 {

	public static void main(String[] args) throws Exception {
		//두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//최대공약수 : 유클리드 호제법이다. 
		// 최대공약수를 구하고자 하는 두 수 를 가지고 하는 법 
		int r= gcd(N,M);
	
		System.out.println(r);
		//최소공배수 : 최대공약수를 바탕으로 최소공배수를 구한다. 
		System.out.println((N*M)/r);

	}//end of main

	private static int gcd(int n, int m) {
		 if(m == 0) return n; 
		 return gcd(m,n%m); 
	}

}// end of class

