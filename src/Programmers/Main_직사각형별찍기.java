package Programmers;

import java.util.Scanner;

public class Main_직사각형별찍기 {

    public static void main(String ... args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i= 0; i<m; i++ ){
            for(int j = 0; j<n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
