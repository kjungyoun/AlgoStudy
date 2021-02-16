package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2468 {
	static int N, height, count, answer;
	static int[][] map;
	static boolean[][] isChecked;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		height = Integer.MIN_VALUE;
		answer = Integer.MIN_VALUE;
		map = new int[N][N];

		for (int i = 0; i < N; i++) { // 입력을 받음
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				map[i][j] = h;
				height = Math.max(height, h); // 최대 높이를 저장
			}
		}
		int h = 0;
		while (h < height) {
			isChecked = new boolean[N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !isChecked[i][j]) {
						count++;
						dfs(i, j, h);
					}
				}
			}
			answer = Math.max(answer, count);
			h++;
		}

		System.out.println(answer);

	}

	public static void dfs(int r, int c, int height) {
		// 안전 지역일 때
		isChecked[r][c] = true;
		int nr, nc;
		for (int k = 0; k < 4; k++) {
			nr = r + dr[k];
			nc = c + dc[k];
			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] > height && !isChecked[nr][nc]) {
				dfs(nr, nc, height);
			}
		}
	}

}
