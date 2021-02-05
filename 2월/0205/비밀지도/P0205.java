package programmers;

public class P0205 {
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
}