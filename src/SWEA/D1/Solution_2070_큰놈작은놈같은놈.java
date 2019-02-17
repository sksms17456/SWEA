//2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하라.
//
//
//[제약 사항]
//
//각 수는 0 이상 10000 이하의 정수이다.
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 2개의 수가 주어진다.
//
//
//[출력]
//
//출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
//
//(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2070_큰놈작은놈같은놈 {
	static char Answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D1/Solution_2070_큰놈작은놈같은놈.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++){
			int fnum=sc.nextInt();
			int snum=sc.nextInt();
			
			if(fnum>snum)
				Answer='>';
			else if(fnum==snum)
				Answer='=';
			else
				Answer='<';

			System.out.println("#"+t+" "+Answer);
		}
		
	}
}