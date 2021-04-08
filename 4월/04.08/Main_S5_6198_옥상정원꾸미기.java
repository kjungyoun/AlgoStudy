package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S5_6198_옥상정원꾸미기 {

	static Stack<Integer> stack = new Stack<Integer>();
	static long answer;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(in.readLine());
			generate(now);
		}
		
		System.out.println(answer);

	}
	
	public static void generate(int now) {
		while(true) {
			if(stack.isEmpty()) {
				stack.push(now);
				return;
			}
			else {
				int prev = stack.peek();
				if(prev > now) {
					stack.push(now);
					answer += stack.size()-1;
					return;
				}else {
					stack.pop();
					continue;
				}
			}
		}
	}

}
