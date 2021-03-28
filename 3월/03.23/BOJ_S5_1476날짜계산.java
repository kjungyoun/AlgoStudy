package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1476날짜계산 {
	static int x, y, z;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int x = 0;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());
		int i = 0;
		int e = 0, s = 0, m = 0;
		for (i = 0;; i++) {
			if ((x == e) && (y == s) && (z == m)) {
				System.out.println(i);
				break;
			}
			e = e + 1;
			s = s + 1;
			m = m + 1;
			if (e > 15)
				e = 1;
			if (s > 28)
				s = 1;
			if (m > 19)
				m = 1;
		}

	}

}
