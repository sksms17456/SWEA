//경근이는 자신이 키우는 N마리의 앵무새를 데리고 "올해의 조련사" 대회를 나가려고 한다.
//
//이 대회에 참가하는 모든 조련사는 자신의 동물들을 일렬로 세우고, 그 동물들을 잘 이끌어서 심사위원을 지나가야 한다.
//
//
//이 대회의 조직자들은 올해부터 새로운 등록 방법을 적용시키기로 하였다
//
//: 대회에 참가하여 일렬로 등장할 동물들의 순서대로, 이름의 첫 글자를 따서 등록하는 것이다.
//
//(예를 들어, 경근이가 Apple, Pineapple, Grenapple을 순서대로 세운다면 APG가 되는 것이다.)
//
//그리고 등록이 끝나면, 각 조련사가 등록한 문자열들의 사전순으로 조련사들을 평가하려고 한다.
//
//경근이는 매우 바쁘기 때문에, 최대한 빨리 대회를 치르고 집으로 돌아가고 싶어한다.
//
//이러한 등록 방법을 몰랐던 경근이는, 이미 줄서있는 자신들의 앵무새를 급하게나마 다시 줄세우기로 했다.
//
//새로운 줄 세우기 방법은 다음과 같다
//
//: 기존의 줄과 새로운 줄 두 줄을 세운 다음, 기존의 줄에서 가장 앞에 있는 앵무새 혹은 가장 뒤에 있는 앵무새를 새로운 줄의 마지막에 세우는 것을 반복하는 방식이다.
//
//그런 다음, 경근이는 줄 세우기가 끝나자마자 바로 등록을 하려고 한다.
//
//기존에 줄서있는 앵무새들의 순서가 주어졌을 때, 경근이가 얻을 수 있는 사전순으로 가장 빠른 문자열을 알아내자.
//
//[입력]
//첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 10)
//
//각 테스트 케이스의 첫 번째 줄에 앵무새의 수 N이 주어진다. (1 ≤ N ≤ 2,000)
//
//각 테스트 케이스의 두 번째 줄부터 N개의 줄에 걸쳐 줄서있는 각 앵무새 이름의 첫 글자가 주어진다. 이 이름은 알파벳 대문자 한 글자이다.
//
//[출력]
//각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(TC) “를 출력하고, 경근이가 얻을 수 있는 사전순으로 가장 빠른 문자열을 출력한다.
// 
package SWEA.D4;

import java.io.*;
import java.util.ArrayList;

public class Solution_5672_올해의조련사 {
	static int T, N;
	static String newline;
	static ArrayList<Character> line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_5672_올해의조련사.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			line = new ArrayList<>();
			N = Integer.parseInt(br.readLine().trim());
			newline = "";
			for(int i=0; i<N; i++) {
				line.add(br.readLine().trim().charAt(0));
			}
			System.out.println(line.toString());
			while(true) {
				if(line.size()==1) {
					break;
				}
				int len = line.size();
				if(line.get(0)>line.get(len-1)) {
					newline+=line.get(0);
					line.remove(0);
				}else if(line.get(0)<line.get(len-1)) {
					newline+=line.get(len-1);
					line.remove(len-1);
				}else {
					
				}
			}
			newline += line.get(0);
			
		}
	}
}
