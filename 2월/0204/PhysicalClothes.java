package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class PhysicalClothes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []lost = {2,4}; // 문제에서 주어지는 입력 (도난 당한 학생)
		int[]reserve= {1,3,5}; // 문제에서 주어지는 입력 (여분을 가진 학생)
		int answer = 0;
		int []stu = new int[n];
		Arrays.fill(stu, 1);
		for (int i = 0; i < lost.length; i++) {
			stu[lost[i]-1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			stu[reserve[i]-1]++;
		}
		for (int i = 0; i < n; i++) {
			if(stu[i] == 0) {
				if(i-1>-1 && stu[i-1]==2) {
					stu[i-1]--;
					stu[i]++;
				}else if(i+1<n && stu[i+1]==2) {
					stu[i+1]--;
					stu[i]++;
				}
			}
		}
		for(int x : stu) {
			if(x>=1) answer++;
		}
		System.out.println(answer);
	}

}
