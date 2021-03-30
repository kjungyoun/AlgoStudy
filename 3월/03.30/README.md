#🌹 03.27 - 백준_S2_1890_점프

## 📝 문제 주소

[백준 1890번: 점프](https://www.acmicpc.net/problem/1890)

## 📝 알고리즘 분류

- 다이내믹 프로그래밍 DP

## ⁉️ 알고리즘 1 - BFS

![Untitled1](https://user-images.githubusercontent.com/48318620/112981891-c0298300-9196-11eb-8387-62c9f17a2586.png)

## 📜 코드

- 메모리 초과 발생

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1890_점프_BFS {
	
	static int N, endR, endC;
	static int map[][];
	static long answer;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					endR = i;
					endC = j;
				}
			}
		}
		
		bfs();
		System.out.println(answer);

	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			
			if(r == endR && c == endC) {
				answer++;
				continue;
			}
			
			int nr,nc;
			
			nr = r + map[r][c];
			nc = c + map[r][c];
			
			if(nr < N) {
				queue.add(new int[] {nr,c});
			}
			if(nc < N) {
				queue.add(new int[] {r,nc});
			}
		}
		
	}

}
```

## ⁉️ 알고리즘2 - DP

![Untitled](https://user-images.githubusercontent.com/48318620/112981885-bef85600-9196-11eb-8eab-ab1947bac694.png)

## 📜 코드

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1890_점프_DP {
	
	static int N, endR, endC;
	static int map[][];
	static long D[][];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		D = new long[N][N];
		
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					endR = i;
					endC = j;
				}
			}
		}
		D[0][0] = 1;
		
		for (int i =0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = map[i][j];
				if(i == endR && j == endC) continue;
				if(j+k < N) { // 오른쪽 경로
					D[i][j+k] += D[i][j];
				}
				if(i+k < N) { // 아래쪽 경로
					D[i+k][j] += D[i][j];
				}
			}
		}
		
		System.out.println((D[endR][endC]));
		
		

	}

}
```