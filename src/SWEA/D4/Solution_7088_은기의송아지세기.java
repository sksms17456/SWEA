//프로그래밍 대회를 성공적으로 마친 은기는 사회 공헌을 위해 대회 우승자들과 농촌 봉사활동을 떠나기로 했다.
//
//은기와 대회 우승자들은 한적한 시골 마을 어딘가에 N마리의 송아지를 키우고 있는 곳으로 갔다.
//
//그 곳의 각 송아지에는 1번부터 N번까지의 고유번호와 1번부터 3번까지의 품종 번호가 매겨져 있었다.
//
//은기와 대회 우승자들은 송아지들을 보고서 문득 질문이 생겼다.
//
//        “고유번호 L번부터 R번까지의 송아지들에 대해서 각각의 품종은 몇 마리가 있을까?”
//
//이들이 궁금해하는 모습을 본 당신은, 프로그램을 만들어 도와주기로 결정하였다.
//
//질문 Q개에 대하여 각각 1번, 2번, 3번 품종의 수를 답해주는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 개의 정수 N, Q ( 1 ≤ N, Q ≤ 100,000 ) 가 공백을 사이에 두고 주어진다.
//
//다음 N개의 줄의 i번째 줄에는 고유번호 i번 소의 품종 번호가 주어진다.
//
//다음 Q개의 줄의 i번째 줄에는 i번째 질문에 해당하는 Li , Ri ( 1 ≤ Li ≤ Ri ≤ N )가 공백을 사이에 두고 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//다음 줄부터 Q개의 줄에 걸쳐서 고유번호 Li번부터 Ri번까지의 송아지들에 대해서
//
//1번 품종의 수, 2번 품종의 수, 3번 품종의 수를 나타내는 3개의 정수를 순서대로 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_7088_은기의송아지세기 {
	static int T, N, Q, L, R;
	static int[] dp1, dp2, dp3;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7088_은기의송아지세기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+"\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			dp1 = new int[N+1];
			dp2 = new int[N+1];
			dp3 = new int[N+1];
			for(int i=1; i<N+1; i++) {
				int k=Integer.parseInt(br.readLine());
				if(k==1) {
					dp1[i]=dp1[i-1]+1;
					dp2[i]=dp2[i-1];
					dp3[i]=dp3[i-1];
				}else if(k==2) {
					dp2[i]=dp2[i-1]+1;
					dp1[i]=dp1[i-1];
					dp3[i]=dp3[i-1];
				}else {
					dp3[i]=dp3[i-1]+1;
					dp1[i]=dp1[i-1];
					dp2[i]=dp2[i-1];
				}
			}
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				sb.append((dp1[R]-dp1[L-1])+" "+(dp2[R]-dp2[L-1])+" "+(dp3[R]-dp3[L-1])+"\n");
			}
		}
		System.out.println(sb);
	}
}
