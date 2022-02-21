import java.util.*;
public class Main_2446 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //5
        int t =1;  //9 -> 7 이렇게 줄여가는거
        int l =0;  //공백만들기 변수
        int u =2;
        for(int i=n; i>0; i--){ //(1)
            //공백만들어주기
            for(int y =0; y<l; y++){
                System.out.print(" ");
            }
            for(int x = 2*n-t ;x>0;x--) //(2) 줄어가는거
                System.out.print("*");

            System.out.println("");
            t+=2;
            l++;

        }

        for(int i=0; i<n-1; i++){ //(1) 4번할꺼
            //공백만들어주기

            for(int y =l-2; y>0; y--){
                System.out.print(" ");
            }
            for(int c = 0; c<2*u-1;c++) //(2) 줄어가는거
                System.out.print("*");

            System.out.println("");
            t+=2;
            l--;
            u++;


        }

    }
}
