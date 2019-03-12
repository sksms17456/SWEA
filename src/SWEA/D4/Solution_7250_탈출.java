//앤트맨 
//
//마블 히어로의 주인공 중 한명인 앤트맨 스캇이 악당과 싸우고 있다. 
//N*M 크기의 공간에는 스캇을 쫒는 악당과 더불어 불이 번져가고 있다. 
//스캇은 악당과 불을  피해 출구(E)에 도착할 수 있는 최소 횟수를 구하라
//스캇과, 악당과 불은 모두 상, 하, 좌, 우로 단위 시간당 1칸씩 이동한다. 
//
//1. 스캇은 출발점(S)로 부터 크기에 상관없이 이동 가능한 길 (A)과 몸의 크기를 줄이면 통과할 수 있는 벽 (W)을 통해 이동 할수 있으나
//      불(F)이 점화된 곳과 벽 (X)은 몸의  크기를 줄여도 통과할 수 없다.
//
//2. 몸을 줄인 상태에서 벽(W)은  줄인 몸을 유지하는 시간(K)동안 지날 갈 수 있다. 
//      횟수만큼 다 사용했는데 또 벽이 나오는 경우 해당 벽은 지날 갈 수 없다.
//      지날 갈 수 있는 길(A)에 진입 했을 때에는 몸을 줄여서 유지하는 동안 사용했던 시간은 처음 제공됐던 시간 K로 돌아오며,
//      몸의 크기를 줄이는 횟수는 제한 없이 사용 할 수 있다.
//      유지시간(K)가 3이면 경우  단위시간 당 1칸을 몸을 줄여 벽을 통과할 수 있으므로 총 3칸을 이동할 수 있다. 
//      
//3. 화재 시작점 (F)
//     화재는 미로의 여러곳에서 시작할 수 있다.
//     불이 번지는 속도는 단위 시간 당 한칸이며 벽(W, X)에는 불이 안 붙는다.
//     불이 번지고 있는 위치로는 스캇은 이동 할 수 없지만 스캇의 이동 위치로 위치로 불이 번지면 도망갈 수는 있다.
//     
//4. 악당은 불을 자유 자재로 다룰 수 있는 능력이 있어 출발점(V)로 부터 출발하여  
//      이동 가능한 길 (A)와 불(F)을 통과 할 수 있지만 벽(W, X)은 통과 할 수 없다. 
//      스캇과 악당이 이동경로에서 마주친 경우 아무일 없이 지나간다.
//    
//5. 스캇은 출발점(S)로 부터 탈출구(E)까지의 최단 거리로 탈출한 수를 출력한다. 
//     단, 악당이 스캇보다 먼저 탈출구(E)에 도착하면 출구를 막고 스캇은 탈출할 수 없게 되어 -1을 출력한다.
//            스캇과 악당이 동시에 탈출구(E)에 도착하면 악당이 먼저 도착한 것으로 간주하여    
//            스캇은 탈출할 수 없게 되어 -1을 출력한다.
//            
//[제한 조건]            
//맵의 크기는 최소 3부터 최대 1000의 크기이다. (3 <= N,M <= 1000)
//스캇의 줄은 몸의 유지시간은 최소 1시간 부터 최대 10시간 이다 .(1 <= K <= 10)
//
//
//[입력]
//첫번쨰 줄에는 테스트케이스를 입력
//두번쨰 줄에는 배열의 크기 N(행) M(열) 와 벽을 지날 수 있는  줄인 몸을 유지하는 시간(K)를 입력
//세번째 줄 부터는 스캇(S), 악당(V), 탈출(E) 하나씩 있으며
//지날 갈 수 있는 길 (A), 벽(W), 지날 갈 수 없는 길(X), 불(F)이
//배열의 크기 만큼 있다.
//
//[출력]
//#(테스트케이스 번호) 스캇이 최단거리로 탈출한 횟수 출력
//악당이 먼저 도착하거나 스캇이 탈출하지 못하면 -1 출력
package SWEA.D4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7250_탈출 {
	static class Obj{
		int r;
		int c;
		int w;
		int cnt;
		public Obj(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Obj(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		public Obj(int r, int c, int w, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
			this.cnt = cnt;
		}
	}
	static int T, N, M, K, scnt, ecnt;
	static char[][] map;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean[][] sv, ev;
	static LinkedList<Obj> scat, evil, fire;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7250_탈출.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			scat = new LinkedList<>();
			evil = new LinkedList<>();
			fire = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sv = new boolean[N][M];
			ev = new boolean[N][M];
			map = new char[N][M];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					switch (map[i][j]) {
					case 'S':
						sv[i][j] = true;
						scat.add(new Obj(i,j,0,0));
						break;
					case 'V':
						ev[i][j] = true;
						evil.add(new Obj(i,j,0));
						break;
					case 'F':
						fire.add(new Obj(i,j));
						break;
					}
				}
			}
			top:
			while(true) {
				int size = fire.size();
				for(int i=0; i<size; i++) {
					Obj o = fire.poll();
					for(int k=0; k<4; k++) {
						int nr = o.r+pos[k][0];
						int nc = o.c+pos[k][1];
						if(isOk(nr,nc) && map[nr][nc]=='A') {
							map[nr][nc] = 'F';
							fire.offer(new Obj(nr,nc));
						}
					}
					fire.offer(new Obj(o.r,o.c));
				}
				size = scat.size();
				for(int i=0; i<size; i++) {
					Obj o = scat.poll();
					sv[o.r][o.c]= false; 
					scnt = o.cnt+1;
					for(int k=0; k<4; k++) {
						int nr = o.r+pos[k][0];
						int nc = o.c+pos[k][1];
						if(isOk(nr,nc) && !sv[nr][nc]) {
							if(map[nr][nc]=='E') {
								break top;
							}
							if(map[nr][nc]=='A') {
								sv[nr][nc] = true;
								scat.offer(new Obj(nr,nc,0,o.cnt+1));
							}
							else if(map[nr][nc]=='W' && o.w<K) {
								scat.offer(new Obj(nr,nc,o.w+1,o.cnt+1));
							}
						}
					}
				}
				size = evil.size();
				for(int i=0; i<size; i++) {
					Obj o = evil.poll();
					ev[o.r][o.c]= false; 
					ecnt = o.cnt+1;
					for(int k=0; k<4; k++) {
						int nr = o.r+pos[k][0];
						int nc = o.c+pos[k][1];
						if(isOk(nr,nc) && !ev[nr][nc]) {
							if(map[nr][nc]=='E') {
								break top;
							}
							if(map[nr][nc]=='F' || map[nr][nc]=='A') {
								ev[nr][nc] = true;
								evil.offer(new Obj(nr,nc,o.cnt+1));
							}
						}
					}
				}
				
			}
			if(scnt>ecnt) {
				sb.append("#").append(t).append(" ").append(scnt).append("\n");
			}else {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
			}	
		}
		System.out.println(sb);
	}
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<N && c<M) {
			return true;
		}
		return false;
	}
}
