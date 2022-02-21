import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static boolean[] visit;
    private static int [] order;
    private static int n, m ;

    public static void main(String... args) throws IOException {


        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        order= new int [n+1];

        func(0,0);

      //  bw.write(sb.toString());
       // bw.close();
        br.close();
    }

    private static void func(final int x, final int count){
        if(count == m ){

        }
    }
}
