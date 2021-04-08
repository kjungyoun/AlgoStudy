# 🌹 04.08 - 백준_G5_6198_옥상 정원 꾸미기

## 📝 문제 주소

[백준 6198번: 옥상 정원 꾸미기](https://www.acmicpc.net/problem/6198)

## 📝 알고리즘 분류

- 자료 구조
- 스택

## ⁉️ 알고리즘 풀이

- 해당 문제를 해결하기 위한 알고리즘 입력

![Untitled](https://user-images.githubusercontent.com/48318620/114058480-70516700-98ce-11eb-9974-e74d68f1cfe7.png)

## 📜 코드

```java
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
```