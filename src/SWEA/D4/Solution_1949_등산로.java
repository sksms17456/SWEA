//등산로를 조성하려고 한다.등산로를 만들기 위한 부지는 N * N 크기를 가지고 있으며,
//이곳에 최대한 긴 등산로를 만들 계획이다.
//등산로 부지는 아래 [Fig. 1]과 같이 숫자가 표시된 지도로 주어지며, 각 숫자는 지형의
//높이를 나타낸다
//등산로를 만드는 규칙은 다음과 같다.
//① 등산로는 가장 높은 봉우리에서 시작해야 한다.
//② 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또
//는 세로 방향으로 연결이 되어야 한다.
//즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
//③ 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사
//를 할 수 있다.
//N * N 크기의 지도가 주어지고, 최대 공사 가능 깊이 K가 주어진다.
//이때 만들 수 있는 가장 긴 등산로를 찾아 그 길이를 출력하는 프로그램을 작성하라.
//[예시]
//위 [Fig. 1]과 같이 N = 5인 지도가 주어진 경우를 살펴보자.
//가장 높은 봉우리는 높이가 9로 표시된 세 군데이다.
//이 세 곳에서 출발하는 가장 긴 등산로 중 하나는 아래 [Fig. 2]와 같고, 이 때 길이는
//5가 된다. 
//2 [본 문서의 저작권은 ㈜멀티캠퍼스의 소유이므로 무단전재나 재배포를 금합니다.]
//Algorithm
//만약 최대 공사 가능 깊이 K = 1로 주어질 경우,
//아래 [Fig. 3]과 같이 빨간색 부분의 높이를 9에서 8로 깎으면 길이가 6인 등산로
//를 만들 수 있다
//[제약 사항]
//1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초
//2. 지도의 한 변의 길이 N은 3 이상 8 이하의 정수이다. (3 ≤ N ≤ 8)
//3. 최대 공사 가능 깊이 K는 1 이상 5 이하의 정수이다. (1 ≤ K ≤ 5)
//4. 지도에 나타나는 지형의 높이는 1 이상 20 이하의 정수이다.
//5. 지도에서 가장 높은 봉우리는 최대 5개이다.
//6. 지형은 정수 단위로만 깎을 수 있다.
//7. 필요한 경우 지형을 깎아 높이를 1보다 작게 만드는 것도 가능하다.
//[입력 사항]
//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의
//첫 번째 줄에는 등산로 길이 N과 공사 가능한 깊이 K가 주어진다.
//그 다음 N 줄에는 N*N 크기의 등산로 정보가 주어진다.
//[출력 사항]
//각 줄은 ‘#’로 시작하고 테스트 케이스 번호와 공백을 하나 둔 다음 정답을 출력한
//다. 

package SWEA.D4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1949_등산로 {
	static int T, N, K, maxheight, dist;
	static int[][] road, pos= {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_1949_등산로.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T	; tc++) {
			ArrayList<int[]> list = new ArrayList<>();
			maxheight = Integer.MIN_VALUE;
			dist = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			road = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					road[i][j] = Integer.parseInt(st.nextToken());
					maxheight=Math.max(maxheight, road[i][j]);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(road[i][j]==maxheight) {
						list.add(new int[] {i,j});
					}
				}
			}
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					for(int c=1; c<=K; c++) {
						if(road[a][b]-c<0) {
							break;
						}
						road[a][b]-=c;
						for(int i=0; i<list.size(); i++) {
							findRoad(list.get(i)[0],list.get(i)[1]);
						}
						road[a][b]+=c;
					}
					
				}
			}
			sb.append("#").append(tc).append(" ").append(dist).append("\n");
		}
		System.out.println(sb);
	}
	private static void findRoad(int r, int c) {
		LinkedList<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,road[r][c],1,0});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			dist = Math.max(dist, temp[3]);
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc)) {
					if(road[nr][nc]<temp[2]) {
						q.offer(new int[] {nr,nc,road[nr][nc],temp[3]+1,0});
					}
				}
			}
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N) ? true:false;
	}
}
