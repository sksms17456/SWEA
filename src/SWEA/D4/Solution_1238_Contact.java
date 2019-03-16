//비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때, 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수를 작성하시오.
// 
//[예시]
//
//아래는 비상연락망을 나타낸 그림이다.
// 
//
//
// 
//각 원은 개개인을 의미하며, 원 안의 숫자는 그사람의 번호를 나타내고 빨간원은 연락을 시작하는 당번을 의미한다.
//
//화살표는 연락이 가능한 방향을 의미한다.
//
//위의 예시에서는 7번과 1번은 서로 연락이 가능하다,
//
//하지만 2번과 7번의 경우 2번은 7번에게 연락할 수 있지만 7번은 2번에게 연락할 수 없다.
// 
//비상연락망이 가동되면 아래 그림과 같이 연락을 시작하는 당번인 2번은 연락 가능한 7번과 15번에 동시에 연락을 취한다 (다자 간 통화를 사용한다고 가정).
// 
//
// 
//그 다음 아래와 같이 7번은 1번에게, 15번은 4번에게 연락을 취한다 (이 과정은 동시에 일어난다고 가정한다).
// 
//
//
//그 다음 아래와 같이 1번은 8번과 17번에게 동시에 연락하며, 이와 동시에 4번은 10번에게 연락한다.
//
//7번과 2번의 경우는 이미 연락을 받은 상태이기 때문에 다시 연락하지 않는다.
// 
//
//
//위의 모습이 연락이 끝난 마지막 모습이 되며, 마지막에 동시에 연락 받은 사람은 8번, 10번, 17번의 세 명이다.
//
//이 중에서 가장 숫자가 큰 사람은 17번이므로 17을 반환하면 된다.
// 
//※ 3, 6, 11, 22번은 시간이 지나도 연락을 받지 못한다.
// 
//[제약 사항]
//
//연락 인원은 최대 100명이며, 부여될 수 있는 번호는 1이상, 100이하이다.
//
//단, 예시에서 5번이 존재하지 않듯이 중간 중간에 비어있는 번호가 있을 수 있다.
//
//한 명의 사람이 다수의 사람에게 연락이 가능한 경우 항상 다자 간 통화를 통해 동시에 전달한다.
//
//연락이 퍼지는 속도는 항상 일정하다 (전화를 받은 사람이 다음사람에게 전화를 거는 속도는 동일).
//
//비상연락망 정보는 사전에 공유되며 한 번 연락을 받은 사람에게 다시 연락을 하는 일은 없다.
//
//예시에서의 3, 6, 11, 22번과 같이 연락을 받을 수 없는 사람도 존재할 수 있다.
// 
//[입력]
//
//입력의 첫 번째 줄에는 입력 받는 데이터의 길이와 시작점이 주어진다.
//
//그 다음 줄에 입력받는 데이터는 {from, to, from, to, …} 의 순서로 해석되며 예시의 경우는 {2, 7, 11, 6, 6, 2, 2, 15, 15, 4, 4, 2, 4, 10, 7, 1, 1, 7, 1, 8, 1, 17, 3, 22}와 같다.
//
//그런데 순서에는 상관이 없으므로 다음과 같이 주어진 인풋도 동일한 비상연락망을 나타낸다 (같은 비상연락망을 표현하는 다양한 인풋이 존재 가능하다).
//
//{1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 4, 2}
//
//다음과 같이 동일한 {from, to}쌍이 여러 번 반복되는 경우도 있으며, 한 번 기록된 경우와 여러 번 기록된 경우의 차이는 없다.
//
//{1, 17, 1, 17, 1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 11, 6, 4, 2}
// 
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int N, start, max, size, n, s;
	static ArrayList<ArrayList<Integer>> list;
	static int[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_1238_Contact.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			visit = new int[101];
			list = new ArrayList<>();
			for(int i=0; i<101; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N>>1; i++) {
				s = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				if(!list.get(s).contains(n))
					list.get(s).add(n);
			}
			
			LinkedList<Integer> q = new LinkedList<>();
			visit[start] = 1;
			q.offer(start);
			while(!q.isEmpty()) {
				size = q.size();
				for(int i=0; i<size; i++) {
					int temp = q.poll();
					for(int j=0; j<list.get(temp).size(); j++) {
						n = list.get(temp).get(j);
						if(visit[n]==0) {
							visit[n] = 1;
							q.offer(n);
						}
					}
				}	
				if(!q.isEmpty()) {
					max=0;
					for(int i=0; i<q.size(); i++) {
						max = Math.max(max, q.get(i));
					}
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
