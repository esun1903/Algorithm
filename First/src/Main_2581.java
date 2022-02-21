import java.util.*;

public class Main_2581 {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        //두 자연수를 입력받기
        int m = sc.nextInt();
        int n = sc.nextInt();

        int min = 0;
        int add = 0;
        //m 이상 n이하 사이의 소수 찾아 더하고 , 최솟값 찾기
        for (int i = m; i <= n; i++) {

            for (int t = 2; t < i; t++) {  //1부터 2까지
                if (i % t == 0) { // 소수가 아닌거임 2/2 = 0 ?
                    break;
                } else {  //소수일때
                    if (t == i - 1) {
                        if (add == 0) {
                            min = i;
                        }
                        add += i;
                    }

                }

            }
            if(i==2){
                if(add ==0)
                    min = i;
                add+=i;
            };
        }

        if (min == 0 && add == 0)
            System.out.println(-1);
        else {
            System.out.println(add);
            System.out.println(min);
        }
    }
}
