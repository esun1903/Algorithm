package Programmers;

import java.util.Arrays;

public class Main_입국심사_ver2 {

    public static void main(String ...args ){

        int [] times = {7,10};
        System.out.println(solution(6,times));

    }//end of main


    public static long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;

        Arrays.sort(times);
        long left= 1;
        long right = (long) times[times.length-1]*n; //이걸 블로그 보고 알게 됨 ㅎ 아악
        long mid = 0;


        while(left<=right){
            mid = (left+ right)/2;
            long person = 0;
            //심사관 당 맡을 수 있는 입국자 수
            for(int i = 0; i<times.length; i++){
                person+= mid/times[i];
            }//end of for

            if(person<n){ //만약, 모은 입국자의 수가 n보다 작으면? left는 ? right는 ?
                left = mid + 1;
            }else {   //만약, 모은 입국자의 수가 n보다 작으면? left는 ? right는 ?
                right = mid -1;
                answer = Math.min(answer, mid);
            }

        }//end of while

        return answer;
    }//end of solution method
}//end of class


/**
 *
 * 입국심사가 프로그래머스에서 이분탐색으로 나와있었는데
 * 사실 왜 이분탐색으로 풀어야하는지 모르겠어서
 * 내가 생각한대로 흐름을 짜서 풀어보았지만 코드의 양은 방대했고, 생각해도 되지 않았다.
 * 그래서 프로그래머스의 말 대로.. 왜 이분탐색인지 생각하며 풀어보기로 한 version2.
 *
 * 일단, 이분탐색이란 무엇인지! :) -> 왜 나는 이분탐색이라는 개념을 알면서 문제와 연결을 잇지를 못하는지
 * -> 이게 가장 요즘 나의 고민이다.
 * -> 개념은 알아도 문제에 직접적으로 적용을 시키지 못한다는 것!
 *
 * < 추정 시간값/ 각 심사관별 심사시간 = 심사관당 맡을 수 있는 입국자 수 >
 * 이분탐색에서 중요한 left, mid, right에서
 * left : times에서 가장 최솟값 =  Arrays.sort한 뒤, times[0]*n이 될 것 같다.
 * right : times에서 가장 큰 값이 나올만한 것 -> Arrays.sort한 뒤, times[times.length-1] * n 값이 될 것 같다.
 *
 *
 * 가장 어려웠던 점
 *
 * 1. 이 문제가 왜 이분 탐색으로 풀면 되는지를 모르겠다는 점
 * 2. < 추정 시간값/ 각 심사관별 심사시간 = 심사관당 맡을 수 있는 입국자 수 > 이 식을 블로그 봐서야 알게 됐다는 점
 * 3. Math.min(answer, mid)로 하면 안되는 점
 * 4. long형으로 모두 바꿔야한다는 점 :)
 *
 * -> 수요일에 이야기 해봐야겠다.
 *
 *
 * 참고한 블로그 : https://swycha.tistory.com/122
 */