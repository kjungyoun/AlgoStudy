# 👑02.10 ~ 02.14 BOJ_S1_20164

## 📜 알고리즘 분류

- 그래프 이론
- 그래프 탐색
- BruteForce Search
- 정렬
- 깊이 우선 탐색 (DFS)
- 백트래킹

## 📝 문제 주소
[19621번: 회의실 배정 2 문제 링크](https://www.acmicpc.net/problem/19621)

## 💬 입력

- 회의의 수 : N
- 회의 시작시간, 끝나는 시간, 회의 인원

## 💬 출력

- 회의를 진행할 수 있는 최대 인원

## ⁉️ 알고리즘 1

- 회의는 동시에 진행 불가
- 회의 진행 시간은 30으로 고정
- 회의 K는 이전 회의와 이후 회의 시간만 겹치고 나머지 회의랑은 겹치지 않음
- 입력을 받아 객체 배열에 저장
- 인원 수 별로 내림차순 정렬 : comparable
- 인원이 많은 회의 우선으로 집어넣음 : ArrayList에 넣기

    → 가장 첫 회의는 무조건 삽입

    → 집어 넣기 전 다른 회의랑 겹치는 지 확인

    → for 문으로 ArrayList의 사이즈 만큼 루프 돌면서 각 인덱스 요소의 시작시간과 종료시간 사이에 있으면 pass 

    → 만약 그렇지 않으면 add

### 🖍 첫번째 시행착오 - 틀린 코드

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_19621 {
	static int answer;
	
	static class Meeting implements Comparable<Meeting>{
		int stime,etime,num;

		public Meeting(int stime, int etime, int num) {
			super();
			this.stime = stime;
			this.etime = etime;
			this.num = num;
		}

		@Override
		public int compareTo(Meeting o) {
			return o.num - this.num;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		Meeting[] arr = new Meeting[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
		}
		
		schedule(arr);
		System.out.println(answer);
		
	}
	
	public static void schedule(Meeting[] arr) {
		Arrays.sort(arr);
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		list.add(arr[0]);
		answer += arr[0].num;
		
		for (int i = 0; i < arr.length; i++) {
			boolean isOk = true;
			for (int j = 0,size = list.size(); j < size; j++) {
				Meeting m = list.get(j);
				if((arr[i].stime >= m.stime && arr[i].stime <= m.etime) || (arr[i].etime >= m.stime && arr[i].etime <= m.etime)) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				list.add(arr[i]);
				answer += arr[i].num;
			}
		}
	}
}
```

## ⁉️ 알고리즘 2

- 회의 K는 이전 회의와 이후 회의 시간만 겹치고 나머지 회의랑은 겹치지 않음 을 이용하자!!

### 🖍 두번째 시행착오 - 틀린 코드

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_19621 {
	static int answer,N;
	
	static class Meeting{
		int stime,etime,num;

		public Meeting(int stime, int etime, int num) {
			super();
			this.stime = stime;
			this.etime = etime;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		Meeting[] arr = new Meeting[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
		}
		
		schedule(arr);
		System.out.println(answer);
		
	}
	
	public static void schedule(Meeting[] arr) {
		if(N>1 && arr[0].num > arr[1].num) {
			answer += arr[0].num;
			for (int i = 2; i < N; i+=2) {
				if(i == N-1 || arr[i].num > arr[i+1].num) answer += arr[i].num;
				else {
					answer += arr[i+1].num;
					i++;
				}
			}
			
		}else if(N>1 && arr[0].num < arr[1].num){
			answer += arr[1].num;
			for (int i = 3; i < N; i+=2) {
				if(arr[i].num > arr[i+1].num) answer += arr[i].num;
				else {
					answer += arr[i+1].num;
					i++;
				}
			}
		}else if(N==1) answer += arr[0].num;
	}
}
```

## ⁉️ 알고리즘 3

- 회의 K는 이전 회의와 이후 회의 시간만 겹치고 나머지 회의랑은 겹치지 않음을 이용
- DFS 와 완전탐색을 이용하자.
- 재귀로 풀자!!
- 0번째와 1번째 둘 다 해주어야 모든 경우의 수를 check 할 수 있다.

### 📜 코드 - 성공

```java
package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_19621 {
	
	static class Meeting{
		int stime,etime,num;

		public Meeting(int stime, int etime, int num) {
			super();
			this.stime = stime;
			this.etime = etime;
			this.num = num;
		}
		
	}
	
	static int answer,N;
	static Meeting[]arr;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		arr = new Meeting[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
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
		sum += arr[cnt].num;
		schedule(cnt+2,sum);
		schedule(cnt+3,sum);
	}
}
```

## ⭐️ 최적화

- 입력은 어차피 시간 순서대로 정렬되어 들어오기 때문에 입력으로 들어온 시작시간과 끝 시간은 이용할 필요 없다.

    → 입력중에 시간은 버리고 사람 수만 입력받는다.

- 따라서 선택한 회의 바로 이전과 바로 이후 회의는 시간이 겹친다는 점을 이용해 알고리즘을 짠다.
- i 번째의 회의를 선택하면 i+2 번째 회의를 선택한 경우와 i+3번째 회의를 선택한 경우로 나눈다.

    → i+2보다 i+3의 회의 참여 인원이 더 많을 수 있기 때문

- 회의 인원을 sum에 저장하고 메서드의 매개변수로 넘겨준다.
- answer에 최종 sum을 저장하는데 `Math.max()` 로 최대 값을 유지하도록 한다.

### 📜 코드 - 최적화

```java
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
```