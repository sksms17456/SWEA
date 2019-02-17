//
//입력으로 1개의 정수 N 이 주어진다.
//
//정수 N 의 약수를 오름차순으로 출력하는 프로그램을 작성하라.
// 
//
//[제약사항]
//
//N은 1이상 1,000이하의 정수이다. (1 ≤ N ≤ 1,000)
// 
//
//[입력]
//
//입력으로 정수 N 이 주어진다.
//
//
//[출력]
//
//정수 N 의 모든 약수를 오름차순으로 출력한다.
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1933_간단한N의약수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D1/Solution_1933_간단한N의약수.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			if(N%i==0)
				System.out.print(i+" ");
		}
	}
}