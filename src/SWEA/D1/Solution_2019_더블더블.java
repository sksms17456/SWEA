//1부터 주어진 횟수까지 2를 곱한 값(들)을 출력하시오.
//
//주어질 숫자는 30을 넘지 않는다.
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2019_더블더블{
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D1/Solution_2019_더블더블.txt"));
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int a = 1;
		for(int i=0; i<=A; i++) {
			System.out.print(a+" ");
			a=a*2;
		}
	}
}