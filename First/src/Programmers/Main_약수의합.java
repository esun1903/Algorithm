package Programmers;

public class Main_약수의합 {

    public static void main(String ... args){

        System.out.println(solution(12));

    }

    public static int solution(int n) {
        int answer = 0;

        for(int i= 1; i<=n; i++){
            if(n%i == 0){
                answer+=i;
            }
        }//end of for

        return answer;
    } // end of method

}//end of class


/**
 * 흐름
 *
 * 1. 1부터 N까지 반복하면서 나머지가 0 이면 answer에 더한다.
 *
 *
 * 문제
 *
 * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수,
 * solution을 완성해주세요
 *
 */
