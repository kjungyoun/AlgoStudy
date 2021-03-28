package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1219길찾기 {
	static int tc,n;
	static int[][] map;
	static boolean[] visit;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			tc = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			flag = false;
			map = new int[100][100];
			visit = new boolean[100];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			System.out.printf("#%d ", test_case);
			dfs(0);
			if(!flag)
				System.out.println(0);
		}
	}

	static void dfs(int start) {
		visit[start]=true;
		if(flag) 
			return;
		if(start == 99) {
			flag =true;
			System.out.println(1);
			return;
		}
		for(int i=0; i<100; i++) {
			if(map[start][i]==1 &&!visit[i]) {
				dfs(i);
			}
		}
	}
}
