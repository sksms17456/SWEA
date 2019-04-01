package SWEA.D4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int T, N, W, H, min;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_5656_벽돌깨기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<W; i++) {
				for(int j=0; j<H; j++) {
					if(map[j][i]!=0) {
						crash(j,i,map,0);
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void crash(int r, int c, int[][] map, int cnt) {
		if(min==0) {
			return;
		}
		if(cnt==N) {
			return;
		}
		int[][] newmap = new int[H][W];
		copy(newmap, map);
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,newmap[r][c]});
		newmap[r][c] = 0;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int size=0; size<temp[2]; size++) {
				for(int i=0; i<4; i++) {
					int nr = temp[0]+pos[i][0]*size;
					int nc = temp[1]+pos[i][1]*size;
					if(isOk(nr,nc) && newmap[nr][nc]!=0) {
						queue.offer(new int[] {nr,nc,newmap[nr][nc]});
						newmap[nr][nc]=0;
					}
				}
			}
		}
		min = Math.min(min, count(newmap));
		drop(newmap);
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(newmap[j][i]!=0) {
					crash(j,i,newmap,cnt+1);
					break;
				}
			}
		}
	}
	private static void drop(int[][] arr) {
		for(int i=0; i<W; i++) {
			int idx = -1;
			for(int j=H-1; j>0; j--) {
				if(arr[j][i]==0) {
					idx = j;
					break;
				}
			}
			if(idx!=-1) {
				for(int j=idx-1; j>=0; j--) {
					if(arr[j][i]!=0) {
						arr[idx][i]=arr[j][i];
						arr[j][i]=0;
						idx--;
					}
				}
			}
		}
	}
	private static void copy(int[][] newarr, int[][] arr) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newarr[i][j] = arr[i][j];
			}
		}
	}
	private static int count(int[][] arr) {
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(arr[i][j]!=0) cnt++;
			}
		}
		return cnt;
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<H && c<W) ? true:false;
	}
}
