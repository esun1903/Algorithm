import java.util.Scanner;

public class Main_2439 {
    public static void main(String ... args){

        Scanner rc = new Scanner (System.in);
        int n = rc.nextInt();  //입력받기 5
        int a = n-1; //4
        int i = 1;
        if(n<1 || n>100)
            System.exit(0);  // n의 범위지정


        for ( ; i<n+1; i++) {//큰 틀 정해주기  1,2,3,,,n까지
            a = n - i; //n-1 -> 4가 됨

            //빈칸 만들어주기
            for (; a > 0; a--) {   //4,3,2,1 이렇게 빈칸 만들기
                System.out.print(" ");
            }

            //* 채우기
            for (int b = 1; b < i+1; b++){   //1부터 i까지 i는 1
                System.out.print("*");
             }
            System.out.println("");

        }



    }
}
