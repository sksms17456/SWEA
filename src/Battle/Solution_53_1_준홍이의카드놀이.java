//준홍이에게는 카드 두 세트가 있다.
//
//각 카드 세트는 1번 카드부터 N번 카드, 1번 카드부터 M번 카드로 구성되어 있다.
//
//심심했던 준홍이는 각 카드 세트에서 카드 한 장씩을 골랐다.
//
//그리고 각 카드에 적힌 숫자를 더해보았다.
//
//1번 카드와 1번 카드를 골랐다면 카드에 적힌 숫자의 합은 2가 될 것이고, N번 카드와 M번 카드를 골랐다면 카드에 적힌 숫자의 합은 N+M이 될 것이다.
//
//문득 준홍이는 각 카드 세트에서 카드를 한 장씩 골라서 카드에 적힌 숫자를 합한 결과 중, 등장할 확률이 가장 높은 숫자는 어떤 숫자일지 궁금해졌다.
//
//단, 카드 세트에서 어떤 카드를 선택할 확률은 모두 동일하다고 가정한다.
//
//이를 계산하는 프로그램을 작성하라.
//
// 
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 개의 x정수 N, M(4 ≤ N, M ≤ 20)이 공백 하나로 구분되어 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//선택한 두 카드에 적힌 숫자의 합 중 등장할 확률이 가장 높은 것들을 오름차순으로 공백을 사이에 두고 한 줄에 모두 출력한다.

package Battle;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_53_1_준홍이의카드놀이 {
	static int N, M, T;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_53_1_준홍이의카드놀이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cnt = new int[N+M+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					cnt[i+j]++;
				}
			}
			int max = Integer.MIN_VALUE;
			sb.append("#"+t);
			for(int i=0; i<cnt.length; i++) {
				max = Math.max(max, cnt[i]);
			}
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i]==max) {
					sb.append(" "+i);
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
