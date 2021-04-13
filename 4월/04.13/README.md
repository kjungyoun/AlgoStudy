#🌹 04.13 - 백준_G4_1504_특정한 최단 경로

## 📝 문제 주소

[백준 1504번: 특정한 최단 경로](https://www.acmicpc.net/problem/1504)

## 📝 알고리즘 분류

- 그래프 이론
- 다익스트라
- 플로이드와샬

## ⁉️ 알고리즘1 - 플로이드워샬

- matrix 에는 모든 경유지를 고려했을 때 출발점에서 목적지까지 최단 거리
- 특정 경유지를 반드시 거쳐야하므로 플로이드 워샬도 가능!

![Untitled](https://user-images.githubusercontent.com/48318620/114563557-79fe1480-9caa-11eb-8158-166f5b676210.png)

## 📜 코드 - 플로이드워샬

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int MAX = 50000;
		
		int matrix[][] = new int [N][N];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = weight;
		}
		
		st = new StringTokenizer(in.readLine());
		
		int v1 = Integer.parseInt(st.nextToken())-1; // 지나야하는 경유지1
		int v2 = Integer.parseInt(st.nextToken())-1; // 지나야하는 경유지2
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i != j && matrix[i][j] == 0) // 연결되지 않은 점 셋팅
					matrix[i][j] = MAX;
			}
		}
		
		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				for (int j = 0; j < N; j++) { // 도착지
					if(matrix[i][j] > matrix[i][k]+matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		
		int answer = Math.min(matrix[0][v1]+matrix[v1][v2]+matrix[v2][N-1]
				,matrix[0][v2]+matrix[v2][v1]+matrix[v1][N-1]);
		System.out.println(answer>=MAX ? -1 : answer);
		
		
	}

}
```

## ⁉️ 알고리즘2 - 다익스트라

- 다익스트라의 핵심은 따로 메소드로 빼서 start 점과 end 점을 매개변수로 넘겨주고 서로 다른 시작점에서의 다익스트라를 구하는 것이다.
- 다익스트라 구현시 for문으로 하지 않고 PrioiryQueue로 구현하면 성능을 향상 시킬 수 있다.

![Untitled1](https://user-images.githubusercontent.com/48318620/114563564-7bc7d800-9caa-11eb-88da-fdc73770bc6b.png)

## 📜 코드 - 다익스트라

```java
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
```