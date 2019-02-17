//어느날 희성이는 멀리 있는 물체는 보기가 힘들다는 생각을 했다.
//
//그렇기에 다음과 같은 방식으로 물체가 얼마나 떨어져 있는지에 따라 다음처럼 수치를 매기기로 했다.
//
//1. 0.1km 미만 : 0으로 매긴다.
//
//2. 0.1km 이상 1km 미만 : 1으로 매긴다.
//
//3. 1km 이상 10km 미만 : 2로 매긴다.
//
//4. 10km 이상 100km 미만 : 3으로 매긴다.
//
//5. 100km 이상 1000km 미만 : 4로 매긴다.
//
//6. 1000km 이상 : 5로 매긴다.
//
//어떤 물체와의 거리가 주어질 때, 위의 방식으로 수치를 매기는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 하나의 정수 이 주어진다.
//
//d는 어떤 물체와의 거리를 m단위로 표현한 수이다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//거리에 따른 수치를 출력한다.
package SWEA.D3;

import java.io.FileInputStream;
import java.util.Scanner;
public class Solution_6718_희성이의원근법 {
	static int T;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("text_D3/Solution_6718_희성이의원근법.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n=sc.nextInt();
			int a=0;
			if(n<100)
				a=0;
			else if(n>=100&&n<1000)
				a=1;
			else if(n>=1000&&n<10000)
				a=2;
			else if(n>=10000&&n<100000)
				a=3;
			else if(n>=100000&&n<1000000)
				a=4;
			else
				a=5;
			
			System.out.println("#"+t+" "+a);
		}
	}
}
