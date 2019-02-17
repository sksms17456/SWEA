//주어진 숫자만큼 # 을 출력해보세요.
//
//주어질 숫자는 100,000 이하다.
package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2046_스탬프찍기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("text_D1/Solution_2046_스탬프찍기.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.print("#");
		}
		
	}
}