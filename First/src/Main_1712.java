import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main_1712 {
    public static void main(String ... args) throws IOException {


        //버퍼리더 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine()); //String 을 token단위로 끊어주는 것

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if(b >= c) {
            System.out.println(-1);  // 가변이 노트북가격을 넘기면 -1 (손익분기점을 계산할 수 없다)
       } else {
            System.out.println(a/(c-b)+1); //100
        }


    }
}
/*

   Scanner sc = new Scanner(System.in);

   //a , b , c
   int a = sc.nextInt();  //고정비용  1000
   int b = sc.nextInt();  // 가변비용(재료비와 인건비) 70
   int c = sc.nextInt();   // 노트북가격 170
  int r = c;
        int result = a+b ;
        int i =2;
        if()
      while(r<result)
      {
          result = result*i ;
          i++;
      }
   System.out.println(i);
 */