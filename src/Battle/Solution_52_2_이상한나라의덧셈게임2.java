//앨리스와 토끼는 덧셈을 이용한 간단한 게임을 같이 하기로 했다.
//
//먼저 어떤 양의 정수를 하나 정해 그 수로 게임을 시작한다.
//
//둘은 서로의 차례에 인접한 두 자리를 선택하고, 이 두 자리를 선택된 두 숫자의 합으로 교체하여 상대에게 차례를 넘긴다.
//
//예를 들어, “1234”의 십의 자리와 백의 자리를 선택하면 다음 차례에는 수가 “154”가 된다.
//
//“5678”의 십의 자리와 백의 자리를 선택하면 다음 차례에는 수가 “5138”이 된다.
//
//이렇게 차례를 반복 하다가 자기 차례에 넘어온 수가 한 자리가 되면 그 사람이 패배하게 된다.
//
//게임을 시작할 때의 정수가 주어진다.
//
//앨리스가 먼저 차례를 가지고,
//
//서로 최선을 다해 게임을 한다고 할 때 어떤 사람이 게임에서 승리하게 될 것인지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 1000자리 이하의 양의 정수가 하나 주어진다.
//
//제일 첫 번째 자리는 0이 아니다.
//
//
//[출력]
//
//각 테스트 케이스마다 앨리스가 이기면 ‘A’를, 토끼가 이기면 ‘B’를 출력한다.

package Battle;

import java.io.*;
import java.util.Arrays;

public class Solution_52_2_이상한나라의덧셈게임2 {
	static int T, cnt, len;
	static String line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_52_2_이상한나라의덧셈게임.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			cnt=1;
			line = br.readLine();
			len = line.length();
			while(len>1) {
				line = (line.charAt(0)-'0')+(line.charAt(1)-'0')+line.substring(2);
				len = line.length();
				cnt++;
			}
			if(cnt%2==1) {
				System.out.println("#"+t+" B");
			}else {
				System.out.println("#"+t+" A");
			}

		}
	}
}
