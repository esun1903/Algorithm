package Programmers;

public class Main_정수제곱근판별 {

    public static void main(String ... args){

        long num = solution(121);
        System.out.println(num);

    }// end of main

    public static long solution(long n) {
        long answer = 0;

        double number = Math.sqrt(n);
        int one = (int)number;
        double two = number - one;

        //소숫점이다.
        if(two>0){
            return -1;
        }
        else {
          return (long) ((number+1)*(number+1));
        }
    }//end of method
}

/**
 * 생각
 * 1. 일단 라이브러리를 사용해서 구하기
 * 2. 만약, x의 제곱이라면 x+1의 제곱을 리턴하고,
 *    n의 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하기
 *
 *
 * 문제
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
 * n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * 제한 사항
 * - n은 1이상, 50000000000 이하인 양의 정수 입니다.
 *
 * 입출력 예
 * n return 144
 * 121 144
 * 3 -1
 *
 */