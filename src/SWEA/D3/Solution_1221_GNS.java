//숫자 체계가 우리와 다른 어느 행성이 있다. 아래는 이 행성에서 사용하는 0 ~ 9의 값을 순서대로 나타낸 것이다.
//
//"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
//
//0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하는 프로그램을 작성하라.
//
//예를 들어 입력 문자열이 "TWO NIN TWO TWO FIV FOR" 일 경우 정렬한 문자열은 "TWO TWO TWO FOR FIV NIN" 이 된다.
//
//[입력]
//
//입력 파일의 첫 번째 줄에는 테스트 케이스의 개수가 주어진다.
//
//그 다음 줄에 #기호와 함께 테스트 케이스의 번호가 주어지고 공백문자 후 테스트 케이스의 길이가 주어진다.
//
//그 다음 줄부터 바로 테스트 케이스가 주어진다. 단어와 단어 사이는 하나의 공백으로 구분하며, 문자열의 길이 N은 100≤N≤10000이다.
//
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 정렬된 문자열을 출력한다.
package SWEA.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_1221_GNS {
	static int T, size;
	static int[] ans_arr;
	static String tc_str;
	static String[] tc_arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_1221_GNS.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<String, Integer> encoder = new HashMap<>();
		Map<Integer, String> decoder = new HashMap<>();
		String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		for(int i=0; i<num.length; i++) {
			encoder.put(num[i], i);
			decoder.put(i, num[i]);
		}
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			tc_str = st.nextToken();
			size = Integer.parseInt(st.nextToken());
			tc_arr = br.readLine().split(" ");
			int len = tc_arr.length;
			ans_arr = new int[len];
			for(int i=0; i<len; i++) {
				ans_arr[i] = encoder.get(tc_arr[i]);
			}
			Arrays.sort(ans_arr);
			sb.append(tc_str).append("\n");
			for(int i=0; i<len; i++) {
				sb.append(decoder.get(ans_arr[i])).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
