- 각 자리 수가 다른지 여부를 or 연산자로 구한다.
- 반복문
  1. 수를 2로 나누고 나머지연산자를 통해 2진수의 각 자리 수를 구한다.
  2. 리턴 배열에 삽입할 문자열을 생성한다. 문자열의 앞에서 수를 삽입해서 처음에 구한 자리수가 문자열의 마지막에 올 수 있도록 한다.

```java
public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++){
                if ((arr1[i]%2 | arr2[i]%2) == 0)
                    sb.insert(0, ' ');
                else
                    sb.insert(0, '#');
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            ans[i] = sb.toString();
            sb.delete(0,sb.length());
        }
        return ans;
    }
  ```
