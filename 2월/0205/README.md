# 💰02.05 비밀지도 (Programmers lv1)
![0205_Programmers_비밀지도](https://user-images.githubusercontent.com/48318620/107143629-674d2380-6979-11eb-84b6-c4c6885bc6cc.png)
![0205_Programmers_비밀지도2](https://user-images.githubusercontent.com/48318620/107143635-72a04f00-6979-11eb-8bcf-b9cbc81f8e77.png)


- BitMask로 arr배열에 있는 정수들을 이진수로 바꾸고 각 자리가 1인지 0인지 비교
- arr1과 arr2의 각 자리가 둘 다 0이면 공백, 둘 중 하나라도 1이면 벽으로 표시
- 삼항 연산자를 이용하여 answer배열에 추가해줌
- BitMask로 i번째 숫자를 비교하기 위해서는 1<<i-1을 해주어야 함

### 💬 Sudo code - BitMask
```java
for(int j=n-1; j>=0; j--){
  arr1[i] & 1<<j; 
  }
```