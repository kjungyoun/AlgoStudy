# 💰02.04 체육복 (Programmers lv1)
![0204_Programmers_체육복](https://user-images.githubusercontent.com/48318620/106917362-89615e80-674b-11eb-87e8-013faae859a1.png)


- 학생이 가진 체육복 수를 저장하는 배열 하나만 만들면 구현할 수 있다.
- Default로 모든 학생이 체육복 1개씩 가지고 있다는 구현

    ⇒ `Arrays.fill(arr,1)` 을 이용

- 도단 당한 학생 인덱스의 인자 값을 하나 감소시켜 0으로 만듬
- 여분을 가진 학생 인덱스의 인자 값을 하나 증가시킴
- for문을 이용하여 배열의 범위를 벗어나지 않고 앞뒤로 2개를 가진 학생이 있는 지 확인
- 있으면 해당 학생의 체육복 수 1 감소 & 나의 체육복 수 1 증가

### 💬 Sudo code

![0204Programmers](https://user-images.githubusercontent.com/48318620/106917407-941bf380-674b-11eb-96b6-b9a20b2b0a01.jpg)


```java
import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n];
        Arrays.fill(stu,1);
        for(int i=0; i< lost.length;i++){
        stu[lost[i]-1]--;
        }
        for(int i=0; i<reserve.length;i++){
        stu[reserve[i]-1]++;
        }
        for(int i=0; i<n;i++){
            if(stu[i] == 0){
              if(i-1 > -1 && stu[i-1] ==2){
                stu[i-1]--;
                stu[i]++;
              }else if(i+1<n && stu[i+1] == 2){
                stu[i+1]--;
                stu[i]++;
            }
         }
        }
        for(int x : stu){
        if(x >= 1) answer++;
        }
        return answer;
    }
}
```