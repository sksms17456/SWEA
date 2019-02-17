//4×4 크기의 격자판이 있다. 격자판의 각 격자칸에는 0부터 9 사이의 숫자가 적혀 있다.
//
//격자판의 임의의 위치에서 시작해서, 동서남북 네 방향으로 인접한 격자로 총 여섯 번 이동하면서, 
//
//각 칸에 적혀있는 숫자를 차례대로 이어 붙이면 7자리의 수가 된다.
//
//이동을 할 때에는 한 번 거쳤던 격자칸을 다시 거쳐도 되며, 0으로 시작하는 0102001과 같은 수를 만들 수도 있다.
//
//단, 격자판을 벗어나는 이동은 가능하지 않다고 가정한다.
//
//격자판이 주어졌을 때, 만들 수 있는 서로 다른 일곱 자리 수들의 개수를 구하는 프로그램을 작성하시오.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스마다 4개의 줄에 걸쳐서, 각 줄마다 4개의 정수로 격자판의 정보가 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 
//
//격자판을 이동하며 만들 수 있는 서로 다른 일곱 자리 수들의 개수를 출력한다.
 
package SWEA.D4;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기 {
	static int T, cnt=1, nr, nc;
	static String[][] panel = new String[4][4];
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
//	static Map<String, Boolean> map;
	static Set<String> set;
	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_2819_격자판의숫자이어붙이기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb, ans=new StringBuilder();
		
		for(int i=1; i<=T; i++) {
//			map = new HashMap<>();
			set = new HashSet<>();
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<4; k++) {
					panel[j][k] = st.nextToken();
				}
			}
			
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
					sb = new StringBuilder();
					sb.append(panel[j][k]);
					append(j,k,cnt,sb);
				}
			}
			ans.append("#"+i+" "+set.size()+"\n");
		}
		System.out.println(ans);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	public static void append(int r, int c, int cnt, StringBuilder sb) {
		if(cnt==7)
			set.add(sb.toString());
		else {
			for(int i=0; i<4; i++) {
				nr = r+pos[i][0];
				nc = c+pos[i][1];
				
				if(check()) {
					sb.append(panel[nr][nc]);
					append(nr, nc, cnt+1,sb);
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
	}
	public static boolean check() {
        if(nr<0 || nc<0 || nr>=4 || nc>=4)
            return false;
        else
            return true;
	}
}
