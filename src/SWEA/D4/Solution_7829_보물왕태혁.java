//보물 왕 태혁은 세상의 모든 보물을 숨겨놓은 창고를 만들었다. 그리고 잠금 장치에 비밀번호 숫자 N 을 등록하려고 한다.
//
//하지만 숫자를 까먹으면 자기 자신도 보물을 찾을 수 없다는 사실을 깨달았다. 그렇다고 숫자 그대로를 적으면 위험하다.
//
//숫자를 까먹지 않기 위해 특별한 방법으로 종이에 적어 놓았다.
//
//그 특별한 방법이란, 숫자 N 의 약수를 적어놓는 것이다. 숫자의 모든 약수를 따로 보관하여 숨길 계획이다. 단, 1과N 은 적지 않았다.
//
//10년 뒤, 보물을 찾으러 온 태혁은 암호를 입력해야 했는데 역시나 까먹어버렸다. 다행히 약수들이 적혀있는 종이를 가지고 있다.
//
//종이에 써져 있는 약수들을 보고 원래 숫자를 만들어 내자.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T 가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 종이에 써져 있는 약수의 개수 가 주어진다.
//
//두 번째 줄에는 서로 다른 자연수 P개가 주어진다. 자연수는 모두 2 이상 100만 이하이다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//각 테스트 케이스마다 원래 숫자 N을 출력하라.
package SWEA.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7829_보물왕태혁 {
	static int T, N, answer;
	static int[] password;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7829_보물왕태혁.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer=0;
			N = Integer.parseInt(br.readLine());
			password = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				password[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(password);;
			switch (N%2) {
			case 0:
				answer = password[0] * password[N-1];
				break;
			case 1:
				int mid = N/2;
				answer = password[mid] * password[mid];
				break;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
