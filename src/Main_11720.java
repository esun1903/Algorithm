import java.util. *;
public class Main_11720 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);
        //n의 갯수
        int n = sc.nextInt();
        String n2[] =new String[n];
        int result =0;

        //숫자 n개가 공백없이 주어진다.
        String a = sc.next();
        if( a.length()!=n )
            System.exit(0);

        //문자 자르기
        n2 = a.split("");

        //String to int and sum
        for(int i=0; i<n; i++){
           int t =Integer.parseInt(n2[i]);
            result += t ;
        }

        System.out.println(result);
    }
}
