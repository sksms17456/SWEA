package SWEA.D3;

import java.io.*;
 
public class Solution {
	static int T, sum;
	static int[] Comb = new int[19];
	static int[] Arr = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
	static double A, B, a, b;
	static String[] line;
	
	public static void comb(int[] arr) {
		arr[0] = 1;
		for(int i=1; i<arr.length; i++) {
			arr[i] = arr[i-1]*(arr.length-i)/i;
		}
	}
	public static void solve() {
		a = 0;
		b = 0;
		for(int i=0; i<Arr.length; i++) {
			a += Comb[Arr[i]]*Math.pow(A, Arr[i])*Math.pow(1-A, 18-Arr[i]);
			b += Comb[Arr[i]]*Math.pow(B, Arr[i])*Math.pow(1-B, 18-Arr[i]);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Solution.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		comb(Comb);
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			line = br.readLine().split(" ");
			A = Double.parseDouble(line[0])/100;
			B = Double.parseDouble(line[1])/100;
			
			solve();
			
			sb.append("#"+t+" "+String.format("%6f", 1-a*b)+"\n");
		}
		System.out.println(sb);
	}
}
