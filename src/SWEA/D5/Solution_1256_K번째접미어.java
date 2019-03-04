//영어 소문자로 된 문자열이 있다. 문자열의 길이가 n일 때 접미어들은 문자열의 길이만큼 존재한다.
//
//“monster”라는 문자열에는 아래 그램의 왼쪽과 같은 접미어들이 있고 사전적으로 정렬했을 경우에 아래 그림과 같이 정렬된다.
// 
//
//
//
//“monster” 문자열의 접미어들 중에서 사전적 순서로 4번째에 오는 접미어는 “onster 이다.
//
//K값과 문자열이 주어지면 접미어들 중 사전적 순서로 K번째에 해당하는 접미어를 찾아서 출력하시오.
//
//[입력]
//
//가장 첫 줄은 전체 테스트 케이스의 수이다.
//
//10개의 테스트 케이스가 표준 입력을 통하여 주어진다.
//
//각 테스트 케이스는 정수 K 하나가 쓰여진 줄 다음에 영어 소문자로 된 문자열이 쓰인 줄로 이루어진다.
//
//문자열의 길이는 최대 400 이다.
//
//[출력]
//
//각 테스트 케이스마다, 첫 줄에는 “#C”를 출력해야 하는데 C는 케이스 번호이다.
//
//같은 줄에 빈 칸을 하나 사이에 두고 이어서 사전 순서로 K번째 나오는 부분 문자열을 출력한다.
//
//만약 K번째 문자열이 존재하지 않는다면, “none”을 출력한다.
package SWEA.D5;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_1256_K번째접미어 {
	static int T, N, len;
	static String line;
	static String[] m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D5/Solution_1256_K번째접미어.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++){
			N = Integer.parseInt(br.readLine());
			line = br.readLine();
			len = line.length();
			
			m = new String[len];
			
			for(int i=0; i<len; i++) {
				m[i] = line.substring(i, len);
			}
			Arrays.sort(m);
			List<String> list = Arrays.asList(m);
			if(N>len) {
				sb.append("#"+t+" "+"none\n");
			}else {
				sb.append("#"+t+" "+list.get(N-1)+"\n");
			}
		}
		System.out.println(sb);
	}
}
