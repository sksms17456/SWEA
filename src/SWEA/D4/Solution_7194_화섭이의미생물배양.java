//몇 일 후 집에 돌아 갈 수 있을지 알고 싶은 화섭이화섭이는 미생물을 배양하려고 한다.
//
//화섭이에게 초기에 주어진 미생물은 s마리이다.
//
//교수님이 시켰기 때문에 어쩔 수 없이 화섭이는 이 미생물의 수를 t마리로 만들어야 한다.
//
//화섭이는 하루에 한 번 다음 2가지 작업 중 하나의 작업을 할 수 있다.
//
// 1. 미생물들에게 먹이를 주어 그 수를 a만큼 늘린다.
//
// 2. 미생물들에게 배양액을 주어 그 수를 b배만큼 늘린다.
//
//교수님이 화섭이에게 정확히 t마리로 만들기 전에는 집에 가지 말라고 했다.
//
//그래서 화섭이는 미생물 s마리를 최대한 빨리 t마리로 만들어야 한다.
//
//몇 일 후 집에 돌아 갈 수 있을지 알고 싶은 화섭이를 도와주는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 네 개의 정수 s, t, a, b (1 ≤ s, t, a, b ≤ 109) 이 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//화섭이에게 s마리를 t마리로 만들기 위해 필요한 최소한의 일 수를 출력한다.
//
//미생물의 수를 t마리로 만드는 것이 불가능하면 -1을 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7194_화섭이의미생물배양 {
	static int s, t, a, b, T;
	static LinkedList<int[]> queue;
	static boolean isOver;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7194_화섭이의미생물배양.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(s==t) {
				sb.append("#").append(tc).append(" 0\n");
				continue;
			}
			
			queue.offer(new int[] {s+a, 1});
			queue.offer(new int[] {s*b, 1});
			
			top:
			while(true) {
				int size = queue.size();
				for(int i=0; i<size; i++) {
					isOver = false;
					int[] temp = queue.poll();
					if(temp[0]==t) {
						sb.append("#").append(tc).append(" ").append(temp[1]).append("\n");
						break top;
					}
					if(temp[0]<t) {
						isOver = true;
					}
					queue.offer(new int[] {temp[0]+a, temp[1]+1});
					queue.offer(new int[] {temp[0]*b, temp[1]+1});
				}
				if(!isOver) {
					sb.append("#").append(tc).append(" -1\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
