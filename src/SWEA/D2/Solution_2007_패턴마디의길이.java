package SWEA.D2;

import java.io.*;

public class Solution_2007_패턴마디의길이 {
	static int T;
	static String line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D2/Solution_2007_패턴마디의길이.txt"));
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
        
		for(int i=1; i<=T; i++) {
			line = br.readLine();
		    char ch = line.charAt(0);
			for(int j=1; j<30; j++) {
				if(line.charAt(j)==ch) {
					String s = line.substring(0, j);
					String ns = line.substring(j,j*2);
					if(s.equals(ns)) {
						System.out.println("#"+i+" "+s.length());
						break;
					}
					j+=s.length();
				}
			}
		}
	}
}