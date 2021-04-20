package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_11000_강의실배정2 {
	
	static class Subject implements Comparable<Subject>{
		int startT,endT;

		public Subject(int startT, int endT) {
			super();
			this.startT = startT;
			this.endT = endT;
		}

		@Override
		public int compareTo(Subject o) {
			if(this.startT == o.startT)
				return this.endT - o.endT;
			return this.startT - o.startT;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Subject> queue = new PriorityQueue<Subject>();
		PriorityQueue<Subject> list = new PriorityQueue<Subject>(new Comparator<Subject>() {

			@Override
			public int compare(Subject o1, Subject o2) {
				if(o1.endT == o2.endT)
					return o1.startT - o2.startT;
				return o1.endT-o2.endT;
			}
			
		});
	
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			queue.add(new Subject(start, end));
		}
		
		int cnt = 1;
		list.add(queue.poll());
		int size = queue.size();
		
		for(int i=0; i<size; i++) {
			Subject tmp = queue.poll();
			int start = tmp.startT;
			int end = list.peek().endT;
			
			if(end> start) {
				cnt++;
			}
			else {
				list.poll();
			}
			list.add(tmp);
		}
		
		
		System.out.println(cnt);
		

	}

}
