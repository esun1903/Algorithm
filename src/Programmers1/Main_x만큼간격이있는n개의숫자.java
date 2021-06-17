package Programmers;

import java.util.*;

public class Main_x만큼간격이있는n개의숫자 {
    public static void  main(String ... args) {

     long [] answer =   solution(2,5);

     for(int i = 0; i< answer.length; i++){
         System.out.println(answer[i]);
     }

    }
    public static long[] solution(int x, int n) {
        long[] answer = new long [n];

        long num = x;
        answer[0] = x;
        for (int i = 1; i<n; i++){
            num+=x;
            answer[i] = num;
        }// end of for

        return answer;

    }
}

/*
* 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를
* n개 지니는 리스트를 리턴해야 합니다.
* */
