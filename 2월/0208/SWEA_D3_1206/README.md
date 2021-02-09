# 👑02.08 ~ 02.09 SWEA_D3_1206_View
## 📝 문제 주소

[SW Expert Academy_D3_1206](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)

![Untitled](https://user-images.githubusercontent.com/48318620/107147387-28c36300-6991-11eb-8d03-b1047cc336a1.png)


![Untitled](https://user-images.githubusercontent.com/48318620/107147422-5c9e8880-6991-11eb-96da-28791203f197.png)

- 테스트케이스의 갯수는 10개로 고정!

### ✏️입력

- 입력은 input.txt로 업로드

### ✏️ 출력

#1 691
#2 9092
#3 8998
#4 9597
#5 8757
#6 10008
#7 10194
#8 10188
#9 9940
#10 8684

## 🖥️ 주요 알고리즘

- 우선 문제를 정확하게 이해 못했던 점이 이 문제를 더 어렵게 만든 것 같았다.
- 양쪽 거리가 2만 만족하면 무조건 조망권이 확보되는 것으로 생각했어야 하는데 나는 만약 2보다 큰 거리에서 현재 빌딩보다 높은 건물이 나온다면 조망권에 영향을 준다고 생각했다.
- 하지만 이 문제는 2보다 큰 거리에서 현재 건물보다 높은 건물이 나와도 현재 건물의 조망권에 전혀 영향을 주지 않는다.
- 따라서 이런 점을 파악만 한다면 쉽게 문제를 해결할 수 있다.
- 우선 입력을 저장할 1차원 배열 `arr` 를 선언한다.
- 그리고 for문을 반복하면서 현재 index 의 앞 뒤로 2칸을 비교하여 현재 index의 건물 높이보다 높은 건물이 있으면 `break` 한다.
- 그렇지 않으면 현재 index의 건물과의 높이를 빼서 나오는 가장 최소의 값이 현재 건물의 조망권이 된다.
- 현재 index의 건물이 for 문을 돌고 나와 조망권을 가질 수 있는 건물인지 아닌지 정보를 저장하는 `isView` 라는 boolean 타입의 변수를 선언하여 저장한다.

### 📜 내 코드

```java
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
```

> 문제 해결 능력이 어서 빨리 커졌으면 좋겠다.