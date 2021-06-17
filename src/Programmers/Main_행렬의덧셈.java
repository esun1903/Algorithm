package Programmers;

public class Main_행렬의덧셈 {
    public static void  main(String ... args) {

        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};

       int [][] answer =  solution(arr1, arr2);


       for(int i = 0; i<answer.length; i++){
           for(int j = 0; j<answer[i].length; j++)
           System.out.println(answer[i][j]);
       }

 }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr1[0].length];

        //1) 배열의 행과 열의 사이즈를 알아야함
        //2)
        for(int i= 0; i<arr1.length; i++){
            for(int j = 0; j<arr1[i].length; j++){
              answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }// end of for

        return answer;
    }
}


/*
문제

행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
2개의 행렬 arr1, arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution 을 완성해주세요.

제한 조건
 - 행렬의 arr1, arr2의 행과 열의 길이는 500을 넘지않습니다.
* */
