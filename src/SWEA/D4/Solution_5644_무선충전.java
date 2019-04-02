package SWEA.D4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int T, M, A, size, power, sum;
	static int[] a, b;
	static int[][] v = new int[11][11], pos= {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static ArrayList<int[]>[][] list = new ArrayList[11][11]; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_5644_무선충전.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			for(int i=0; i<11; i++) {
				Arrays.fill(v[i], -1);
			}
			for(int i=1; i<11; i++) {
				for(int j=1; j<11; j++) {
					list[i][j] = new ArrayList<>();
				}
			}
			sum = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			a = new int[M+1];
			b = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				size = Integer.parseInt(st.nextToken());
				power = Integer.parseInt(st.nextToken());
				range(r,c,i);
			}
			
			sort();
			
			int Ar = 1, Ac = 1;
			int Br = 10, Bc = 10;
			for(int i=0; i<M+1; i++) {
				Ar+=pos[a[i]][0];
				Ac+=pos[a[i]][1];
				Br+=pos[b[i]][0];
				Bc+=pos[b[i]][1];
				int asize = list[Ar][Ac].size();
				int bsize = list[Br][Bc].size();
				int[] a;
				int[] b;
				if(asize>0) {
					a = list[Ar][Ac].get(0);
				}else {
					a = new int[]{0,0};
				}
				if(bsize>0) {
					b = list[Br][Bc].get(0);
				}else {
					b = new int[]{0,0};
				}
				if(asize==0 && bsize==0) sum+=0;
				else if(asize==0&&bsize>0) sum+=b[0];
				else if(asize>0&&bsize==0) sum+=a[0];
				else {
					if(a[0]!=b[0]) {
						sum += a[0] + b[0];
					}else{
						if(asize==1&&bsize==1) {
							if(a[1]==b[1]) {
								sum += a[0];
							}else {
								sum += a[0] + b[0];
							}							
						}else if(asize>1&&bsize==1) {
							if(a[1]==b[1]) {
								sum += b[0] + list[Ar][Ac].get(1)[0];
							}else {
								sum += a[0] + b[0];
							}
						}else if(asize==1&&bsize>1) {
							if(list[Ar][Ac].get(0)[1]==list[Br][Bc].get(0)[1]) {
								sum += a[0] + list[Br][Bc].get(1)[0];
							}else {
								sum += a[0] + b[0];
							}							
						}else {
							int max = Math.max(b[0] + list[Ar][Ac].get(1)[0], a[0] + list[Br][Bc].get(1)[0]);
							sum += max;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	private static void sort() {
		for(int i=1; i<11; i++) {
			for(int j=1; j<11; j++) {
				Collections.sort(list[i][j], new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if(o2[0]==o1[0]) {
							return o2[1]-o1[1];
						}
						return o2[0]-o1[0];
					}
				});
			}
		}
	}
	private static void range(int r, int c, int vidx) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,0});
		v[r][c]=vidx;
		list[r][c].add(new int[] {power,vidx});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i=1; i<=4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc) && v[nr][nc]!=vidx && temp[2]<size) {
					v[nr][nc] = vidx;
					list[nr][nc].add(new int[] {power,vidx});
					queue.offer(new int[] {nr,nc,temp[2]+1});
				}
			}
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=1 && c>=1 && r<11 && c<11) ? true:false;
	}
}
