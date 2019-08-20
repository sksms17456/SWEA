//(x1, y1 )에서 (x2, y2)로 이동하려고 한다.
//
//(x, y)에서 한 번 이동하면 (x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)로 이동할 수 있다.
//
//이 중에서, (x + 1, y), (x - 1, y)로 이동하는 것은 가로 이동, (x, y + 1), (x , y - 1)로 이동하는 것은 세로 이동이라고 한다.
//
//정우는 그냥 (x1, y1)에서 (x2, y2)로 이동하는 것은 재미가 없다고 생각한다.
//
//그래서 이전 이동이 가로 이동이었다면, 이번에는 세로 이동으로 이동하고, 이전 이동이 세로 이동이었다면, 이번에는 가로 이동으로 이동하여 (x1, y1)에서 (x2, y2)로 이동하려고 한다.
//
//가장 첫 이동은 어떤 이동 이어도 상관 없다.
//
//이 때, 최소 몇 번의 이동을 해야 (x1, y1)에서 (x2, y2)로 이동할 수 있는지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 네 정수 x1, y1, x2, y2 (-100 ≤ x1, y1, x2, y2 ≤ 100)이 공백 하나로 구분되어 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//각 테스트 케이스마다 최소 몇 번의 이동을 해야 하는지 출력한다.
package Battle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_78_1_방향전환 {
	static int T, x1, x2, y1, y2, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_78_1_방향전환.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			ans=Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
