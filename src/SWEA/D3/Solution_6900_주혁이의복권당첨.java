package SWEA.D3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_6900_주혁이의복권당첨 {
	static int T, N, M, sum;
	static String line, num;
	static boolean isWin;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_6900_주혁이의복권당첨.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		Map<String, Integer> map;
		
		for(int t=1; t<=T; t++) {
			sum=0;
			map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<M; i++) {
				line = br.readLine();
				for(String s:map.keySet()) {
					isWin=true;
					for(int j=0; j<8; j++) {
						if(Character.isDigit(s.charAt(j))) {
							if(s.charAt(j)!=line.charAt(j)) {
								isWin=false;
								break;
							}
						}
					}
					if(isWin) {
						sum+=map.get(s);
					}
				}
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb);
		
	}
}
