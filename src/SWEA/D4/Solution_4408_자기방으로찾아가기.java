//고등학교 학생들이 학교에서 수련회를 갔다. 수련회에 간 학생들은 친구들과 음주가무를 즐기다가 밤 12시가 되자 조교들의 눈을 피해 자기방으로 돌아가려고 한다.
//
//제 시간에 자기방으로 돌아가지 못한 학생이 한 명이라도 발견되면 큰일나기 때문에 최단 시간에 모든 학생이 자신의 방으로 돌아가려고 한다.
//
//숙소는 긴 복도를 따라 총 400개의 방이 다음과 같이 배열되어 있다.
//
// 
//
//모든 학생들은 현재 위치에서 자신의 방으로 돌아가려고 하는데, 만약 두 학생이 자기방으로 돌아가면서 지나는 복도의 구간이 겹치면 두 학생은 동시에 돌아갈 수 없다.
//
//예를 들어 (방1 -> 4) 와 (방3 -> 6) 은 복도 구간이 겹치므로 한 사람은 기다렸다가 다음 차례에 이동해야 한다. 이동하는 데에는 거리에 관계없이 단위 시간이 걸린다고 하자.
//
//각 학생들의 현재 방 위치와 돌아가야 할 방의 위치의 목록이 주어질 때, 최소 몇 단위시간만에 모든 학생들이 이동할 수 있는지를 구하시오.
//
//
//[입력]
//입력은 T(≤10)개의 테스트 케이스로 되어 있다. 각 테스트 케이스의 첫 줄에는 돌아가야 할 학생들의 수 N이 주어진다.
//
//다음 N 줄에는 각 학생의 현재 방 번호(≤400)와 돌아가야 할 방의 번호(≤400)가 주어진다. 주어지는 2N개의 방 번호 중 중복되는 것은 없다.
//
//[출력]
//테스트 케이스 T에 대한 결과는 “#T ”을 찍고, 각 테스트 케이스마다 필요한 시간을 한 줄에 하나씩 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_4408_자기방으로찾아가기 {
	static int T, N, start, end, max;
	static int[] room;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_4408_자기방으로찾아가기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {			
			max=Integer.MIN_VALUE;
			room = new int[201];
			N = Integer.parseInt(br.readLine().trim());
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				start = (start+1)/2;
				end = (end+1)/2;
				if(start>end) {
					for(int i=end; i<=start; i++) {
						room[i]++;
					}
				}else {
					for(int i=start; i<=end; i++) {
						room[i]++;
					}
				}
			}
			for(int i=1; i<room.length; i++) {
				max = Math.max(max, room[i]);
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
		
	}
}
