//평소 홀수를 너무 좋아하는 연구원 진수를 보던 교수님이 진수에게 그가 좋아할만한 과제를 하나 내주었다.
//
// 
//
//그 과제의 내용은 다음과 같다.
//
// 
//
//- f(x)는 x의 약수 중에서 홀수인 것들의 합이라고 하자.
//
//- 두 자연수 L과 R 이 주어지면 L과 R 사이의 모든 자연수 x에 대해서 f(x)의 총 합을 계산하라.
//
//
//교수님께서 내주신 과제를 수식으로 표현하면 다음과 같다.
//
//
// 
//
//    
//
//
//    홀수를 너무 좋아하지만 어린 시절 학습지 풀기를 게을리 한 진수는,
//
//    x가 커질경우 직접 손으로 계산하다가는 그의 머리가 버티지 못할것이라는 것을 직감하고 당신에게 도움을 요청하고자 한다.
//
//
//    진수를 위해서 위 과제의 정답을 계산해주는 프로그램을 작성해주자.
// 
//
//    예를 들어 L=6, R=10으로 주어진다고 할때, f(6)=1+3=4, f(7)=1+7=8, f(8)=1, f(9)=1+3+9=13, f(10)=1+5=6이므로
//
//    답은 4+8+1+13+6=32이다.
//
//
//    [입력]
//
//    첫 번째 줄에 테스트 케이스의 수 가 주어진다.
//
//    각 테스트 케이스의 첫 번째 줄에는 두 정수 L, R(1≤L≤R≤106)이 공백으로 구분되어 주어진다.
//
//    [출력]
//
//    각 테스트 케이스마다 #T를 출력하고 공백을 출력한 뒤, 각 테스트 케이스마다 위의 합을 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5213_진수의홀수약수 {
	static int T, L, R, x;
	static long sum;
	static long[] arr = new long[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_5213_진수의홀수약수.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Arrays.fill(arr, 1);
		for(int i=2; i<arr.length; i++) {
			sum=0;
			if(i%2==1) {
				arr[i]+=i;
			}
			x = (int)Math.sqrt(i);
			for(int j=2; j<=x; j++) {
				if(i%j==0) {
					int x = i/j;
					if(j==x && j%2==1) {
						arr[i]+=j;
						break;
					}
					if(j%2==1) {
						arr[i]+=j;
					}
					if(x%2==1) {
						arr[i]+=x;
					}
				}
			}
		}
		for(int i=1; i<arr.length; i++) {
			arr[i] += arr[i-1];
		}
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			sum=arr[R]-arr[L-1];
			sb.append("#"+t+" "+sum+"\n");

		}
		System.out.println(sb);
	}
}
