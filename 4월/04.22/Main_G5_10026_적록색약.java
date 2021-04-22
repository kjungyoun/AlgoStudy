package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_10026_적록색약 {
	
	static int N;
	static char[][] map, rgMap;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new char[N][N];
		rgMap = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				char input = line.charAt(j);
				map[i][j] = input;
				rgMap[i][j] = input == 'G' ? 'R' : input;
			}
		}
		
		
		
		
		System.out.println(bfs(map)+" "+bfs(rgMap));
	}
	
	
	private static int bfs(char[][] map) {
		Queue<int[]>queue = new LinkedList<int[]>();
		boolean visited[][] = new boolean[N][N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					queue.add(new int[] {i,j});
					visited[i][j] = true;
					char color = map[i][j];
					
					while(!queue.isEmpty()) {
						int temp[] = queue.poll();
						int r = temp[0];
						int c= temp[1];
						
						int nr,nc;
						for (int k = 0; k < 4; k++) {
							nr = r + dr[k];
							nc = c + dc[k];
							
							if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc] && map[nr][nc] == color) {
								queue.add(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
