package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_1219_길찾기 {
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			if(vertex == 99) return 1;
			int size = adjList[vertex].size();
			for (int i = 0; i < size; i++) {
				int next = adjList[vertex].get(i);
				if(!visited[next]) {
					queue.add(next);
				}
			}
		}
		return 0;
	}
	
	static LinkedList<Integer> adjList[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <=10; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken()); // 인접 정점 정보 개수
			adjList = new LinkedList[100];
			visited = new boolean[100];
			
			for (int i = 0; i < 100; i++) { // 인접리스트 초기화
				adjList[i] = new LinkedList<Integer>();
			}
			
			st = new StringTokenizer(in.readLine()); // 인접 리스트 생성
			for (int i = 0; i < V; i++) {
				adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			System.out.println("#"+tc+" "+bfs());
		}		
	}
}
