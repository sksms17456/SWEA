//3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
//
// 
//
//1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
//
//  1 2 3 4 5 6 7 8 9…
//
//2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.  
//예를 들어 숫자 35의 경우 박수 한 번, 숫자 36의 경우 박수를 두번 쳐야 한다.
// 
//
//입력으로 정수 N 이 주어졌을 때, 1~N 까지의 숫자를
//
//게임 규칙에 맞게 출력하는 프로그램을 작성하라.
//
//박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
//
//여기서 주의해야 할 것은 박수 한 번 칠 때는 - 이며, 박수를 두 번 칠 때는 - - 가 아닌 -- 이다. 
// 
//
//[제약사항]
//
//N은 10이상 1,000이하의 정수이다. (10 ≤ N ≤ 1,000)
//
// 
//
//[입력]
//
//입력으로 정수 N 이 주어진다.
//
//
//[출력]
//
//1 ~ N까지의 숫자를 게임 규칙에 맞게 출력한다.
package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1926_간단한369게임  {
	static int Answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("text_D2/Solution_1926_간단한369게임.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=1; i<=N; i++) {
			int cnt=0;
			String str = String.valueOf(i);
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)-'0'==3 || str.charAt(j)-'0'==6 || str.charAt(j)-'0'==9)
					cnt++;
					
			}
			if(cnt==1)
				str = str.replaceAll(str, "-");
			else if(cnt==2)
				str = str.replaceAll(str, "--");
			else if(cnt==3)
				str = str.replaceAll(str, "----");
			System.out.print(str+" ");
			
		}
	}
}