//어느 날 경근이는 알파벳 대문자로 이루어진 두 문자열을 비교해야 했는데, 이 날은 공교롭게도 안경이 없었다.
//
//경근이는 매우 눈이 나빠서 안경을 벗으면 문자열을 문자 단위로 구별할 수는 있지만, 두 문자가 정확히 같은 지는 알지 못한다.
//
//특히 알파벳 대문자 같은 경우 문자에 나 있는 구멍의 개수가 같으면 같은 문자이고, 다르면 다른 문자라고 생각한다.
//
//예를 들어 구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ들을 같은 문자로 생각하고,
//
//구멍이 한 개 나 있는 ADOPQR들을 같은 문자로 생각하며,
//
//구멍이 두 개 나 있는 유일한 문자 B는 유일하게 정확히 알 수 있다.
//
//알파벳 대문자로 이루어진 두 문자열이 주어졌을 때, 경근이는 두 문자열이 같다고 판별하는지 다르다고 판별할 것인가?
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 문자열이 공백 하나로 구별되어 주어진다.
//
//각 문자열은 알파벳 대문자 만으로 이루어져 있으며, 길이는 10이하이다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//경근이가 주어진 두 문자열을 같은 것으로 생각하면 “SAME”을, 다른 것으로 생각하면 “DIFF”를 출력한다.
package Battle;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_56_1_안경이없어 {
	static int T, llen, rlen;
	static int[] hole = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
	static String left, right;
	static boolean isDiff;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_56_1_안경이없어.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			isDiff=false;
			st = new StringTokenizer(br.readLine().trim());
			left = st.nextToken();
			right = st.nextToken();
			llen = left.length();
			rlen = right.length();
			if(llen==rlen) {
				for(int i=0; i<llen; i++) {
					if(hole[left.charAt(i)-'A']!=hole[right.charAt(i)-'A']) {
						isDiff = true;
						break;
					}
				}
				if(isDiff) {
					sb.append("#").append(t).append(" DIFF\n");
				}else {
					sb.append("#").append(t).append(" SAME\n");
				}
			}
			else {
				sb.append("#").append(t).append(" DIFF\n");
			}
		}
		System.out.println(sb);
	}
}
