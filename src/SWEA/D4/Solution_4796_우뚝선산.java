//의석이는 동서 방향으로 늘어서 있는 산의 N개의 지점에 대한 높이를 측정했다.
//
//서쪽에서 i번째 지점을 i번 지점이라고 하고, 이 지점의 높이는 hi이다.
//
//특이하게도 두 지점이 같은 hi을 가지는 경우는 없었다.
//
//의석이의 친구 상원이가 의석이에게 “우뚝 선 산”이 몇 개인지 찾는 게임을 제안했다.
//
//어떤 두 지점 i,j(1≤i＜j≤N) 사이에 있는 모든 지점을 볼 때, 즉 구간 [i,j]에 대해 이들의 높이의 형태가 “우뚝 선 산”이라는 것을 다음과 같이 정의하기로 했다.
//
//
//    다음을 만족하는 k(i＜k＜j)가 존재해야 한다.
//
//    i≤l＜k인 모든 l에 대해 hl＜h(l+1)이 성립.
//
//    k≤l＜j인 모든 l에 대해 hl＞h(l+1)이 성립.
//
//
//이와 같은 정의에서 두 지점 i와 i+1사이는 우뚝 선 산이 될 수 없음에 주의해야 한다.
//
//자존심이 강한 의석이는 “이 정도는 내가 좀 하지.”라며 자신만만하게 대답했지만, 속으로는 식은땀을 흘리고 있다.
//
//의석이는 자존심을 지키기 위해 상원이 몰래 당신에게 도움을 요청했다.
//
//각 지점의 높이가 주어질 때, 우뚝 선 산이 될 수 있는 구간의 개수를 구하는 프로그램을 만들어 정답을 출력하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T(1≤T≤10)가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 자연수 N(3≤N≤50,000)이 주어진다.
//
//다음 줄에는 N개의 자연수 h1,…,hN (1≤hi≤109)이 순서대로 공백 하나로 구분되어 주어진다.
//
//모든 1≤i＜j≤N 에 대해 hi≠hj 이다.
//
//[출력]
//
//각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 우뚝 선 산이 될 수 있는 구간의 개수를 출력하라.
//
//[예제]
// 
//
//첫 번째 테스트 케이스는 [1, 3]구간이 유일한 우뚝 선 산이 될 수 있는 구간이다.  ()이기 때문이다.
//
//두 번째 테스트 케이스는 우뚝 선 산이 될 수 있는 구간이 존재하지 않기 때문에 답이 0이다.
//
//세 번째 테스트 케이스에서 우뚝 선 산이 될 수 있는 구간은 다음과 같다.
//
//[1, 4] : ()
// 
//
//[1, 5] :  ()
//
//[2, 4] : ()
//
//[2, 5] : ()
//
//[5, 8] : ()
//
//[6, 8] : ()
package SWEA.D4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_4796_우뚝선산 {
	static int T, N, ans;
	static int[] mountain;
	public static void main(String[] args) throws  Exception{
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			ans = 0;
			N = sc.nextInt();
			mountain = new int[N];
			for(int i=0; i<N; i++) {
				mountain[i] = sc.nextInt();
			}
			int udduk = 0;
			int start = 0;
			int end = 0;
			boolean isBreak = false;
			while(true) {
				for(int i=1; start+i<mountain.length; i++) {
					if(mountain[start+i-1]<mountain[start+i]) {
						continue;
					}else if(mountain[start+i-1]>mountain[start+i]) {
						udduk = start+i-1;
						break;
					}
				}
				for(int i=1; udduk+i<mountain.length; i++) {
					if(udduk+i==mountain.length-1) {
						isBreak = true;
					}
					if(mountain[udduk+i-1]>mountain[udduk+i]) {
						continue;
					}else if(mountain[udduk+i-1]<mountain[udduk+i]) {
						end = udduk+i-1;
						break;
					}
				}
				ans += Math.abs((end-udduk)*(udduk-start));
				start = end;
				if(isBreak) {
					break;
				}
				
			}	
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
