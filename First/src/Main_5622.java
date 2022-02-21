import java.util.*;

public class Main_5622 {
    public static void main(String ... args){

        /* 숫자 1을 걸려면 총 2초가 필요하다.
           1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며
           한 칸 옆에 있는 숫자를 걸기 위해서는 1초씩 더 걸린다.
         */

        Scanner sc= new Scanner(System.in);
        String s = sc.next();  //UNUCIC 단어 받기
        int result =0;

        /* ABC = 2; DEF = 3; GHI = 4;
           JKL = 5; MNO = 6; PQRS = 7;
           TUV =8;  WXYZ = 9;   */

        for(int i =0; i<s.length(); i++){
           char a = s.charAt(i);
           result ++;
           //CHAR 형비교는 이렇게 ! 너무 더럽게 풀어서 다른사람꺼 봐야함
           if(a < 'D')
             result += 2;
           else if (a <'G')
               result += 3;
           else if (a <'J')
               result += 4;
           else if (a <'M')
               result += 5;
           else if (a <'P')
               result += 6;
           else if (a <'T')
               result += 7;
           else if (a <'W')
               result += 8;
           else
               result += 9;
        }

        System.out.println(result);
    }
}
