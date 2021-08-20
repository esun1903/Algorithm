package Programmers;

import java.util.Arrays;

public class Main_큰수만들기 {

    public static int ans = Integer.MIN_VALUE;

    public static void main(String ... args){

//        System.out.println( solution("1924",2));
        System.out.println( solution("1231234",3));
//        System.out.println( solution("4177252841",4));
    }//end of main

    public static String solution(String number, int k) {
        String answer = "";

        boolean [] visited = new boolean [number.length()];
        int [] arr  = new int [number.length()-k+1];

        calculator(0, arr,number, number.length()-k, visited);

        return Integer.toString(ans);
    }

    private static void calculator(int i, int[] arr,String number, int k ,boolean [] visited) {
//       Arrays.sort(arr);
        if(i == k){
        String str = "";
//        Arrays.sort(arr);
        for(int j = 0; j<arr.length-1; j++){

            System.out.print(number.charAt(arr[j])+" ");
           str += Integer.toString(number.charAt(arr[j])-'0');
        }

        System.out.println();
        ans = Math.max(Integer.parseInt(str),ans);
        return ;
    }
    for(int j = 0; j<number.length(); j++ ){
        if(visited[j] == false){
            visited[j] = true;
            arr[i] = j;
            calculator(i+1, arr,number,k,visited);
           visited[j] = false;
        }
    }//end of for

    }//end of method
}//end of class


/**
 * 흐름
 *
 * 1. number의 배열 size에서 k개를 뽑는 수열
 * 2. 그 다음 가장 큰 값을 찾기
 *
 * 문제
 *
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 *
 */