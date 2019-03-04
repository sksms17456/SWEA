//주어진 두 수열의 최장 증가 부분 수열(Longest Increasing Subsequence)의 길이를 계산하는 프로그램을 작성하시오.
//
//수열 { A1, A2, ... , AN }의 최장 증가 부분 수열 B는 다음과 같이 정의된다.
//
//{ B1, B2, ... , BK }에서 0≤K≤N, B1 ≤ B2 ≤ ... ≤ BK이고,
//
//AB1 ≤ AB2 ≤ ... ≤ ABK인 최대 K로 구성된 수열이다.
//
//예를 들어, 수열이 { 1, 3, 2, 5, 4, 7 } 이라면, 최장 부분 증가 수열의 길이는 4가 된다.
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫째 줄에는 수열의 길이 N(1≤N≤1,000)이 주어진다. 
//
//둘째 줄에는 수열의 원소 N개가 공백을 사이에 두고 순서대로 주어진다.
//
//각 수열의 원소는 1 이상 231-1 이하의 자연수이다.
//
//[출력]
//
//각 테스트 케이스마다 ‘#T’(T는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 증가 부분 수열의 길이를 출력한다.
package SWEA.D3;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	static int N;
	static int max;
	static int[] numbers;
	static int[] choice;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_3307_최장증가부분수열.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			choice = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0);
			System.out.println("#"+t+" "+max);
		}
	}
	/**
	 * @param idx 숫자 index
	 * @param cnt 수열 개숫
	 * @param pre 이전 숫자
	 * */
	private static void dfs(int idx, int cnt, int pre) {
		if(idx==N) {
			max = Math.max(max, cnt);
			return;
		}
		if(numbers[idx]>pre) {
			dfs(idx+1,cnt+1,numbers[idx]);
		}
		dfs(idx+1,cnt,pre);
	}
}
