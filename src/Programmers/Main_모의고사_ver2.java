package Programmers;

import java.util.ArrayList;

public class Main_모의고사_ver2 {

    public static void main(String ... args){
        int [] answers = {1,3,2,4,2};
        int [] result = solution(answers);
//        System.out.print("result는 ");
//       for(int i = 0; i<result.length; i++){
//           System.out.print(result[i]+" ");
//       }
//        System.out.println();
    }//end of main method

    public static int[] solution(int[] answers) {
        int arr[][] = {{1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}};
        int count[] = new int [3];


        for(int i = 0; i<answers.length; i++){
            if(arr[0][i%5] == answers[i]){
                count[0]++;
            }
            if(arr[1][i%8] == answers[i]){
                count[1]++;
            }
             if(arr[2][i%10] == answers[i]){
                count[2]++;
            }
        }//end of for

        int number = Math.max(count[0], Math.max(count[1],count[2]));
        ArrayList<Integer> list = new ArrayList<>();

//        System.out.println(?number);
        for(int i= 0; i<count.length; i++){
            if(count[i]==number){
                list.add(i+1);
            }
        }

        int answer[] = new int [list.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }//end of method
}
