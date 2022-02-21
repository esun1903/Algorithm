package Programmers;

public class Main_제일작은수제거하기 {

    public static void main(String ... args){

       int [] arr2 = {10};
       int [] arr =  solution(arr2);

       for(int i= 0; i<arr.length; i++){
           System.out.println(arr[i]);
       }
    }//end of main

    public static int[] solution(int[] arr) {

        //1) 1의 경우
        if(arr.length==1) {
            int [] answer = {-1};
            return answer;
        }

        //2) 2의 경우
        int index = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i]<arr[index]){
                index = i;
            }
        }//end of for

        int [] answer = new int [arr.length-1];
        int count = 0;
        for(int i = 0; i<arr.length; i++){
         if(i == index)
             continue;
         else {
             answer[count] = arr[i];
             count++;
         }
        }
        return answer;
    }//end of solution

}//end of class

/**
 *
 * 흐름
 *
 * 1. 조건을 붙이기
 * 2. 가장 작은 수를 찾아 (index값을 저장) -> 없애기
 *
 * 문제
 *
 * 정수를 저장한 배열, arr에서 가장 작은 수를 제거한 배열을 리턴하는 함수,
 * solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우에 배열에 -1을 채워 리턴하세요.
 * 예를들어 arr이 [4,3,2,1]인 경우에
 * [4,3,2]를 리턴하고, [10]이면 [-1]을 리턴합니다.
 *
 * 제한 조건
 *  - arr은 길이 1이상인 배열입니다.
 *  - 인덱스 i,j에 대해 i!=j이면 arr[i] != arr[j] 입니다.
 *
 */