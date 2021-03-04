package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1244_최대상금 {
	static int N, num[], rem, remidx;
	static String n;

	public static int max(int idx) {
		int m = idx;
		for (int i = idx + 1; i < num.length; i++) {
			if (num[i] >= num[m]) {
				m = i;
			}
		}
		return m;
	}

	public static boolean isE() {
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1])
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int s,tmp,tm;
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			n = str[0];
			num = new int[n.length()];
			N = Integer.parseInt(str[1]);
			for (int i = 0; i < n.length(); i++) {
				num[i] = n.charAt(i) - 48;
			}
			rem = remidx = -1;
			for (int i = 0; i < n.length(); i++) {
				if (N == 0)
					break;
				s = max(i);
				if (s == i)
					continue;
				tmp = num[s];
				num[s] = num[i];
				num[i] = tmp;
				N--;
				if (rem == tmp) {
					if (num[s] < num[remidx]) {
						tm = num[remidx];
						num[remidx] = num[s];
						num[s] = tm;
					}
				}
				remidx = s;
				rem = tmp;
			}
			if (N > 0) {
				if (!isE() && N % 2 != 0) {
					int t = num[num.length - 1];
					num[num.length - 1] = num[num.length - 2];
					num[num.length - 2] = t;
				}
			}
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < num.length; i++) {
				sb.append(num[i]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
