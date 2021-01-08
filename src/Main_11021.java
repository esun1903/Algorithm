import java.util.Scanner;


public class Main_11021 {
    public static void main(String ... args){
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();
        int a[] = new int [T*2];
        int number = 0;
        for(int i = 0 ; i<T*2 ;i++) {
            int n = sc.nextInt();
            a[i] = n;
        }

        for(int i = 0; i<T; i++){
            System.out.println("Case #"+(i+1)+":"+" "+ (a[number++]+a[number++]) );
        }


    }
}
