package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
메모리 23,564 kb
실행시간 117 ms
코드길이 1,004
*/
public class SWEA_D3_1206_View_0208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, max,tmp,sum;
		int[] heigh;
		for (int tc = 1; tc <= 10; tc++) {
			T = Integer.parseInt(br.readLine());
			heigh = new int[T];
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < T; i++)
				heigh[i] = Integer.parseInt(st.nextToken());
			for (int i = 2; i < T-2; i++) {
				max = 0;
				for (int j = 1; j < 3; j++) {
					tmp = heigh[i-j]>heigh[i+j] ? heigh[i-j] : heigh[i+j];
					max = max > tmp ? max : tmp;
				}
				if(heigh[i] > max) sum+= heigh[i]-max;
			}
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
