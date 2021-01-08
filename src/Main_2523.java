import java.util.*;

public class Main_2523 {
    public static void main(String  ... args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=1; i<n+1; i++){
            for(int t=0;t<i;t++)
                System.out.print("*");
            System.out.println("");
        }

        for(int i=n-1; i>0; i--){ //2번반복 //2 1
            for(int t= i;t>0;t--)//3 3<2
                 System.out.print("*");
            System.out.println("");
        }
}
}
