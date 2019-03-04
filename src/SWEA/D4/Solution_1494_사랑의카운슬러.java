//오훈이에게는 지렁이 친구 N마리가 있다. 오훈이는 지렁이들을 위해 소개팅을 주선하고자 한다.
//
//주선 방법은 임의의 지렁이 두 마리를 매칭시킨 후 한 지렁이에게 다른 지렁이가 있는 곳으로 가도록 하는 것이다.
//
//이 때, 수학을 좋아하는 오훈이는 가능한 지렁이들이 움직인 벡터 합의 크기가 작기를 바란다.
//
//지렁이들은 2차원 평면 안에서 이동하는데, 점 A 위에 있는 지렁이가 점 B 위에 있는 지렁이에게 갔다면 그 벡터는 점 A에서 점 B를 가리키는 벡터가 된다.
//
//벡터 V=(x, y)의 크기는 아래와 같이 정의하자.
//
//│V│=│(x, y)│= x * x + y * y
//
//모든 지렁이들을 매칭시키고 소개팅을 주선하되, 각 지렁이들이 움직인 벡터를 합하여 그 크기가 최소가 되도록 하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 정수 N(2 ≤ N ≤ 20, N은 짝수) 가 주어진다.
//
//두 번째 줄 N개의 줄에는 지렁이들이 존재하는 점의 좌표가 주어지며, 모든 지렁이는 서로 다른 위치에 있다.
//
//모든 좌표값은 그 절대값이 100,000보다 작거나 같은 정수다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 지렁이의 움직인 벡터의 합의 크기의 최솟값을 출력하라.
//

package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러 {
	static class Worm{
		long r;
		long c;
		public Worm(long r, long c) {
			super();
			this.r = r;
			this.c = c;
		}		
	}
	static int T, N;
	static long min;
	static boolean[] visit;
	static Worm[] worm;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_1494_사랑의카운슬러.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			min = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N];
			worm = new Worm[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				worm[i] = new Worm(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
			}
			
			perm(0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void perm(int cnt, int idx) {
		if(cnt==N/2) {
			long x=0, y=0;
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					x+=worm[i].r;
					y+=worm[i].c;
				}else {
					x-=worm[i].r;
					y-=worm[i].c;
				}
			}
			min = Math.min(min, x*x+y*y);
			return;
		}
		for(int i=idx; i<N; i++) {
			visit[i] = true;
			perm(cnt+1, i+1);
			visit[i] = false;
		}
	}
}
