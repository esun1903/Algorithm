package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_Main_5644_무선충전 {
	  static int M, aCnt;// 시간, 충전소 개수
	   static int[] pathA, pathB, playerA, playerB; // 궤적, 위치
	   static int[][] ap;
	   static int[] dx = { 0, 0, 1, 0, -1 };
	   static int[] dy = { 0, -1, 0, 1, 0 };

	   public static void main(String[] args) throws IOException {

	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      int TC = Integer.parseInt(in.readLine());

	      StringTokenizer st = null;
	      playerA = new int[2];
	      playerB = new int[2];

	      for (int t = 1; t <= TC; t++) {
	         st = new StringTokenizer(in.readLine());
	         M = Integer.parseInt(st.nextToken());
	         aCnt = Integer.parseInt(st.nextToken());

	         // 플레이어 초기위치
	         playerA[0] = playerA[1] = 1;
	         playerB[0] = playerB[1] = 10;

	         pathA = new int[M + 1]; // 0초 포함
	         pathB = new int[M + 1];
	         ap = new int[aCnt][4];

	         String charsA = in.readLine();
	         String charsB = in.readLine();

	         for (int c = 0; c < M; c++) {
	            pathA[c + 1] = charsA.charAt(c * 2) - '0';
	            pathB[c + 1] = charsB.charAt(c * 2) - '0';
	         }

	         for (int a = 0; a < aCnt; a++) {
	            st = new StringTokenizer(in.readLine(), " ");
	            ap[a][0] = Integer.parseInt(st.nextToken());
	            ap[a][1] = Integer.parseInt(st.nextToken());
	            ap[a][2] = Integer.parseInt(st.nextToken());
	            ap[a][3] = Integer.parseInt(st.nextToken());
	         }

	         System.out.println("#" + t + " " + move());

	      }
	   }

	   public static int move() {// 매 시간마다 두 플레이어의 충전량의 합의 최댓값을 구하고 그 값을 모든시간동안 누적

	      ArrayList<Integer> aList, bList;
	      int totalSum = 0;
	      int time = 0;
	      while (time <= M) {
	         // 두 플레이어를 해당 시간의 이동정보에 맞게 이동
	         playerA[0] += dx[pathA[time]];
	         playerA[1] += dy[pathA[time]];

	         playerB[0] += dx[pathB[time]];
	         playerB[1] += dy[pathB[time]];

	         // 두 플레이어의 자신의 위치 기준으로 충전가능한 충전소 리스트 가져오기
	         aList = getAp(playerA[0], playerA[1]);
	         bList = getAp(playerB[0], playerB[1]);

	         totalSum += getCharge(aList, bList);
	         time++;
	      }

	      return totalSum;
	   }

	   private static int getCharge(ArrayList<Integer> aList, ArrayList<Integer> bList) {
	      int max = 0, tmp = 0;

	      int aSize = aList.size(), bSize = bList.size();
	      if (aSize == 0 && bSize == 0)
	         return 0;
	      else if(aSize==0)
	         return getMaxPower(bList);
	      else if(bSize==0)
	         return getMaxPower(aList);
	      // 플레이어 두명 모두 충전 가능한 상황은 전부 조합 고려
	      else {
	         for(int a:aList) {
	            for(int b:bList) {
	               if(a!=b)
	                  tmp=ap[a][3]+ap[b][3];
	               else
	                  tmp=ap[a][3];
	               
	               if(max<tmp) max=tmp;
	            }
	         }
	      }
	         
	      return max;
	   }

	   private static int getMaxPower(ArrayList<Integer> apList) {
	      int max=0;
	      for(int a:apList) {
	         if(max<ap[a][3])
	            max=ap[a][3];
	      }
	      return max;
	   }

	   private static ArrayList<Integer> getAp(int x, int y) {
	      ArrayList<Integer> apList = new ArrayList<Integer>();
	      int d = 0;
	      for (int a = 0; a < aCnt; a++) {
	         d = Math.abs(ap[a][0] - x) + Math.abs(ap[a][1] - y);
	         if (d <= ap[a][2])
	            apList.add(a);
	      }
	      return apList;
	   }

	}