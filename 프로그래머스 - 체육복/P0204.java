package programmers;

public class P0204 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] cnt = new int[n+2];
        for (int i = 0; i < lost.length; i++)
			cnt[lost[i]]--;
        for (int i = 0; i < reserve.length; i++)
        	cnt[reserve[i]]++;
        for(int i = 1; i <= n; i++) {
        	if(cnt[i]==-1) {
        		if(cnt[i-1]==1) {
        			cnt[i-1]=0;
        			cnt[i]=0;
        		}else if(cnt[i+1]==1) {
        			cnt[i+1]=0;
        			cnt[i]=0;
        		}
        		else
                    answer--;
        	}
        }
		return answer;
    }
}
