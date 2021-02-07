package Programmers;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = "";
            for(int j=n-1; j>=0; j--){
              answer[i] += (((arr1[i] & 1<<j) == 0) && (arr2[i] & 1<<j) == 0) ? " " : "#" ; 
            }
        }
      
        return answer;
    }
}