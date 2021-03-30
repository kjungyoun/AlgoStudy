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
