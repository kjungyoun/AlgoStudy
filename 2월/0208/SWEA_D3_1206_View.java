package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//View
public class SWEA_D3_1206_View {
	static LinkedList<Integer> list;
	static int n;

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			list = new LinkedList<>();
			n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++)
				list.add(Integer.parseInt(st.nextToken()));

			System.out.printf("#%d %d\n", test_case, view(0));
		}
	}

	static int view(int sum) {
		for (int i = 2; i < n - 2; i++) {
			int min = 255;
			//+-2(좌우로 두칸)의 건물중 현재 건물보다 큰 건물이 있으면 조망권 X
			if (list.get(i - 2) >= list.get(i) || list.get(i - 1) >= list.get(i) || list.get(i + 1) >= list.get(i)
					|| list.get(i + 2) >= list.get(i))
				continue;
			//그렇지 않으면 주변 건물들과의 차이를 구해야 하는데, 가장 적게 차이 나는 수만 더해준다.
			else {
				min = Math.min(min, list.get(i) - list.get(i - 2));
				min = Math.min(min, list.get(i) - list.get(i - 1));
				min = Math.min(min, list.get(i) - list.get(i + 1));
				min = Math.min(min, list.get(i) - list.get(i + 2));
			}
			sum += min;
		}
		return sum;
	}

}
