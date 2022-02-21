package Programmers;

public class Main_콜라츠추측 {

    public static void main(String ... args){

        int result = solution(16);
        System.out.println(result);


    }//end of main


    public static int answer = 0;
    public static int solution(int num) {

        if(answer == 500){
            return -1;
        }


        if(num == 1 ){
            return answer;
        }
        answer++;
        if(num%2 == 1){
            return solution(num*3+1);
        }
        else {
            return solution(num/2);
        }



    }
}//end of class


/*

흐름

1. for문으로 계속 반복하면서
   만약, 500번을 반복해다면 -1을 반환하기
2. 그게 아니라면 조건을 따라가기



문제

* 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지
* 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.
*
* 1-1. 입력된 수가 짝수라면 2로 나눕니다.
* 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
* 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
*
단, 작업이 500번을 반복해도 1이 되지않느다면 -1을 반환해 주세요.
**/