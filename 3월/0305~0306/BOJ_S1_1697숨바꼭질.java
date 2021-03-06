package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697숨바꼭질 {
	static int n, k;
	static int[] visit = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if(n==k)
			System.out.println(0);
		else
			bfs(n);
	}

	static public void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visit[a]=1;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0; i<3; i++) {
				int next;
				if(i==0) 
					next=temp+1;
				else if(i==1)
					next=temp-1;
				else
					next=temp*2;
				if(next==k) {
					System.out.println(visit[temp]);
					return;
				}
				
				if(next>=0&&next<visit.length&&visit[next]==0) {
					q.add(next);
					visit[next]=visit[temp]+1;
				}
			}
		}
	}
}


/**
 * S1 
 * → 수빈이가 1초 후에 갈 수 있는 모든 곳
 * → 이미 지나간 곳이면 X return
 */
//public class Main1697숨바꼭질 {
//	static int n, k, count = 100001;
//	static int[] visit = new int[100001];
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		n = Integer.parseInt(st.nextToken());
//		k = Integer.parseInt(st.nextToken());
//
//		catchS(n, 0);
//		System.out.println(count);
//	}
//
//	static public void catchS(int a, int c) {
//		if (a == k) {
//			for(int i=0; i<17; i++) {
//				System.out.print(visit[i]);
//			}System.out.println();
//			count =Math.min(count, c);
//			return;
//		} else if (a < 0 || a > 100000||count <= c || visit[a] == 1) {
//			return;
//		}
//
//		visit[a] = 1;
//		catchS(a + 1, c + 1);
//		catchS(a - 1, c + 1);
//		catchS(a * 2, c + 1);
//		visit[a] = 0;
//	}
//}