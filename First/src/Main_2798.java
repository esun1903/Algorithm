

import java.util.Scanner;

public class Main_2798 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int number =sc.nextInt();

        int sum=0;
        int NUM[]= new int[count];
        int gap1;
        int gap2=number;
        int temp = 0;
        for(int i=0;i<count;i++) {
            NUM[i]=sc.nextInt();
        }



        for(int i=0;i<count;i++) {
            for(int j=i+1;j<count;j++) {
                for(int k=j+1;k<count;k++) {
                    sum =NUM[i]+NUM[j]+NUM[k];
                    if(temp<sum&&sum<=number) {
                        temp=sum;
                    }
                }
            }
        }
        System.out.println(temp);
    }

}

