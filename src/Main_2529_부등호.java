import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 

// 마이구미님꺼를 보고 함,,,ㅠㅠㅠ  
// 내가 풀었던 버전은 정말 if문하나하나를 비교하면서 진행했었는데
// 백트래킹을 이렇게 하시는구나를 보며 이해하고 넘어간 부등호 :) 
// 다음주엔 다시 풀어봐야겠다! 
public class Main_2529_부등호 {
    static List<String> list = new ArrayList<>();
    static boolean [] visited = new boolean[10];
    static String [] s;
 
    public static void go(int num, int cnt, String key, int n) {
        if(cnt == n) {
            list.add(key);
        }
        else {
            for(int i=0; i<=9; i++) {
                if(!visited[i]) {
                    if(s[cnt].equals("<")) {
                        if(num>=i) {
                            continue;
                        }
                    }
                    else {
                        if(num<=i) {
                            continue;
                        }
                    }
                    visited[i]= true;
                    go(i, cnt+1, key+i, n); // 이 부분에서 놀랐다. String 형태에서 i를 추가해가면서 정답을 완선시키는것,,,! 진짜 좋은 방법같다. 
                }
            }
        }
        visited[num] = false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        s = scan.nextLine().split(" ");
 
        for(int i=0; i<=9; i++) {
            visited[i] = true;
            go(i, 0, i+"", n);
        }
        
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
}