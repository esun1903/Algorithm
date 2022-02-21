package com.algorithm.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14500_테트로미노2 {

    public static class RC{
        int r, c, step, sum;

        RC(int r, int c, int step, int sum) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.sum = sum;
        }
    }

    static int[] dC = {0, 0, -1, 1};
    static int[] dR = {-1, 1, 0, 0};
    static int nR, nC;

    static int R, C, ANS;
    static int[][] map;
    static BufferedReader bfr;
    static BufferedWriter bfw;
    static StringTokenizer strTkn;
    static Queue<RC> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        bfr = new BufferedReader(new InputStreamReader(System.in));
        bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        strTkn = new StringTokenizer(bfr.readLine(), " ");
        R = Integer.parseInt(strTkn.nextToken());
        C = Integer.parseInt(strTkn.nextToken());
        map = new int[R][C];

        for(int r=0; r<R; r++) {
            strTkn = new StringTokenizer(bfr.readLine(), " ");
            for(int c=0; c<C; c++) {
                map[r][c] = Integer.parseInt(strTkn.nextToken());
            }
        }
        
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                bfs(r, c, 0);
                searchException(r, c);
            }
        }
        
        bfw.write(String.valueOf(ANS));
        bfw.flush();
        bfw.close();
    }// end of main()
    
    public static void bfs(int r, int c, int step) {
        queue.offer(new RC(r, c, step, map[r][c]));
        int nStep, nSum;
        
        while(!queue.isEmpty()) {
            RC rc = queue.poll();
            if(rc.step>=3) {
                ANS = Math.max(ANS, rc.sum);
                continue;
            }

            nStep = rc.step + 1;
            for(int dir=0; dir<4; dir++) {
                nR = rc.r + dR[dir]; 
                nC = rc.c + dC[dir];
                
                if(nR<0 || nC<0 || nR>=R || nC>=C) continue;

                nSum = rc.sum + map[nR][nC];
                queue.offer(new RC(nR, nC, nStep, nSum));
            }
        }// end of while()

    }// end of bfs()

    public static void searchException(int r, int c) {
        // up
        if(r>=0 && r<R-1 && c>=1 && c<C-1) {
            ANS = Math.max(ANS, map[r][c] +              + map[r+1][c] + map[r][c-1] + map[r][c+1]);
        }
        // down
        if(r>=1 && r<R && c>=1 && c<C-1) {
            ANS = Math.max(ANS, map[r][c] + map[r-1][c] +               + map[r][c-1] + map[r][c+1]);
        }
        // left
        if(r>=1 && r<R-1 && c>=0 && c<C-1) {
            ANS = Math.max(ANS, map[r][c] + map[r-1][c] + map[r+1][c] +             + map[r][c+1]);
        }
        // right
        if(r>=1 && r<R-1 && c>=1 && c<C) {
            ANS = Math.max(ANS, map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1]                );
        }

    }// end of searchExcpetion()

}