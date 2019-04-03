package SWEA.D4;

import java.io.*;
import java.util.Arrays;

public class Solution_4672_수진이의팰린드롬 {
	static int T, ans, len;
	static int[] value = {0,1,3,6,10,15,21,28,36,45,55};
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_4672_수진이의팰린드롬.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			input = br.readLine().toCharArray();
			Arrays.sort(input);
			int cnt=1;
			for(int i=1; i<input.length; i++) {
				if(input[i]==input[i-1]) {
					cnt++;
				}else {
					ans+=value[cnt];
					cnt=1;
				}
			}
			ans+=value[cnt];
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
