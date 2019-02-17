//10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
//
//(소수점 첫째 자리에서 반올림한 정수를 출력한다.)
//
//
//[제약 사항]
//
//각 수는 0 이상 10000 이하의 정수이다.
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각  테스트 케이스가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
//
//
//[출력]
//
//출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
//
//(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
package SWEA.D2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1984_중간평균값구하기 {
	static int T;
//	static int arr[] = new int[10];
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("text_D2/Solution_1984_중간평균값구하기.txt"));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
	
		for(int t=1; t<=T; t++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			float sum = 0;
			
//			for(int i=0; i<arr.length; i++) {
//				arr[i] = sc.nextInt();
//				max = Math.max(max, arr[i]);
//				min = Math.min(min, arr[i]);
//				sum += arr[i];
//			}
			
			String str[] = input.readLine().split(" ");
			for(String s:str) {
				max=Math.max(max, Integer.parseInt(s));
				min=Math.min(min, Integer.parseInt(s));
				sum+=Integer.parseInt(s);
				System.out.print(Integer.parseInt(s)+" ");
			}
			int avg = Math.round((sum-max-min)/8);
			
//			System.out.println("#"+t+" "+avg);
			output.write("#"+t+" "+avg);
		}
		output.flush();
		
	}
}
