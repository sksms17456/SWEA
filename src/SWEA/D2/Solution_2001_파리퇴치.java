//N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
//
//아래는 N=5 의 예이다.
// 
//
//
//
//M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
//
//죽은 파리의 개수를 구하라!
//
//예를 들어 M=2 일 경우 위 예제의 정답은 49마리가 된다.
// 
//
//
//
//[제약 사항]
//
//1. N 은 5 이상 15 이하이다.
//
//2. M은 2 이상 N 이하이다.
//
//3. 각 영역의 파리 갯수는 30 이하 이다.
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
//
//다음 N 줄에 걸쳐 N x N 배열이 주어진다.
//
//
//[출력]
//
//출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
//
//(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

package SWEA.D2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	static int T, N, M, max;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D2/Solution_2001_파리퇴치.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			
			arr = new int[N][N];
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					arr[n][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					solve(i,j);
				}
			}
			System.out.println("#"+t+" "+max);
		}
		
	}
	public static void solve(int r, int c) {
		int sum = 0;
		for(int i=r; i<r+M; i++) {
			for(int j=c; j<c+M; j++) {
				sum += arr[i][j];
			}
		}
		max = Math.max(max, sum);
	}
}
