package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_1467_날짜계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// E,S,M 입력
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int k = 0;
		int year = 0;
		while(true) {
			year = 15 * k + E;
			if(year%28 == S%28 && year%19 == M%19 ) {
				System.out.println(year);
				return;
			}
			k++;
		}

	}

}
