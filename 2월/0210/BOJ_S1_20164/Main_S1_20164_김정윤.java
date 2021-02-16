package com.ssafy.BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_S2_16935_김정윤 {
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		arr = new int[2];
		N.substring(0, 2);
	}
	
//	public static void cut(int num) {
//		while(num !=0) {
//			stack.push(num%10);
//			num /= 10;
//		}
//		int size = stack.size();
//		combination(0,0,size); // 조합 생성
//		while(!queue.isEmpty()) { // 조합의 갯수만큼
//			int p[] = queue.poll();
//			while(!stack.isEmpty()) {
//	
//			}
//		}
//	}
	
	public static void combination(int cnt, int start, int size) {
		if(cnt == 2) {
			queue.offer(Arrays.copyOf(arr, 2));
			// 여기다 재귀
			return;
		}
		for (int i = 1; i < size; i++) {
			arr[cnt] = i;
			combination(cnt+1,i+1,size);
		}
	}
}
