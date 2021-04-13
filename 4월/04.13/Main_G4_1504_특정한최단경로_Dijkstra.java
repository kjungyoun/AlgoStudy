package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로_Dijkstra {
	static LinkedList<int[]> adjList[];
	static int N,E, MAX = 100000;
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N];
		for (int i = 0; i < N; i++) { // 인접리스트 각 행에 리스트 초기화
			adjList[i] = new LinkedList<int[]>();
		}
		
		for (int i = 0; i < E; i++) { // 인접리스트에 값 저장
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new int[] {to,weight});
			adjList[to].add(new int[] {from,weight});
		}
		
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken())-1;
		int v2 = Integer.parseInt(st.nextToken())-1;
		
		int v1Tov2 = dijkstra(v1,v2); // v1 -> v2 와 v2 -> v1은 같다.
		int rs1 = dijkstra(0,v1) + v1Tov2 + dijkstra(v2,N-1);
		int rs2 = dijkstra(0,v2) + v1Tov2 + dijkstra(v1,N-1);
		int answer = Math.min(rs1, rs2);
		System.out.println(answer >= MAX ? -1 : answer);
		
	}

	private static int dijkstra(int start, int end) {
		int distance[] = new int[N];
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		boolean visited[] = new boolean[N];
		Arrays.fill(distance,MAX);
		distance[start] = 0;
		queue.offer(new int[] {start,0});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int minX = temp[0];
			int minWeights = temp[1];
			
			if(visited[minX]) continue;
			visited[minX] = true;
			
			int size = adjList[minX].size();
			for (int i = 0; i < size; i++) {
				int vertex = adjList[minX].get(i)[0];
				int weights = adjList[minX].get(i)[1];
				if(!visited[vertex] && distance[vertex] > distance[minX] + weights) {
					distance[vertex] = distance[minX] + weights;
					queue.offer(new int[] {vertex,distance[vertex]});
				}
			}
		}
		
		
		return distance[end];
	}

}
