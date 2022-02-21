package com.algorithm.a;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;


public class Main_3109_뱀 {

    private final static int[] DX = {1, -1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};

    private static int[][] arr;
    private static char[] command = new char[10001];
    private static int n, res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        n = Integer.parseInt(sc.nextLine());
        arr = new int[n + 2][n + 2];

        int apple = Integer.parseInt(sc.nextLine());
        for (int a = 0; a < apple; a++) {
            st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        for (int i = 0; i <= n + 1; i++) {
            if (i == 0 || i == n + 1) {
                for (int j = 0; j <= n + 1; j++) {
                    arr[i][j] = -1;
                }
            } else {
                arr[i][0] = -1;
                arr[i][n + 1] = -1;
            }
        }

        int l = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(sc.nextLine());
            command[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        ArrayList<Pair> snake = new ArrayList<>();
        snake.add(new Pair(1, 1, 2));
        arr[1][1] = 2;

        res = func(snake);
        System.out.println(res);
    }

    /**
     * 뱀 게임
     * 사과를 먹으면 뱀 길이가 늘어난다.
     * 벽, 자기 자신을 만나면 끝난다.
     * N*N
     * 칸에는 사과가 있다.
     * 보드의 가장자리는 벽이다.
     * 뱀은 맨위 맨좌측에서 시작하고, (1,1) 길이는 1이다, 맨 처음에는 오른쪽을 향한다.
     * <p>
     * 매 초마다 이동한다.
     * 1. 뱀은 먼저 몸 길이를 늘려 머리를 다음 칸에 위치시킨다.
     * 2. 만약 이동한 칸에 사과가 있다면, 그 칸에 사과는 없어지고 꼬리는 움직이지 않는다.
     * 3. 만약 이동한 칸에 사과가 없다면, 몸 길이를 줄여 꼬리가 위치한 칸을 비워준다.
     * 즉 몸길이는 변하지 않는다.
     * <p>
     * 몇 초 만에 끝나는지 계산
     * <p>
     * 1. 벽은 -1로 초기화,
     * 2. 사과는 1로 초기화.
     * 3. 뱀의 몸은 -2로 초기화
     */

    private static int func(ArrayList<Pair> snake) {
        int sec = 0;
        Pair head;
        boolean flag = true;

        while (flag) {
            //탈출 조건
            flag = false;
            //시간 증가
            sec++;

            //뱀 머리
            head = snake.get(0);

            int nx = DX[head.d] + head.x;
            int ny = DY[head.d] + head.y;

            //다음 칸 검사
            if (0 <= nx && nx < n+2 && 0 <= ny && ny < n+2) {
                //벽일 경우
                if (arr[nx][ny] == -1) {
                    break;
                }
                //자기 자신과 다을 경우
                else if (arr[nx][ny] == 2) {
                    break;
                }
                //사과를 먹을 경우
                else if (arr[nx][ny] == 1) {
                    //먹음, 머리 위치
                    arr[nx][ny] = 2;

                    //뱀 연장
                    int lastx = -1, lasty = -1;
                    for (Pair p : snake) {
                        lastx = p.x;
                        lasty = p.y;
                        p.x = nx;
                        p.y = ny;
                        nx = lastx;
                        ny = lasty;
                    }
                    if (lastx != -1 && lasty != -1) {
                        snake.add(new Pair(lastx, lasty, head.d));
                    }
                    flag = true;
                }
                //암것도 없을 경우
                else {
                    //머리 위치
                    arr[nx][ny] = 2;
                    //꼬리가 움직임
                    int lastx = -1, lasty = -1;
                    for (Pair p : snake) {
                        lastx = p.x;
                        lasty = p.y;
                        p.x = nx;
                        p.y = ny;
                        nx = lastx;
                        ny = lasty;
                    }
                    if (lastx != -1 && lasty != -1) {
                        arr[lastx][lasty] = 0;
                    }
                    flag = true;
                }

                //해당 시간에 명령어가 있다면
                if (command[sec] != 0) {
                    if (head.d == 0) {
                        if (command[sec] == 'D') {
                            head.d = 3;
                        } else if (command[sec] == 'L') {
                            head.d = 2;
                        }
                    } else if (head.d == 1) {
                        if (command[sec] == 'D') {
                            head.d = 2;
                        } else if (command[sec] == 'L') {
                            head.d = 3;
                        }
                    } else if (head.d == 2) {
                        if (command[sec] == 'D') {
                            head.d = 0;
                        } else if (command[sec] == 'L') {
                            head.d = 1;
                        }
                    } else {
                        if (command[sec] == 'D') {
                            head.d = 1;
                        } else if (command[sec] == 'L') {
                            head.d = 0;
                        }
                    }
                }

            }else break;
        }

        return sec;
    }

    private static class Pair {
        private int x;
        private int y;
        private int d;

        private Pair(final int x, final int y, final int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }


    }
}