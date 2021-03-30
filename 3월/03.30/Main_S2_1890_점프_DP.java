package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1890_점프_DP {
	
	static int N;
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
				
			}
		}
		D[0][0] = 1;
		
		for (int i =0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = map[i][j];
				if(i == N-1 && j == N-1) continue;
				if(j+k < N) { // 오른쪽 경로
					D[i][j+k] += D[i][j];
				}
				if(i+k < N) { // 아래쪽 경로
					D[i+k][j] += D[i][j];
				}
			}
		}
		
		System.out.println((D[N-1][N-1]));
		
		

	}

}
