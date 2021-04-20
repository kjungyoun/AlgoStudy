# 🌹 04.20 - 백준_G5_11000_강의실 배정


## 📝 문제 주소

 

[백준 11000번: 강의실 배정](https://www.acmicpc.net/problem/11000)


## <img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/></a> 알고리즘 분류

- <img src="https://img.shields.io/badge/자료구조-b366f6?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>
- <img src="https://img.shields.io/badge/그리디 알고리즘-fbb040?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>
- <img src="https://img.shields.io/badge/정렬-0085c0?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>
- <img src="https://img.shields.io/badge/PriorityQueue-7fadf2?style=flat-square&logo=simpleicons에서_아이콘이름&logoColor=white"/></a>

## ⁉️ 알고리즘 풀이

## ⁉️ 알고리즘

![Untitled](https://user-images.githubusercontent.com/48318620/115405934-a75a3d80-a229-11eb-8968-d52b254084a9.png)


## 📜 코드1 - 실패 (시간초과)

- 아래는 시간초과가 난 코드이다.
- list에 입력을 넣어 Collections.sort를 통해 정렬해주었고 2중 for문을 통해 비교를 해주었다.

```java
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
```

## 📜 코드2

```java
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
```
