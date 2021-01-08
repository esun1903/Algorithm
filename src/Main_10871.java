import java.util.Scanner;

public class Main_10871 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //정수 N개
        int x = sc.nextInt();  //정수
        int a [] = new int [n]; //배열

        if (n<1 || x>10000)  //범위를 벗어나면
            System.exit(0);

        //n개 만큼의 숫자를 입력할 수 있게
        for(int i = 0; i<n; i++)  //0부터 n-1까지 입력됨
            a [i] = sc.nextInt();


        for(int i2 = 0; i2 < n ; i2++){  //범위 벗어나면
            if(a[i2] <1 || a[i2]>10000)
                System.exit(0);
        }

        //x보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력.
        for(int i3 = 0; i3 < n ; i3++){
            int xs = a[i3];
            if(x > xs)
                System.out.print(xs+" ");
        }

    }
}
