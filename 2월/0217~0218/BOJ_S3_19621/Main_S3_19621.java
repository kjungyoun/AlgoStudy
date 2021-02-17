package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_19621 {
	
	static int answer,N;
	static int[]arr;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				st.nextToken();
			}
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		schedule(0,0);
		schedule(1,0);
		System.out.println(answer);
		
	}
	
	public static void schedule(int cnt, int sum) {
		if(cnt >= N) {
			answer = Math.max(answer, sum);
			return;
		}
		sum += arr[cnt];
		schedule(cnt+2,sum);
		schedule(cnt+3,sum);
	}
}
