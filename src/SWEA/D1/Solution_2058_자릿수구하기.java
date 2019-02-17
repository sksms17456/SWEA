//하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.
//
//
//[제약 사항]
//
//자연수 N은 1부터 9999까지의 자연수이다. (1 ≤ N ≤ 9999)
//
//
//[입력]
//
//입력으로 자연수 N이 주어진다.
//
//
//[출력]
//
//각 자릿수의 합을 출력한다.
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2058_자릿수구하기 {
	static int Answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D1/Solution_2058_자릿수구하기.txt"));
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		for(int i=0;i<N.length(); i++) {
			Answer+=N.charAt(i)-'0';
		}
		
		System.out.println(Answer);
	}
		
}
