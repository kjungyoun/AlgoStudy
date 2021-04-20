package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_11000_강의실배정 {
	
	static class Subject implements Comparable<Subject>{
		int startT,endT;

		public Subject(int startT, int endT) {
			super();
			this.startT = startT;
			this.endT = endT;
		}

		@Override
		public int compareTo(Subject o) {
			return this.endT - o.endT;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		List<Subject> list = new LinkedList<Subject>();
		
		Collections.sort(list);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Subject(start, end));
		}
		
		int size = list.size();
		int cnt = 1;
		
		top: for (int i = 1; i < size; i++) {
			int start = list.get(i).startT;
			for (int j = 0; j < i; j++) {
				int end = list.get(j).endT;
				if(end <= start) {
					list.remove(j);
					continue top;
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
		

	}

}
