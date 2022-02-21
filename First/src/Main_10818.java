import java.util.*;
import java.util.Scanner;

public class Main_10818 {
    public static void main(String ... args){
        Scanner rc = new Scanner(System.in);
        int a = rc.nextInt(); //정수의 개수
        int n [] = new int [a];

        int min = -1, max =1000000;

        //입력받기
        for(int i= 0; i<a; i++)
            n[i] = rc.nextInt(); //n개의 정수를 공백으로 구분해서 주어진다

        //최솟값 과 최댓값
        for(int i=0; i<a; i++) {
            if (i == 0) {
                min = n[i];
                max = n[i];
            }
            if(max < n[i])
                max = n[i];
            if(min > n[i])
                min = n[i];
        }

        System.out.print(min+" "+ max);


    }
}
