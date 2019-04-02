package SWEA.D4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	static int T, N, L, cnt;
	static int[][] road;
	static int[] v;
	static boolean isRoad;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_활주로.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			cnt=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			road = new int[N][N];
			v = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					road[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Arrays.fill(v, -1);
			//row
			for(int i=0; i<N; i++) {
				isRoad = true;
				top:
				for(int j=0; j<N-1; j++) {
					if(Math.abs(road[i][j]-road[i][j+1])>1) {
						isRoad = false;
						break;
					}
					if(road[i][j]-1 == road[i][j+1]) {
						if(j>N-L-1) {
							isRoad = false;
							break;
						}
						int n = road[i][j]-1;
						for(int k=1; k<=L; k++) {
							if(n!=road[i][j+k] || v[j+k]==i) {
								isRoad = false;
								break top;
							}
							v[j+k]=i;
						}
						j+=L-1;
					}else if(road[i][j]+1 == road[i][j+1]) {
						if(j<L-1) {
							isRoad = false;
							break;
						}
						int n = road[i][j];
						for(int k=0; k<L; k++) {
							if(n!=road[i][j-k] || v[j-k]==i) {
								isRoad = false;
								break top;
							}
							v[j-k]=i;
						}
					}
				}
				if(isRoad) {
					cnt++;
				}
			}
			Arrays.fill(v, -1);
			//col
			for(int i=0; i<N; i++) {
				isRoad = true;
				top:
				for(int j=0; j<N-1; j++) {
					if(Math.abs(road[j][i]-road[j+1][i])>1) {
						isRoad = false;
						break;
					}
					if(road[j][i]-1 == road[j+1][i]) {
						if(j>N-L-1) {
							isRoad = false;
							break;
						}
						int n = road[j][i]-1;
						for(int k=1; k<=L; k++) {
							if(n!=road[j+k][i] || v[j+k]==i) {
								isRoad = false;
								break top;
							}
							v[j+k]=i;
						}
						j+=L-1;
					}else if(road[j][i]+1 == road[j+1][i]) {
						if(j<L-1) {
							isRoad = false;
							break;
						}
						int n = road[j][i];
						for(int k=0; k<L; k++) {
							if(n!=road[j-k][i] || v[j-k]==i) {
								isRoad = false;
								break top;
							}
							v[j-k]=i;
						}
					}
				}
				if(isRoad) {
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}

