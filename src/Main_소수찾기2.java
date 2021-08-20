package Programmers;

public class Main_소수찾기2 {
    public static void main(String ... args){

        System.out.println(solution(5));
    }//end of main

    public static int solution(int n) {
        int answer = 0;
        boolean flag;
        int arr [] = new int [n+1];
        arr[0] = 0;
        for(int i = 2; i*i<=n; i++ ){

        }

        return answer;
    }

}//end of class

/**
*
 * 흐름 (시간초과난다.)
 * - 에라토스테네스의 체를 이용하면 해결되는 문제
 * - 백준에서도 보았던 문제였는데 왜 까맣게 잊어버리는걸까 :)
 * - 잊지말자 소수찾기 = 에라토스테네스의 체!
 *
 * 1. 2부터 n까지 반복문을 돌면서  -
 * 2. 그 숫자를 또 반복문을 2부터 돌면서 나눠지는 게 없는지 체크한 후에
 * 3. 체크한 후 결과값에 answer에 추가한다.
 *
 *
 * 문제
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 *
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 *
 * 제한조건
 * - n은 2이상 100000000이하의 자연수입니다.
 *
 * 입출력 예
 *
 * n result
 * 10 4
 * 5 3
 *
 * 입출력 예 설명
 * 1부터 10 사이의 소수는  [2,3,5,7] 4개가 존재하므로 4를 반환
 *
 * 입출력 예 2
 * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
*
*
*
* */