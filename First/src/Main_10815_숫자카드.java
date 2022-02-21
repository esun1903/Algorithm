import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); 
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr [] = new int [N]; 
		HashSet<Integer> set= new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
	
		
		st = new StringTokenizer(br.readLine());
		int M= Integer.parseInt(st.nextToken());
		int num  [] = new int [M];		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <M; i++) {
			num [i] =  Integer.parseInt(st.nextToken());
			boolean flag = set.add(num[i]); 
			if(flag == true)
				sb.append(0+" ");
			else 
				sb.append(1+" ");
			}
		System.out.println(sb.toString());

		
		
		
		
	}

}

/*
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * */
 