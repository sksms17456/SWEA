//최빈수구하기. 같을 경우 큰 값구하기
//학생수 1000명,점수는 0부터 100점
//첫번째줄 테스트 횟수 T
//둘쨋 줄 테스트케이스 번호
//세번째줄부터 점수입력
package SWEA.D3;
import java.util.Scanner;

public class Solution_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int[] arr = new int[101];
			
			System.out.println(i+1);
			for(int j=0;j<1000;j++) {
				int score=sc.nextInt();
				arr[score]++;
			}
			
			int max=0,index=0;
			for(int j=0;j<arr.length;j++) {
				if(max<arr[j]) {
					max=arr[j];
					index=j;
				}
			}
			
			System.out.println("#"+(i+1)+" "+index);
		}
	}
}
