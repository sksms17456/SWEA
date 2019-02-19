//그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
//
//최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
//
//입력으로 주어지는 그래프는 하나의 연결 그래프임이 보장된다.
//
//
//[입력]
//
//가장 첫 번째 줄에는 전체 test case의 수 T(1≤T≤10)가 주어진다. 
// 
//각 케이스의 첫째 줄에는 정점의 개수 V(1≤V≤100,000)와 간선의 개수 E(1≤E≤200,000)가 주어진다.
//
//다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
//
//이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다.
//
//C는 음수일 수도 있으며, 절대값이 1,000,000을 넘지 않는다.
//
//
//[출력]
//
//각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(테스트케이스 번호) “를 출력하고,  최소 스패닝 트리의 가중치를 출력한다.
//
//
//[힌트]
//
//최소 스패닝 트리를 계산하는 알고리즘으로 Prim's algorithm과 Kruskal's algorithm이 있다.
//
//본 문제에서는 주어지는 정점과 간선의 개수가 많기 때문에 효율적인 알고리즘 구현이 필요하다.
//
//Prim's algorithm을 이용할 경우, 자료구조 힙(heap)을 이용해야 한다.
//
//Kruskal's algorithm을 이용할 경우, Disjoint Set(서로소 집합) 혹은 Union-Find 알고리즘을 이용해야 한다.
package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_3124_최소스패닝트리 {
	static class Node implements Comparable<Node>{
		int A;//정점
		int B;//정점
		int C;//가중치
		
		public Node(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
		@Override
		public int compareTo(Node o) {
			return this.C - o.C >0 ? 1: -1;
		}
	}
	public static void makeSet(int x) {
		p[x] = x;
	}
	public static int findSet(int x) {
		if(p[x]!=x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	public static void union(Node node) {
		int root1 = findSet(node.A);
		int root2 = findSet(node.B);
		if(root1==root2) {
			return;
		}
		p[root1] = root2;	
		res += node.C;
	}
	static int T;
	static int[] p;		//부모 노드를 표현하는 배열
	static long res;	//
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3124_최소스패닝트리.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			//TreeSet - Comparable을 구현한 객체만 저장, 또는 생성시 Comparator객체를 설정해야 한다.
			//			- 저장한 객체를 정렬한다.
			TreeSet<Node> ts = new TreeSet<>();
			p = new int[V+1];
			for(int i=0; i<=V; i++) {
				makeSet(i);
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				ts.add(new Node(A,B,C));
			}
			res = 0;
			for(Node n : ts) {
				union(n);
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
