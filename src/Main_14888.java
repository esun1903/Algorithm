
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2시 10분에 시작했는데 아직도 : )

public class Main_14888 {

    public static int n;
    public static int [] a = new int[12];
    public static int [] operator = new int[4];
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void dfs(int index, int result) {
        if (index == n ) {
             min = Math.min(min,result);
             max = Math.max(max,result);
            return;
        }
        if(operator[0]>0){
            operator[0]--;
            dfs(index+1,result+a[index]);
            operator[0]++;
        }
        if(operator[1]>0){
            operator[1]--;
            dfs(index+1,result-a[index]);
            operator[1]++;
        }
        if(operator[2]>0){
            operator[2]--;
            dfs(index+1,result*a[index]);
            operator[2]++;
        }
        if(operator[3]>0){
            operator[3]--;
            dfs(index+1,result/a[index]);
            operator[3]++;
        }


    }

    public static void main(String... args) throws IOException {

        //  2시 10분 시작
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        //입력받기
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());

        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, a[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max+"\n");
        sb.append(min);
        System.out.println(sb.toString());
    }
}
