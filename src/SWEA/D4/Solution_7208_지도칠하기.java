//
//지도 칠하기
//
//지도에 있는 각 나라의 색을 칠하려고 한다.                                                  
//초기에 배정된 나라별 색으로 지도를 칠할려고 보니 인접된 나라의 색이 동일한 경우가 있어                          
//나라별 구별을 위해  다른 색으로 변경해야 한다.                                                
//인접 된 나라의 동일한 색을 최소 변경을 통해 지도에 있는 모든 나라의 색을 지정해 보자.                         
//최대 사용할 수 있는 색은 4가지이며  4가지 색상으로 인접 국가가 동일 색이 나오지 않도록 모두 칠할 수 있다.               
//
//[제한 조건]
//지도에 표시하는 나라의 수는  최소 3개 국가 이상  최대 8개 국가 이하이다.  3<=N<=8 
//                                                                           
//[입력 형식]                                                                    
//첫번째 줄은 테스트 케이스 수 이다(T)                                                     
//두번째 줄은 나라 수(N)가 주어진다.                                                      
//세번째 줄은 각 나라에 배정 된 색상 값이 숫자 1번 부터 4번까지 주어진다.                                   
//다섯번째 줄부터 국가간 인접 정보가  인접행렬로(N*N)정보로 인접된 국가는 1, 인접되지 않은 국가는 0으로 주어진다.        
//                                                                           
//[출력 형식]                                                                    
//#테스트케이스 최소 변경 된 색의 수                                                
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_7208_지도칠하기 {
	static int T, N;
	static int[] color;
	static int[][] matrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7208_지도칠하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#"+t+" "+"\n");
		}
	}
}
