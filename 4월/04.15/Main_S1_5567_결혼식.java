package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_5567_결혼식 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		LinkedList<Integer> [] adjList = new LinkedList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		
		boolean visited[] = new boolean[N+1];
		int answer = 0;
		
		
		int size = adjList[1].size();
		for (int i = 0; i < size; i++) {
			int person = adjList[1].get(i);
			if(!visited[person]) {
				visited[person] = true;
				answer++;
			}
			int length = adjList[person].size();
			for (int j = 0; j < length; j++) {
				int man = adjList[person].get(j);
				if(!visited[man] && man != 1) {
					visited[man] = true;
					answer++;
				}
			}
		}
		
		
		System.out.println(answer);
		
		
		

	}

}
