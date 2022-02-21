package Programmers;

public class Main_하샤드수 {
    public static void main(String... args) {

        boolean flag = solution(11);
        System.out.println(flag);
    } //end of main

    public static boolean solution(int x) {
        boolean answer = true;


        String str = Integer.toString(x);
        int sum = 0;

        for(int i= 0; i< str.length(); i++){
          int n =  str.charAt(i) -'0';
          sum += n;
        } // end of for

        System.out.println(sum);

        if(x%sum == 0) {
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }//end of solution

}//end of class

/*
흐름

1. 입력받은 x를 반복문을 돌려서 자릿수의 합을 구하기
2. 그 다음 자릿수의 합을 x로 나눠서 잘 나오는지 확인하기.

문제

양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
예를 들어 18의 자릿수 합은 1+8 = 9이고, 18은 9로 나누어 떨어지므로
18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수,
solution을 완성해주세요.

입출력 예
10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.

입출력 예 2
12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.

 */