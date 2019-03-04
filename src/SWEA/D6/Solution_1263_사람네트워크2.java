//어떤 사화과학 연구 단체에서 사람의 네트워크에 대하여 여러 가지 측정 방법을 사용하여 연구하기로 하였다.
//
//이를 위해 우선 주어진 사람 네트워크에서 누가 가장 영향력이 있는 사람인지를 알 수 있는 척도로서 다음을 분석하는 프로그램을 작성하시오.
//
//단, N은 입력 사람 네트워크 (그래프)의 노드 수이다.
//
//Closeness Centrality(CC):Closeness는 네트워크 상에서 한 사용자가 다른 모든 사람에게 얼마나 가까운가를 나타낸다.
//
//따라서 사용자 i의 CC(i)는 다음과 같이 계산된다.
//
//      CC(i) = ∑ j dist(i,j) 단, dist(i,j)는 노드i로부터 노드 j까지의 최단 거리이다.
//
//예제 1)
// 
//
//
//
//위의 예제는 사람 네트워크에서 사용자 2의 dist합이 가장 작으며, CC(2) = 4임을 통해 사용자 2가 모든 다른 사용자들로부터 가장 가까운 사용자이다.
//
//예제 2)
// 
//
//
//위의 예제는 사람 네트워크에서 사용자 3의 dist합이 가장 작으며, CC(3) = 5임을 통해 사용자 3이 모든 다른 사용자들로부터 가장 가까운 사용자이다.
// 
//[제약 사항]
//
//입력으로 주어지는 사람 네트워크에서 노드 자신을 연결하는 간선은 없다.
//
//또한 사람 네트워크는 하나의 연결 요소(connected component)로 구성되어 있다.
//
//단, 사람 네트워크의 최대 사용자 수는 1,000 이하이다.
//
//테스트 케이스들은 아래의 그룹들로 이루어져 있다.
//그룹 1 싸이클이 없고 N <= 10 인 경우
//그룹 2 싸이클이 없고 10 < N <= 100 인경우
//그룹 3 싸이클이 있고 N<= 10
//그룹 4 싸이클이 있고10 < N <= 100
//그룹 5 모든 경우가 존재하고 100 < N <= 1000
//
//[입력]
//
//맨 위의 줄에는 전체 테스트 케이스의 수 T가 주어진다.
//
//그 다음 줄부터 T개의 테스트 케이스가 주어진다.
//
//각 테스트 케이스는 한 줄에 주어지며, 사람 수인 양의 정수 N이 주어진 다음, 사람 네트워크의 인접 행렬이 행 우선 (row-by-row) 순으로 주어진다.
//
//단, 각 숫자 사이에는 1개의 공백이 주어진다.
//
//[출력]
//0
//총 T줄에 T개의 테스트 케이스 각각에 대한 답을 한 줄에 출력한다.
//
//각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음, 각 테스트 케이스에 주어진 사람 그래프에서 사람들의 CC 값들 중에서 최솟값을 한 줄에 출력한다.
package SWEA.D6;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
	static int T, N, sum, min;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D6/Solution_1263_사람네트워크2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int max = Integer.MAX_VALUE>>1;
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && arr[i][j] == 0) {
						arr[i][j] = max;
					}
				}
			}
			for (int k = 0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++){
						if(i==j)continue;//대각선, A->A가는 거리
						if(arr[i][j]>arr[i][k]+arr[k][j]) {
							arr[i][j] = arr[i][k]+arr[k][j];
						}
					}
				}
			}
			min=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				sum=0;
				for(int j=0; j<N; j++) {
					sum+=arr[i][j];
					if(sum>=min)
						break;
				}
				min = Math.min(min, sum);
			}
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}
}
