//새롭게 계획된 어느 신도시에 N채의 집이 일렬로 새롭게 지어졌다.
//
//각 집에는 1에서 N까지 번호가 붙어 있으며, i번 집은 도시의 가장 왼쪽을 기준으로 만큼 떨어져 있다.
//
//이 도시에는 아직 전기가 연결되어 있지 않다.
//
//그래서 정부는 이 도시에 K개의 발전소를 세워 모든 N채의 집에 전기가 통하도록 하고 싶다.
//
//발전소를 K곳 설치하는 것은 이미 결정된 일이기 때문에,
//
//정부는 전선의 길이를 최소로 하여 발전소 및 전선을 설치하고 싶어한다.
//
//설치되는 발전소가 공급하는 전기 용량은 충분히 크기 때문에 얼마든지 많은 집에 전기를 공급해줄 수 있다.
//
//집의 위치와 설치할 발전소의 수가 주어질 때,
//
//모든 집에 전기를 공급하기 위해 설치해야 하는 전선 길이의 최솟값을 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 정수 이 공백으로 구분되어 주어진다.
//
//두 번째 줄에는 각 집의 위치를 나타내는
//
//N개의 정수 가 공백 하나로 구분되어 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//설치해야 하는 전선 길이의 최솟값을 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;
public class Solution_6855_신도시전기연결하기 {
	static int T, N, K;
	static int[] house;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_6855_신도시전기연결하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			if(N<=K) {
				br.readLine();
				sb.append("#"+t+" "+0+"\n");
				continue;
			}
			house = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				house[i] = Integer.parseInt(st.nextToken())-house[0]; 
			}
			house[0] = 0;
		}
		System.out.println(sb);
	}
}
