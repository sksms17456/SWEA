//악덕사장 현규는 어떻게 하면 전체 임금을 줄일 수 있을까 고민했다.
//
//그래서 연봉은 그대로 인 채로 2016년부터 1년을 13개월로 만들어 버리기로 했다. 이는 2016년부터 시행된다.
// 
//1년이 12개월	1년이 13개월
//2016년 12월	2016년 12월
//2017년 1월	2016년 13월
//2017년 2월	2017년 1월
//...	...
//2017년 12월	2017년 11월
//2018년 1월	2017년 12월
//2018년 2월	2017년 13월
//2018년 3월	2018년 1월
//1년이 12개월일 때의 년월이 주어질 때 이를 1년이 13개월일 때의 년월로 바꿔주는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 정수 Y, M(2016 ≤ Y ≤ 10¹², 1 ≤ M ≤ 12) 이 공백 하나로 구분되어 주어진다.
//
//이는 1년이 12개월일 때의 년월이다. 주어지는 시점은 2016년 12월 이거나 이후다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//
//1년이 13개월이면 주어진 년월이 어떻게 되는지 공백 하나로 구분하여 출력한다.
package Battle;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_57_1_현규의연봉계산법 {
	static int T;
	static long year, month, n, ny, nm;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Battle/Solution_57_1_현규의연봉계산법.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			year = Long.parseLong(st.nextToken());
			month = Long.parseLong(st.nextToken());
			n = (year-2016)*12 + month;
			ny = n/13+2016;
			nm = n%13;
			if(nm==0) {
				ny-=1;
				nm=13;
			}
			sb.append("#").append(tc).append(" ").append(ny).append(" ").append(nm).append("\n");
		}
		System.out.println(sb);
	}
}
