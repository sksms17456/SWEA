//준환이는 N개의 서로 다른 무게를 가진 무게 추와 양팔저울을 가지고 있다.
//
//모든 무게 추를 양팔저울 위에 올리는 순서는 총 N!가지가 있고,
//
//여기에 더해서 각 추를 양팔저울의 왼쪽에 올릴 것인지 오른쪽에 올릴 것인지를 정해야 해서 총 2N * N!가지의 경우가 있다.
//
//하지만 양팔 저울에 갑자기 문제가 생겨서 무게 추를 올릴 때 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
// 
//예를 들어 무게추가 총 3개, 무게가 각각 1, 2, 4 라고 하면 아래 그림처럼 총 15가지 경우가 나올 수 있다.
//
//
//
//이런 방법으로 준환이가 양팔 저울에 모든 무게추를 올리는 방법은 총 몇 가지가 있을까?
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스마다 첫 번째 줄에 N(1 ≤ N ≤ 9)가 주어진다.
//
//두 번째 줄에는 각 무게추의 무게를 의미하는 N개의 자연수가 공백으로 구분되어 주어진다. 무게는 1이상 999이하이다.
//
//
//[출력]
//
//각 테스트 케이스마다 무게추를 올리는 과정에서 오른쪽 위에 올라가있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않는 경우의 수를 출력한다.

package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static int T, N, ans, sum;
	static int[] arr, made;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3234_준환이의양팔저울.txt"));
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			ans=0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			made = new int[N];
			v = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			makeArr(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	private static void goScale(int left, int right, int cnt) {
		if(left<right) {
			return;
		}
		if(cnt==N) {
			ans++;
			return;
		}
		goScale(left+made[cnt], right,cnt+1);
		goScale(left,right+made[cnt],cnt+1);
	}
	private static void makeArr(int cnt) {
		if(cnt==N) {
			goScale(0,0,0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i]=true;
				made[cnt] = arr[i];
				makeArr(cnt+1);
				v[i] = false;
			}
		}
	}
}