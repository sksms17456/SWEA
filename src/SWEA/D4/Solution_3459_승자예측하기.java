//
//Alice와 Bob은 게임을 하기로 했다.
//
//게임의 방법은 먼저 두 사람이 양의 정수 N을 정하고, 1로 초기화된 x를 가지고 있다.
//
//게임은 Alice가 먼저 시작하며 서로 번갈아 가면서 자신의 차례에 아래의 작업을 한번씩 한다.
//
//x를 2x 또는 2x+1로 대체한다.
//
//x가 N보다 커졌을 때(초과) 그 작업을 한 사람이 패배한다.
//
//예를 들어 N = 1일 때, Alice 는 2x, 2x+1 둘 중에 어느 것을 선택해도 1을 초과하게 되기 때문에 N = 1일 때는 Bob의 승리이다.
//
//N = 5일 때, Alice가 2x+1을 선택하여 x = 3이 되면 Bob은 어느 것을 선택해도 5를 초과하기 때문에 N = 5일 때는 Alice의 승리이다.
//
//N이 주어질 때, 두 사람이 최선을 다해 게임을 한다면 어떤 사람이 이기게 되는지 출력하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 하나의 자연수 N(1 ≤ N ≤ 1018)이 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 게임의 승자를 출력한다.
package SWEA.D4;

import java.io.*;

public class Solution_3459_승자예측하기 {
	static int T;
	static long N, val, n;
	static boolean isWin;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3459_승자예측하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			val=1;
			n=4;
			N = Long.parseLong(br.readLine());
			if(N==1) {
				sb.append("#"+t+" Bob\n");
				continue;
			}else {
				while(true) {
					val+=n;
					if(N<=val) {
						sb.append("#"+t+" Alice\n");
						break;
					}
					val+=n;
					if(N<=val) {
						sb.append("#"+t+" Bob\n");
						break;
					}
					n<<=2;
				}
			}
		}
		System.out.println(sb);
	}
}
