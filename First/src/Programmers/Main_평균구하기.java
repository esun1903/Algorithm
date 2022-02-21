package Programmers;

public class Main_평균구하기 {
    public static void main(String ... args){

        int arr[] = {1,2,3,4};
        double n = solution(arr);

        System.out.println(n);


    }
    public static double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        for(int i= 0; i<arr.length; i++){
           sum += arr[i];
        }

//        System.out.println(sum);
        answer = sum/arr.length;
        return answer;
    }
}
