//
//초기에 {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
//
//여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
//
//연산을 수행하는 프로그램을 작성하시오.
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
//
//m은 입력으로 주어지는 연산의 개수이다.
//
//다음 m개의 줄에는 각각의 연산이 주어진다.
//
//합집합은 0 a b의 형태로 입력이 주어진다.
//
//이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
//
//두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
//
//이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
//
//a와 b는 n 이하의 자연수이며 같을 수도 있다.
//
//[출력]
//
//각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	public static void makeSet(int v) {
		arr[v] = v;
	}
	public static void unionSet(int u, int v) {
		arr[findSet(u)] = findSet(v);
	}
	public static int findSet(int v) {
		if(v==arr[v]) {
			return v;
		}
		return arr[v] = findSet(arr[v]);
	}
	static int T, n, m, order, a, b;
	static int[] arr;
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3289_서로소집합.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			for(int i=0; i<n+1; i++) {
				makeSet(i);
			}
			m = Integer.parseInt(st.nextToken());
			for(int i=0; i<m; i++) {				
				st = new StringTokenizer(br.readLine());
				order = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(order==0) {
					if(a!=b) {
						unionSet(a,b);
					}
				}else {
					if(a==b) {
						sb.append(1);
					}else if(findSet(a)==findSet(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
