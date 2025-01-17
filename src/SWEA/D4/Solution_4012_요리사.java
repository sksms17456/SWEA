//두 명의 손님에게 음식을 제공하려고 한다.
//
//두 명의 손님은 식성이 비슷하기 때문에, 최대한 비슷한 맛의 음식을 만들어 내야 한다.
//
//N개의 식재료가 있다.
//
//식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)
//
//이때, 각각의 음식을 A음식, B음식이라고 하자.
//
//비슷한 맛의 음식을 만들기 위해서는 A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
//
//음식의 맛은 음식을 구성하는 식재료들의 조합에 따라 다르게 된다.
//
// 
//
//식재료 i는 식재료 j와 같이 요리하게 되면 궁합이 잘 맞아 시너지 Sij가 발생한다. (1 ≤ i ≤ N, 1 ≤ j ≤ N, i ≠ j)
//
//각 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 Sij들의 합이다.
//
// 
//
//식재료 i를 식재료 j와 같이 요리하게 되면 발생하는 시너지 Sij의 정보가 주어지고, 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 정답으로 출력하는 프로그램을 작성하라.
//
// 
//
//[예시]
//
//N = 4인 예를 생각해보자. 시너지 Sij는 [Table 1]과 같이 주어진다.
//
//(세로축으로 i번째 위치에 있고 가로축으로 j번째 위치에 있는 값이 Sij이다.)
//
//                                        
//                                                                      [Table 1]
//
// 
//
//식재료 1과 식재료 2를 A음식으로 만들고 식재료 3과 식재료 4를 B음식으로 만드는 경우를 생각하자.
//
// 
//
//1) 식재료 1을 식재료 2와 같이 요리했을 때 발생하는 시너지 S12는 5이다.
//
//2) 식재료 2를 식재료 1과 같이 요리했을 때 발생하는 시너지 S21는 4이다.
//
//3) A음식의 맛은 5 + 4 = 9가 된다.
//
//4) 식재료 3을 식재료 4와 같이 요리했을 때 발생하는 시너지 S34는 3이다.
//
//5) 식재료 4를 식재료 3과 같이 요리했을 때 발생하는 시너지 S43은 3이다.
//
//6) B음식의 맛은 3 + 3 = 6이 된다.
//
// 
//
//따라서, 두 음식 간의 맛의 차이는 |9 – 6| = 3이 된다.
//
// 
//
//식재료 2와 식재료 4를 A음식으로 만들고 식재료 1과 식재료 3을 B음식으로 만드는 경우를 생각하자.
//
// 
//
//7) 식재료 2를 식재료 4와 같이 요리했을 때 발생하는 시너지 S24는 1이다.
//
//8) 식재료 4를 식재료 2와 같이 요리했을 때 발생하는 시너지 S42는 2이다.
//
//9) A음식의 전력은 1 + 2 = 3이 된다.
//
//10) 식재료 1을 식재료 3과 같이 요리했을 때 발생하는 시너지 S13은 3이다.
//
//11) 식재료 3과 식재료 1을 같이 요리했을 때 발생하는 시너지 S31은 2이다.
//
//12) B음식의 맛은 3 + 2 = 5가 된다.
//
// 
//
//따라서, 두 음식간의 맛의 차이는 |3 – 5| = 2가 된다.
//
//이 경우가 A음식과 B음식 간의 맛의 차이가 최소인 경우이다.
//
//다른 경우에서는 맛의 차이가 2보다 작을 수 없다.
//
//따라서, 본 예의 정답은 2가 된다.
//
// 
//
// [제약사항]
//
//1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C / C++ / Java 모두 3초
//
//2. 식재료의 수 N은 4이상 16이하의 짝수이다. (4 ≤ N ≤ 16)
//
//3. 시너지 Sij는 1이상 20,000이하의 정수이다. (1 ≤ Sij ≤ 20,000, i ≠ j)
//
//4. i와 j가 서로 같은 경우의 Sij값은 정의되지 않는다. 입력에서는 0으로 주어진다.
//
// 
//
//[입력]
//
//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고,
//
//그 다음 줄부터 T개의 테스트 케이스가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 식재료의 수 N이 주어진다.
//
//다음 N개의 줄에는 N * N개의 시너지 Sij값들이 주어진다. i와 j가 서로 같은 경우는 0으로 주어진다.
//
// 
//
//[출력]
//
//테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.
//
//각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t 는 1부터 시작하는 테스트 케이스의 번호이다.)
//
//정답은 두 음식 간의 맛의 차이가 최소가 되도록 A음식과 B음식을 만들었을 때 그 차이 값이다.
package SWEA.D4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int T, N, min;
	static int[][] arr;
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_4012_요리사.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb=  new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			A = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void comb(int cnt, int idx) {
		if(cnt==N>>1 && A[0]==1) {
			getSum();
			return;
		}
		for(int i=idx; i<N; i++) {
			A[i]=1;
			comb(cnt+1, i+1);
			A[i]=0;
		}
	}
	private static void getSum() {
		int sumA=0, sumB=0;
		for(int i=0; i<N-1; i++) {
			if(A[i]==1) {
				for(int j=i+1; j<N; j++) {
					if(A[j]==1) {
						sumA+=arr[i][j]+arr[j][i];
					}
				}
			}
			else {
				for(int j=i+1; j<N; j++) {
					if(A[j]==0) {
						sumB+=arr[i][j]+arr[j][i];
					}
				}
			}
		}
		min = Math.min(min, Math.abs(sumA-sumB));
	}
}
