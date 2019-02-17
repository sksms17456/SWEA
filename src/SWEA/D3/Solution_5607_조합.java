//자연수 N와 R가 주어진다. 이 때의 N combination R의 값을 1234567891로 나눈 나머지를  출력하세요.
//
//예를들면 N이 4, R이 2라면 4 combination 2는 (4 * 3) / (2 * 1) = 6이 된다.
//
//[입력]
//첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 20)
//
//각 케이스의 첫 줄에 정수 N, R이 주어진다. (1 ≤ N ≤ 1000000, 0 ≤ R ≤ N)
// 
//[출력]
//각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(TC) “를 출력하고, N combination R을 1234567891로 나눈 나머지를 출력하시오.
// 
package SWEA.D3;

import java.util.Scanner;

public class Solution_5607_조합 {
	static int T, N, R; 
	static long P = 1234567891;
	static long[] fact = new long[1000001];
	static long[] inv = new long[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			R = sc.nextInt();
			fact[0] = 1;
			fact[1] = 1;
			for(int i=2; i<=1000000; i++) {
				fact[i] = (fact[i-1]*i)%P;
			}
			inv[1000000] = power(fact[1000000], P-2);
			for(int i=1000000-1; i>0; i--) {
				inv[i] = (inv[i+1]*(i+1))%P;
			}
			
			long ans = (fact[N]*inv[N-R])%P;
			ans = (ans*inv[R])%P;
			System.out.println("#"+t+" "+ans);
		}
		
	}
	public static long power(long x, long y) {
		long ret = 1;
		while(y>0) {
			if(y%2==1) {
				ret *= x;
				ret %= P;
			}
			x *= x;
			x %= P;
			y /= 2;
		}
		return ret;
	}
}
