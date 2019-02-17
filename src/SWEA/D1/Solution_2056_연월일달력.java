//[입력]
//
//입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
//
//다음 줄부터 각 테스트 케이스가 주어진다.
//
//
//[출력]
//
//테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
//
//(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2056_연월일달력 {
	static String Answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("text_D1/Solution_2056_연월일달력.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String ymd = sc.next();
			String res = "";
			int y = Integer.parseInt(ymd.substring(0, 4));
			int m = Integer.parseInt(ymd.substring(4, 6));
			int d = Integer.parseInt(ymd.substring(6, 8));
			if(m>12 || m<=0)
				res="-1";
			else if(m==2) {
				if(d>28)
					res="-1";
				else
					res=ymd.substring(0, 4)+"/"+ymd.substring(4, 6)+"/"+ymd.substring(6, 8);
			}
			else if(m==4 || m==6 || m==9 || m==11) {
				if(d>30)
					res="-1";
				else
					res=ymd.substring(0, 4)+"/"+ymd.substring(4, 6)+"/"+ymd.substring(6, 8);
			}
			else {
				if(d>31)
					res="-1";
				else
					res=ymd.substring(0, 4)+"/"+ymd.substring(4, 6)+"/"+ymd.substring(6, 8);
			}
			
			Answer=res;
			
			System.out.println("#"+t+" "+Answer);
		}
		
	}
}
