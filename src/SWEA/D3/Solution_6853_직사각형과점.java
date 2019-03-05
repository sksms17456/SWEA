//직사각형과 점들이 있다. 각 점들이 다음 중 어떤 상태에 있는지 판별하여,
//
//각각의 상태인 점이 몇 개씩 있는지 구하는 프로그램을 작성하라.
//
//    1. 점이 완전히 직사각형 내부에 있다.
//
//    2. 점이 직사각형의 네 변 중 적어도 하나의 위에 있다.
//
//    3. 점이 완전히 직사각형 외부에 있다.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 네 정수 X1, Y1, X2, Y2 ( -104 ≤ X1 ＜ X2 ≤ 104, -104 ≤ Y1 ＜ Y2 ≤ 104 )가 공백 하나로 구분되어 주어진다.
//
//이는 직사각형이 xy평면 위의 네 점 ( X1, Y1 ), ( X1, Y2 ), ( X2, Y2 ), ( X2, Y1 )으로 이루어진 직사각형이라는 뜻이다.
//
//두 번째 줄에는 점의 개수를 나타내는 하나의 정수 N ( 1 ≤ N ≤ 104 ) 이 주어진다.
//
//다음 N개의 줄의 각 줄에는 두 정수 x, y ( -104 ≤ x,y ≤ 104 ) 가 공백 하나로 구분되어 주어진다.
//
//이는 xy평면 위의 점 ( x, y )에 점이 하나 있다는 의미이다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//세 정수를 공백 하나로 구분하여 출력한다.
//
//첫 번째 정수는 완전히 직사각형 내부에 있는 점의 개수, 두 번째 정수는 직사각형의 네 변 중 적어도 하나의 위에 있는 점의 개수,
//
//세 번째 정수는 완전히 직사각형 외부에 있는 점의 개수여야 한다.

package SWEA.D3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_6853_직사각형과점 {
	static int T, N, x1, x2, y1, y2, x, y, in, out, on;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_6853_직사각형과점.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			in=0;
			out=0;
			on=0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if(x>x1 && x<x2 && y>y1 && y<y2) {
					in++;
				}else if(x<x1 || x>x2 || y<y1 || y>y2) {
					out++;
				}else {
					on++;
				}
			}
			sb.append("#"+t+" "+in+" "+on+" "+out+"\n");
		}
		System.out.println(sb);
	}
}
