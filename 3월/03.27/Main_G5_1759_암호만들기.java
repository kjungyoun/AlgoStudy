package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759_암호만들기 {
	
	static int L,C,flag;
	static String input[],pwd[];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new String[C];
		pwd = new String[L];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken();
		}
		
		String word = "aeiou";
		flag = 0;
		for (int i = 0,size = word.length(); i <size; i++) {
			flag = flag | 1<<(word.charAt(i)-'a'); // 모음을 저장할 flag 생성
		}
		
		Arrays.sort(input); // 입력 오름차순 정렬
		combination(0,0);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == L) {
			int count = 0; // 모음 갯수 저장
			for (int i = 0; i < L; i++) {
				if((flag & 1<<(pwd[i].charAt(0)-'a')) != 0) { // 사용한 모음 검사
					count++;
				}
			}
			if(count<1) return; // 모음 갯수 검사
			if(L-count<2) return; // 자음 갯수 검사
			for (String str : pwd) {
				System.out.print(str);
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < C; i++) {
			pwd[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
