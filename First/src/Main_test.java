

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main_test{
    static int n,l,r;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt(); // L명 이상
        r = sc.nextInt(); // R명 이하
        // 두 나라 인구 차이가 L명 이상 R명 이하면 국경선이 열린다.
        // 연합을 이루는 각 칸의 인구수는 
        // 연합 인구수 / 연합 이루는 칸의 개수 가된다.
        arr = new int[n][n];
        visited = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        }
        
        int result = 0;
        // 인구 이동이 안일어날 때 까지
        while(true) {
            boolean check = false; // 인구 이동이 일어났나 확인하는 변수
            teamN = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    // 다른 연합이 아닐 경우만 체크
                    if(visited[i][j]==0) {
                        // 인구 이동이 일어났으면 true
                        if(solve(i,j)) check = true;
                        
                    }
                }
            }
            if(check) result++; // 인구 이동이 일어났으면 +1
            else break; // 인구 이동이 일어나지 않았으면 종료
            
            // 다 살펴 봤으면 방문(연합 번호)초기화
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)
                    visited[i][j] = 0;
            }
        }
        for(int i=0;i<n;i++) {
        	System.out.println();
            for(int j=0;j<n;j++) {
                System.out.print(arr[i][j]+" ");
        }
    }
        
        System.out.println(result);
    }
    
    static int teamN;
    static int[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static boolean solve(int x,int y) {
        Queue<Pair> queue = new LinkedList<>();
        teamN++; // 각각의 연합에 번호를 부여하기 위해서
        queue.add(new Pair(x, y));
        visited[x][y] = teamN;
        int tHuman = arr[x][y];
        int tCnt = 1;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
                // 방문 체크 & 연합 구별
                if(visited[tx][ty]!=0) continue;
                // 두 나라의 차이가 범위안이라면
                if(check(arr[t.x][t.y], arr[tx][ty])) {
                    visited[tx][ty] = teamN;
                    tCnt++; // 연합 수 세기
                    tHuman+=arr[tx][ty]; // 인구 수 더하기
                    queue.add(new Pair(tx, ty));
                }
            }
        }
        
        // 같은 연합 인구 나누기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j]==teamN) {
                    arr[i][j] = tHuman/tCnt;
                }
            }
        }
        // tCnt가 1보다 크다는 것은 인구이동이 일어 났다는 것이다.
        if(tCnt>1) return true;
        else return false;
    }
    
    // 국경 체크
    private static boolean check(int n1,int n2) {
        int t = Math.abs(n1-n2);
        // 두 나라의 차이가 l명이상 r명 이하라면
        if(t>=l&&t<=r) return true;
        else return false;
    }
    
    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}