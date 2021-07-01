package Goorm;

import java.io.*;
class Main_소수고리 {

    public static StringBuilder sb;
    public static boolean[] visited;
    public static int input;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        int [] arr = new int [input+1];
        visited = new boolean[input+1];

        permutation(arr, 2);

        // System.out.println(sb.toString());

    }//end of main


    public static void permutation(int [] arr, int start){

        if(start == input+1){
            boolean answer = check(arr);
            if(answer == true){
                for(int i =1; i<input; i++){
                    System.out.print(arr[i]+" ");
                    // sb.append(arr[i]);
                    // sb.append(" ");
                }
                System.out.println(arr[input]);
                // sb.append(arr[input]);
                // sb.append("\n");
            }

            return;
        }


        arr[1] = 1;
        for (int j = 2; j <=input; j++) {
            if(!visited[j]) {
                visited[j] = true;
                arr[start] = j;
                permutation(arr,start+1);
                visited[j] = false;
            }
        }


    }//end of permutation method, 순열을 만드는 함수


    public static boolean check(int [] arr){

        boolean answer = true;
        for(int i = 1; i<arr.length; i++){
            if(i == arr.length-1){
                int sum = arr[1] + arr[i];
                if(check2(sum) == false){
                    answer = false;
                }
            }
            else {
                int sum = arr[i] + arr[i+1];
                if(check2(sum) == false){
                    answer = false;
                }
            }

        }//end of for



        return answer;
    }//end of check method, 인접한 모든 2개의 수들의 합이 소수인 경우를 찾는 함수


    public static boolean check2(int sum){

        boolean answer2 = true;
        for(int i = 2; i<sum; i++){
            if(sum%i==0){
                answer2 = false;
                break;
            }
        }//end of for

        return answer2;
    }//end of check2 method, 소수인지 체크하는 함수, 소수라면 1,자기자신을 제외하고 그 중간에 있는 숫자들이 모두 나머지가 있어야됨

}//end of class



/*
<생각한 흐름>
1. 순열로 해야겠다라는 생각이 먼저 들었다.
2. 입력받은 숫자만큼 순열을 한 뒤 -> 완성되었을때에 index[1]부터 왼쪽 오른쪽이 소수인지 체크하는 !
3. 체크할 때 함수를 따로 둬서 이게 소수인지 체크하는 것도 좋을 것 같다.

*/


