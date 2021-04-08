# 🌹 04.11 - 백준_S2_1541_잃어버린 괄호

## 📝 문제 주소

[백준 1976번: 여행 가자](https://www.acmicpc.net/problem/1541)

## 📝 알고리즘 분류

- 수학
- 그리디 알고리즘
- 문자열
- 파싱

## ⁉️ 알고리즘 풀이

- 해당 문제를 해결하기 위한 알고리즘 입력
- split을 이용할 때 특수 문자를 인자로 넣을 경우 반드시 \\ 를 붙여주어야 한다!!

![스크린샷 2021-04-09 오전 12 55 20](https://user-images.githubusercontent.com/48318620/114058492-734c5780-98ce-11eb-8db5-60d2652c0b51.png)

## 📜 코드

```java
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
```