//성수는 이제 프로그래밍을 시작하기로 마음 먹은 초보다.
//
//그렇기에 프로그래밍 강좌를 통해 자신의 프로그래밍 실력을 끌어 올리려고 한다.
//
//성수의 실력이 A라고 할 때, 수준이 M인 강좌를 시청하고 나면 성수의 실력은 (A+M)/2가 된다.
//
//즉, 성수는 자신이 보는 강좌가 좋은 지 아닌지 판단하지 않고 그대로 강좌를 받아들이기 때문에,
//
//실력보다 낮은 수준의 강좌를 보면 실력이 낮아질 수 있다.
//
//현재 성수는 아직 아무런 실력이 없다. 즉 실력이 0이다.
//
//성수는 볼 수 있는 강좌 총 N개 찾았고 시간 문제상 이 중에서 K개를 적절한 순서로 선택해 한 번씩 시청하려고 한다.
//
//성수가 같은 강좌를 두 번 이상 보는 일은 없다고 할 때, 성수가 가질 수 있는 실력의 수치는 최대 몇인지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 정수 N, K ( 1 ≤ K ≤ N ≤ 200 ) 이 주어진다.
//
//두 번째 줄에는 N개의 정수 M1, … MN ( 1 ≤ Mi ≤ 10000 ) 이 공백으로 구분되어 주어진다.
//
//각 정수는 강좌의 수준을 나타낸다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//성수가 얻을 수 있는 실력 수치의 최댓값을 출력한다.
//
//정답과의 절대오차 혹은 상대 오차가 10-6이하이면 정답으로 인정된다.


package SWEA.D4;

import java.io.*;
import java.util.Arrays;

public class Solution_6719_성수의프로그래밍강좌시청 {
	static int T, N, K;
	static double answer, max;
	static double[] arr;
	static String[] line;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_6719_성수의프로그래밍강좌시청.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			answer = 0;
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			arr = new double[N];
			
			line = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(arr);
			
			for(int i=N-K; i<N; i++) {
				answer = (answer+arr[i])/2;
			}
			sb.append("#"+t+" "+String.format("%.6f", answer)+"\n");
		}
		System.out.println(sb);
	}
}
