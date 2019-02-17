//
//어느 날 현주는 제곱근 놀이를 만들기로 했는데, 룰은 다음과 같다.
//
//- 2이상의 어떤 정수 N이 있다.
//
//- N을 N+1로 바꿀 수 있다.
//
//- 이 정수일 때, N을 으로 바꿀 수 있다.
//
//
//게임의 목표는 N을 2로 만드는 것이다.
//
//을 조작해야 하는 횟수의 최솟값을 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(2 ≤ N ≤ 1012)이 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//N 을 2로 만들기 위해 N 을 조작해야 하는 횟수의 최솟값을 출력한다.
//


package SWEA.D5;

import java.io.*;

public class Solution_6782_현주가좋아하는제곱근놀이{
	static int T, cnt;
	static long N;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader("text_D5/Solution_6782_현주가좋아하는제곱근놀이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
	
		for(int t=1; t<=T; t++) {
			cnt = 0;
			N = Long.parseLong(br.readLine());
			
			while(true) {
				if(N==2)
					break;
				long sqrt = (long)Math.sqrt(N);
				if(Math.pow(sqrt, 2) == N) {
					N = sqrt;
					cnt++;
				}else {
					cnt += (long) Math.pow(sqrt+1, 2)-N;
					N = (long) Math.pow(sqrt+1, 2);
					
//					N = N+1;
//					cnt++;
				}
			}
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);	
	}
}
