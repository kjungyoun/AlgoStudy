package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로_플로이드워샬 {

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
