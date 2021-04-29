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
