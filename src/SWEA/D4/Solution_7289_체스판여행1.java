//[문제]
//
//크기가 N×N인 체스판이 있고, 체스판의 각 칸에는 1부터 N^2까지의 정수가 한 번씩 적혀있다. 백준이는 이 체스판을 이용해서 재미있는 게임을 해보려고 한다.
//
//백준이가 가지고 있는 말은 나이트, 비숍, 룩이다. 가장 먼저 1이 적혀있는 칸에 말 하나를 놓는다. 그 다음, 1, 2, ..., N^2 순서로 이동시키려고 한다.
//
//먼저, 1에 나이트, 비숍, 룩 중 하나를 놓는다. 그 다음, 말을 이동시켜서 2가 적힌 칸으로 이동시킨다. 1에서 2로 이동시킬 때, 다른 수가 적힌 칸을 방문할 수도 있다. 그 다음에는 3이 적힌 칸으로 이동시키고, ..., N^2이 적힌 칸으로 이동시킨다. 같은 칸을 여러 번 방문하는 것도 가능하다.
//
//백준이가 1초 동안 할 수 있는 행동은 체스판 위에 놓인 말을 이동시키거나, 다른 말로 바꾸는 것이다.
//
//1에서 출발해서, 2, 3, ..., N^2-1을 방문하고, N^2까지 도착하는데 걸리는 시간의 최솟값을 구해보자.
//
//[입력]
//
//첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//
//각 테스트 케이스의 첫째 줄에 체스판의 크기 N(3 ≤ N ≤ 10)이 주어진다.
//
//둘째 줄부터 N개의 줄에 체스판에 적힌 수가 주어진다.
//
//[출력]
//
//각 테스트 케이스마다 문제에 주어진 대로 방문하는데 필요한 시간의 최솟값을 한 줄에 하나씩 출력한다. 
//
//[BOJ]
//
//이 문제는 https://www.acmicpc.net/problem/16959 와 같은 문제이다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_7289_체스판여행1 {
	static int T, N;
	static int[][] chess;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7289_체스판여행1.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1 ;t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					chess[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}
}
