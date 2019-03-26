//
//친구들과 디저트 카페 투어를 할 계획이다.
//[Fig 1] 과 같이 한변의 길이가 N인 정사각형 모양을 가진 지역에 디저트 카페가 모여
//있다.
//원 안의 숫자는 해당 디저트 카페에서 팔고 있는 디저트의 종류를 의
//미하고 카페들 사이에는 대각선 방향으로 움지기일 수 있는 길들이
//있다. 디저트 카페 투어는 어느 한 카페에서 출발하여 [Fig 2]와 같이
//대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아
//와야 한다.
//디저트 카페 투어를 하는 도중 해당 지역을 벗어나면 안된다.
//또한 친구들은 같은 종류의 디저트를 다시 먹는 것을 싫어한다. 
//2 [본 문서의 저작권은 ㈜멀티캠퍼스의 소유이므로 무단전재나 재배포를 금합니다.]
//Algorithm
//친구들과 디저트를 되도록 많이 먹으려고 한다.
//디저트 가게가 모여있는 지역의 한 변의 길이 N과 디저트 카페의 디저트 종류가 입력
//으로 주어질 때, 임의의 한 카페에서 출발하여 대각선 방향으로 움직이고 서로 다른
//디저트를 먹으면서 사각형 모양을 그리며 다시 출발점으로 돌아오는 경우
//디저트를 가장 많이 먹을 수 있는 경로를 찾고, 그때 디저트 수를 정답으로 출력하는
//프로그램을 작성 하여라. 만약, 디저트를 먹을 수 없는 경우 -1을 출력한다.
//[예시 Fig 2]와 같은 경우 정답은 6이 된다.
//[제약 사항]
//1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는데 C/C++/Java 모두 3초
//2. 디저트 카페가 모여있는 지역의 한 변의 길이 N은 4이상 20이사의 정수 이다.
//3. 디저트 종류를 나타나는 수는 1 이상 100이하의 정수이다.
//[입력]
//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄 부터 T개의
//테스트 케이스가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 디저트 카페가 모여있
//는 지역의 한 변의 길이 N이 주어진다.
//그 다음 N 줄에는 N*N 크기의 디저트 카페에서 파고 있는 디저트 종류에 대한 정보가
//주어진다.
//[출력]
//각 줄은 ‘#’로 시작하고 테스트 케이스 번호와 공백을 하나 둔 다음 정답을 출력한다. 
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static int T, N, maxdist;
	static int[][] cafe, pos= {{1,-1},{1,1},{-1,-1},{-1,1}};
	static int[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Main_2105_디저트카페.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					maxdist=Integer.MIN_VALUE;
					v = new int[101];
					v[cafe[i][j]]=1;
					findroad(i,j,i,j,cafe[i][j]);
					v[cafe[i][j]]=0;
				}
			}
		}
	}
	private static void findroad(int r, int c, int cr, int cc, int dist) {
		if(cr==r && cc==c) {
			maxdist = Math.max(dist, maxdist);
			return;
		}
	}
	
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N) ? true:false;
	}
}
