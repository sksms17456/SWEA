package SWEA.D2;

import java.io.*;

public class Solution_7287_로마숫자만들기 {
	static int T, N, cnt, sum;
	static int[] arr;
	static int[] roma = { 1, 5, 10, 50 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			arr = new int[1001];
			cnt = 0;
			N = Integer.parseInt(br.readLine());

			comb(0, 0, 0);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0)
					cnt++;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	private static void comb(int cnt, int sum, int k) {
		if (cnt == N) {
			arr[sum]++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (roma[i] >= k) {
				comb(cnt + 1, sum + roma[i], roma[i]);
			}
		}
	}
}