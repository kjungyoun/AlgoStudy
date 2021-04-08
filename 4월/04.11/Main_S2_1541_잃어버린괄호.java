package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S2_1541_잃어버린괄호 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		
		String[] list = input.split("-");
		
		int size = list.length;
		int result = 0;
		
		for (int i = 0; i < size; i++) {
			// 특수문자를 기준으로 나누기 위해서는 \\를 꼭 붙여야 함!
			String temp[] = list[i].split("\\+");
			int sum=0;
			for (String string : temp) {
				sum += Integer.parseInt(string);
			}
			if(i == 0) result = sum;
			else result -= sum;
		}
		System.out.println(result);
		
	}

}
