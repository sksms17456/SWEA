//주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
//
//Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition.
//
//위 문장에서 ti 를 검색하면, 답은 4이다.
//
//[제약 사항]
//
//총 10개의 테스트 케이스가 주어진다.
//
//문장의 길이는 1000자를 넘어가지 않는다.
//
//한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
//
//한 문장에서는 하나의 문자열만 검색한다. 
//
//[입력]
//
//각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.
//
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
package SWEA.D4;

import java.io.*;

public class Solution_1213_String {
	static int T=10, n, cnt;;
	static String pattern, line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_1213_String.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;	
			pattern = br.readLine();
			line = br.readLine();
			
			for(int i=0; i<line.length()-pattern.length()+1; i++) {
				if(pattern.charAt(0)==line.charAt(i)) {
					if(line.substring(i, i+pattern.length()).equals(pattern)) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
