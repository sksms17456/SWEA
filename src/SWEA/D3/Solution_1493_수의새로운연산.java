package SWEA.D3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_1493_수의새로운연산 {
	static class XY{
		int r;
		int c;
		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int T, n=1, A, B, rsum, csum;
	static int[][] arr = new int[300][300];
	static Map<Integer, XY> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_1493.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<300; i++) {
			n = n+i;
			arr[i][0] = n;
			map.put(n, new XY(i,0));
			for(int j=1; j<300; j++) {
				arr[i][j] = arr[i][j-1]+j+1+i;
				map.put(arr[i][j],new XY(i,j));
			}
		}
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			rsum = map.get(A).r+ map.get(B).r;
			csum = map.get(A).c+ map.get(B).c;
			sb.append("#"+t+" "+arr[rsum+1][csum+1]+"\n");
		}
		System.out.println(sb);
	}
}
