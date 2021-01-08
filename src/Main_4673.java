import java.util.*;

public class Main_4673 {
    public static void main(String ... args) {

        int n = 1;
        //생성자 자체는
        while (true) {
            //여기부분이 막혔다,,,,,ㅜ 계속 헤맴
            int a= n%10;
            n = n/10;
            if(n == 0)
                break;
        }
        System.out.println(n);
    }
}

        /*   33 + 3 + 3 = 39
             39 + 3 + 9 = 51
          n을 d(n)의 생성자라고 한다.
          위의 수열에서 33은 39의 생성자이고
           생성자 없는 숫자 = 셀프넘버
           */
//생성자를 만드는 함수를 만들고
//그게 아니면 출력하면 되는