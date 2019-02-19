//프로그래밍 대회에서는 각 문제에 대해 그 문제를 가장 빠르게 푼 사람의 이름과 그 때의 시간이 해설 등에서 종종 언급된다.
//
//자영이는 오랜만에 프로그래밍 대회에 나가기로 했고, 오늘은 예선이 열리는 날이다.
//
//예선에서 열심히 해봐야 돌아오는 것이 크지 않기 때문에,
//
//자영이는 이번 예선에서 최대한 퍼스트 솔브한 문제를 많이 만들기로 했다.
//
//예선이 시작되었고, 자영이는 순식간에 예선에 나온 N개 문제를 푸는 방법을 모두 파악했다.
//
//i번째 문제를 자영이가 해결하는 데에는 Si초가 걸리며,
//
//지금부터 Fi초가 있으면 다른 참가자가 퍼스트 솔브를 가져갈 수 있다.
//
//(F값들은 모두 예상이지만, 이 문제를 풀 때는 자영이가 미래를 보았다고 생각하자.)
//
//자영이는 제출하는 속도가 매우 빠르기 때문에,
//
//자영이가 i번째 문제를 ti의 시간에 풀었다면 ti≤Fi 일 때, 자영이가 i번째 문제를 퍼스트 솔브한다.
//
//자영이에게 여러 문제를 풀 때 생기는 딜레이 같은 것은 없다.
//
//자영이가 최대 몇 개의 문제를 퍼스트 솔브할 수 있는지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 문제의 수를 나타내는 하나의 정수 N (1 ≤ N ≤ 103) 이 주어진다.
//
//다음 N개의 줄의 i번째 줄에는 두 정수 Si, Fi (1 ≤ Si, Fi ≤ 106) 가 공백 하나로 구분되어 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 자영이가 퍼스트 솔브할 수 있는 문제 수의 최댓값을 출력한다.
package Battle;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_52_3_자영이의퍼스트솔브 {
	static class time implements Comparable<time>{
		private int st, ft;

		public time(int st, int ft) {
			super();
			this.st = st;
			this.ft = ft;
		}

		@Override
		public int compareTo(time o) {
			if(this.ft < o.ft)return -1;
			else if(this.ft > o.ft) return 1;
			else if(this.st < o.st)return -1;
			else if(this.st > o.st)return 1;
			else return 0;
		}

		@Override
		public String toString() {
			return "time [st=" + st + ", ft=" + ft + "]";
		}
		
	}
	static int T, N, a, b, cnt, now;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_52_3_자영이의퍼스트솔브.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			time[] Time = new time[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				Time[i] = new time(a,b);
			}	
			Arrays.sort(Time);
			
			now = 0;
			cnt = 0;
			for(int i=0; i<N; i++) {
				if(now+Time[i].st<=Time[i].ft) {
					now+=Time[i].st;
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
