import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;

public class Main_1978 {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //입력받기
        int a[] = new int[n]; //size만큼의 배열을 만들기
        int result = 0;
        int  x = 0;

        for (int i = 0; i < n; i++) { //입력받기 0부터
            a[i] = sc.nextInt(); //2
            x = 0;
            for (int t = 2; t <a[i]; t++) {  //1부터 2까지
                if (a[i] % t == 0) { // 소수가 아닌거임 2/2 = 0 ?
                    break;
                } else {
                   if(t==a[i]-1)
                     x += 1;
                }
            }
            if(a[i]==2)
                x++;
            if( x > 0 )
                result += 1;
        }

        System.out.println(result);

    }
}
