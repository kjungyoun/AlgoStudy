# 🌹 04.29 - BOJ_G4_20040_사이클 게임

## 📝 문제 주소


[백준 G4 20040 사이클 게임](https://www.acmicpc.net/problem/20040)


## <img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/></a> 알고리즘 분류

- <img src="https://img.shields.io/badge/자료구조-339933?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>
- <img src="https://img.shields.io/badge/분리 집합-0085de?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>


## ⁉️ 알고리즘

- 서로소 집합 알고리즘을 적용하여 그래프를 구현한다.
- 각 정점을 연결하기 전에 각 정점의 최상위 root 번호를 조회하고 만약 서로 같은 root일 경우 Cycle을 형성한다는 이론을 이용했다.
- Rank 함수를 이용한 방법과 Path Compression을 이용한 방법이 시간차가 하나도 없음

![Untitled](https://user-images.githubusercontent.com/48318620/116544623-584b9100-a92a-11eb-9d26-b612854b98d6.png)


## 📜 코드1 - Path Compression만 진행

- 실행시간 548ms

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_20040_사이클게임 {
	
	private static int[] parent;
	private static int N,M;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		
		// 각각 root 초기화
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a,b)) { // 싸이클이 형성되었을 경우
				// 해당 순번 출력
				System.out.println(i+1);
				return;
			}
		}
		
		// 아직 싸이클이 만들어지지 않은 경우
		System.out.println(0);

	}
	
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static int findSet(int num) {
		if(num == parent[num]) return num;
		return parent[num] = findSet(parent[num]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB)
			return false;
		parent[rootB] = rootA;
		return true;
	}

}
```

## 📜 코드2 - Path Compression & Rank 적용

- 실행 시간 : 548ms

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_20040_사이클게임_rank {
	
	private static int[] parent;
	private static int N,M;
	private static int[] rank;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		rank = new int[N];
		
		// 각각 root 초기화
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a,b)) { // 싸이클이 형성되었을 경우
				// 해당 순번 출력
				System.out.println(i+1);
				return;
			}
		}
		
		// 아직 싸이클이 만들어지지 않은 경우
		System.out.println(0);

	}
	
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static int findSet(int num) {
		if(num == parent[num]) return num;
		return parent[num] = findSet(parent[num]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB)
			return false;
		if(rank[rootA] > rank[rootB]) {
		parent[rootB] = rootA;
		}else {
			parent[rootA] = rootB;
			if(rank[rootA] == rank[rootB])
				rank[rootB]++;
		}
		return true;
	}

}
```