//N명의 사람들이 어떤 프로그래밍 대회에 참가했다.
//
//대회에는 M개의 문제가 나왔다.
//
//동철이는 이 프로그래밍 대회가 열렸다는 소식을 접했고,
//
//간단한 웹 서핑으로 각 사람들이 문제를 풀었는지 아닌지를 나타내는 NⅹM 개의 값 ai,j를 구할 수 있었다.
//
//사람에 1에서 N까지의 번호를 붙이고, 문제에도 1에서 M까지의 번호를 붙일 때,
//
//ai,j 는 대회가 끝나고 i번 사람이 j번 문제를 풀었다면 1, 풀지 못했다면 0을 가지는 값이다.
//
//동철이는 이 대회에는 나가지 못했지만, 다른 프로그래밍 대회에 나갈 계획이고 목표는 우승이다.
//
//그러므로 지금 열린 이 대회에서 1등을 한 사람들을 찾아 라이벌로 삼기로 했다.
//
//이 대회에서 모든 문제의 점수는 같고 프로그램을 제출한 시간은 따지지 않는다.
//
//그러므로, 푼 문제 수가 많은 사람이 더 높은 등수를 가지고, 푼 문제 수가 같은 사람은 같은 등수를 가진다.
//
//이 대회의 결과를 받아 1등을 한 사람이 몇 명이고 몇 문제를 풀었는지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 정수 N, M (1 ≤ N, M ≤ 20) 이 공백 하나로 구분되어 주어진다.
//
//다음 N개의 줄의 i번째 줄에는 M개의 정수 ai,1, ai,2, …, ai,m (0 ≤ ai,j ≤ 1) 이 공백 하나로 구분되어 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 대회에서 1등한 사람의 수와 1등이 푼 문제의 수를 공백 하나로 구분하여 출력한다.
package Battle;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_52_1_동철이의프로그래밍대회 {
	static int T, N, M, maxcnt, cnt;
	static int[] list;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_52_1_동철이의프로그래밍대회.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new int[N];
			
			maxcnt=0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					if(st.nextToken().equals("1")) {
						list[i]++;
					}
				}
				maxcnt = Math.max(maxcnt, list[i]);
			}
			
			cnt=0;
			for(int i:list) {
				if(i==maxcnt)
					cnt++;
			}
			System.out.println("#"+t+" "+cnt+" "+maxcnt);
		}
	}
}

