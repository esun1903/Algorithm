import java.util.*;

public class Main_10809 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);

        //단어받기
        String S = sc.next();
        String N [] = new String[S.length()];
        int alparbet [] =new int[26];

        N =S.split("");

        //단어 출력 , 단어에 포함 안되어있으면 -1.
       // 있으면 순서대로 1 2 3 4 ~

        //일단 -1로 다 초기화 한다?  a - z = 26가지
        for(int i =0; i<alparbet.length;i++)
            alparbet[i]= -1;

        for(int i=0; i<S.length();i++){

        }

    }
}











     /*  int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q=-1;
        int r,s,t,u,v,w,x,y,z = -1;*/