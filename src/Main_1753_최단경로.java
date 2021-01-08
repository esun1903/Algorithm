package com.algorithm.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
  
	private static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	// arrayList 
	private static int [] dist; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());  // 정점의 개수 
		int E = Integer.parseInt(st.nextToken());  // 간선의 개수 
		dist = new int[V + 1];
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호 
		
		for (int i = 0; i <= V; i++) { //정점의 개수만큼 arraylist 
			list.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE; // INF를 구분하기위해 
		}
		
		
		// (u,v,w) 순서대로 주어진다.  u -> v로 가는 가중치 w인 간선이 존재한다는 뜻 
		// 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의! -> 최단 경로의 경로 값 	
		
		for (int i = 1; i <= E; i++) {  // 간선의 개수만큼 for문 돌기 
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(b  + c); //  11을 왜곱하지 ?
		} // end of for 
			
		
		dijkstra(K);
			
	   for (int i = 1; i <=V; i++) {
		 if(dist[i] == Integer.MAX_VALUE)  // 만약 max_value라면 INF로 하기 
			  sb.append("INF").append("\n");
		 else
			 sb.append(dist[i]).append("\n");
	}
	   
	   bw.write(sb.toString());
		bw.close();
		br.close();
		} // end of main
	
	private static void dijkstra(int k) {
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();   // 우선순위 큐 
		queue.offer(new Pair(k, 0));
		dist[k] = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int v = p.index;
			int c = p.value;
			if (dist[v] < c)
				continue;
			for (int n : list.get(v)) { 
				int nv = n / 11;
				int nc = (n % 11) + c;
				if (dist[nv] > nc) {
					dist[nv] = nc;
					queue.offer(new Pair(nv, nc));
				}
			}
		}
		
	}// end of dijkstra 
	
	private static class Pair implements Comparable<Pair> {
		private int index;
		private int value;

		public Pair(final int index, final int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.value - arg0.value;
		}
	}
	}// end of class

/*
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단경로를 구하는 프로그램을
 * 작성하시오
 * 단, 모든 간선의 가중치는 10이하으이 자연수이다. 
 * 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 
 * 모든 정점에는 1부터 V까지 번호가 매겨져 있다고  가정한다
 * 둘째 줄에는 시작정점의 번호가 주어진다. 셋째 줄부터 w인 간선이 존재한다는 뜻이다
 * u와 v는 서로 다르며  w는 10 이하의 자연수이다. 서로 다른 두 정점사이에 여러 개의 간선이 존재할
 * 수 있음에 유의한다. 
 * 
 * ㄹ력) 첫째 줄부터 V개 줄에 걸쳐서 , i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다
 * 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면된다. */
 