package com.ssafy.homework;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D3_1206_View {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			int T = sc.nextInt();
			int [] home = new int[T];
			int sum = 0;
			for(int j=0; j<home.length; j++) {
				home[j] = sc.nextInt();
			}
			for(int j=2; j<home.length-2; j++) {
				int min = 100;
				int [] side = new int [4];
				side[0] = home[j]-home[j-2];
				side[1] = home[j]-home[j-1];
				side[2] = home[j]-home[j+1];
				side[3] = home[j]-home[j+2];
				if(side[0]<0||side[1]<0||side[2]<0||side[3]<0) {
					continue;
				}else {
					Arrays.sort(side);
					sum += side[0];
				}	
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}
