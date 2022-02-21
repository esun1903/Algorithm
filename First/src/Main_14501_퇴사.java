package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

    public static void main(String ... args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int arr [][] = new int [N+1][2];
        for(int i= 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
        arr[i][0] = Integer.parseInt(st.nextToken());
        arr[i][1] = Integer.parseInt(st.nextToken());
        }//end of for

        int ans = 0;


    }//end of main
}//end of class


/**
 * 흐름
 *
 * 1.
 * 2
 *
 * 문제
 * 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
 * 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
 * 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을
 * 잡아놓았다.
 * 각각의 상담은 상담을 완료하는데 걸리는 시간 T와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져있다.
 * 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 *
 *
 * 입력
 * 첫째 줄에 N이 주어진다.
 * 둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어 주어지며, 1일부터 N일까지 순서대로 주어진다.
 *
 * 출력
 * 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
 */