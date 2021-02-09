package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int sum = 0; // 조망권을 확보한 세대 수의 합 저장
			int N = Integer.parseInt(in.readLine());
			int [] arr = new int[N];
			st = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < N-2; i++) {
				boolean isView = true;
				int min = Integer.MAX_VALUE;
				for (int j = 1; j < 3; j++) { // 현재 건물의 양 옆의 높이를 비교
					if(arr[i]<= arr[i-j] || arr[i]<=arr[i+j]) { // 한 건물이라도 현재보다 높으면 break
						isView = false;
						break;
					}else {
					min = Math.min(min,Math.min(arr[i]-arr[i-j], arr[i]- arr[i+j]));
					}
				}
				if(isView) sum += min;
			}
			System.out.println("#"+test_case+" "+sum);
		}

	}

}
