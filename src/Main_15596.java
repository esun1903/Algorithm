import java.util.*;
public class Main_15596  {

    long sum(int[] a) {
        long ans = 0;
        //a:합을 구해야하는 정수 n개가 저장되어 있는 배열
       for(int i=0; i<a.length;i++)
           ans +=a[i];

        return ans;  //리턴값: a에 포함되어있는 정수 n개의 합
    }
}

