import java.util.Scanner;

public class Main_2438 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();  //5
        //배열 만들필요없지 (

        for (int i = 1; i<a+1 ;i++) { // 1 ,2, 3, 4, 5, 큰틀
            for (int c = 1; c <=i ; c++) //작은 틀
            {  System.out.print("*");  //별
        }
            System.out.println("");
        }

    }
}
