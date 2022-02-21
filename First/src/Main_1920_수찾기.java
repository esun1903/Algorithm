import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

// 시간초과 
public class Main_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(arr);
        
		boolean flag; 
		int M = Integer.parseInt(br.readLine());
		int map[] = new int[M];
		 st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		} // end of for

		for (int j = 0; j < M; j++) {
                int num = map[j]; 
                flag = false; 
                for (int i = 0; i < N; i++) {
					 if(num == arr[i]) {
                            flag = true;
					          break;
					 }
                }
                if(flag == true) System.out.println(1);
                else 
                System.out.println(0);
		}

	}

}
