//주어진 숫자부터 0까지 순서대로 찍어보세요
//
//아래는 입력된 숫자가 N일 때 거꾸로 출력하는 예시입니다
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1545_거꾸로출력해보아요  {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D1/Solution_1545_거꾸로출력해보아요.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int i = sc.nextInt(); i>=0; i--)
			System.out.print(i+" ");
	}
}