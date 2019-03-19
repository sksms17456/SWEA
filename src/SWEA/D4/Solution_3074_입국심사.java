//M명의 사람이 입국심사를 받으려고 한다.
//
//입국심사대에서는 한 줄 서기를 시행하고 있다.
//
//심사대는 총 N개가 있어서 1번에서 N번 까지의 번호가 붙어있다.
//
//k번 심사대에서 입국심사관이 심사를 하는 데 걸리는 시간은 tk이고 심사가 끝나면 지연 없이 다음 사람을 심사할 수 있다.
//
//처음 모든 심사대는 비어 있고 심사를 할 준비가 되어 있다.
//
//한 심사대에서는 한 명의 사람만 심사할 수 있으며, 사람들은 비어 있는 심사대가 있으면 바로 가서 심사를 받을 수 있다고 하자.
//
//이 사람들이 모두 심사를 받기 위해 걸리는 최소한의 시간을 구하는 프로그램을 작성하라.
//
//예를 들어 6명의 사람이 심사를 받기 위해 서있고, 두 심사대가 있고 각각 심사를 위해 걸리는 시간이 7초, 10초라고 하자.
//
//가장 첫 두 사람은 즉시 심사를 받게 된다.
//
//7초가 되면 첫 번째 심사대는 비어있게 되고, 세 번째 사람이 즉시 그곳으로 이동해서 심사를 받게 된다.
//
//다음으로 10초가 되면 두 번째 심사대가 비어있게 되고, 네 번째 사람이 즉시 그곳으로 이동해서 심사를 받게 된다.
//
//이런 식으로 28초가 되면 6명의 사람이 모두 심사가 끝난다.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스마다 첫 번째 줄에 N, M(1 ≤ N ≤ 105, 1 ≤ M ≤ 109)이 공백으로 구분되어 주어진다.
//
//다음 N개의 줄의 k번째 줄에는 tk (1 ≤ tk ≤ 109)가 주어진다.
//
//
//[출력]
//
//각 테스트 케이스마다 모든 사람이 심사를 받기 위해 걸리는 시간의 최솟값을 출력한다.
//
//첫 번째 테스트케이스를 시간 순으로 좀 더 자세히 살펴보면, 아래와 같다.
//
//
//
//7초후, 왼쪽 심사대가 비어있게 되며 즉시 세 번째 사람이 들어간다.
//
//
//
//마찬가지로 10초후, 오른쪽 심사대가 비어있게 되며 네 번째 사람이 들어간다.
//
//
//
//
//14초후, 다시 왼쪽 심사대가 비며 다섯 번째 사람이 들어간다.
//
//
//
//
//20초가 되는 시점에서, 여섯 번째 사람은 당장 비어있는 10초짜리 오른쪽 심사대에 서는 것보다,
//
//1초뒤 7초짜리 심사대에 서는 것이 더 이익이므로 오른쪽 심사대에 들어가지 않는다.
//
//
//
//
//21초후, 여섯 번째 사람은 비어있는 왼쪽 심사대에 들어간다.
//
//
//
//결국, 28초안에 모든 사람의 심사가 끝나게 된다.
//

package SWEA.D4;

import java.io.*;

public class Solution_3074_입국심사 {
    public static long n,m, minT;
    public static long[] arr;
    public static String[] line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3074_입국심사.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int tc = Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=tc;t++) {
            minT = Long.MAX_VALUE;
            line = br.readLine().trim().split(" ");
            n = Long.parseLong(line[0]);
            m = Long.parseLong(line[1]);
            arr = new long[(int)n];
            for(int i=0;i<n;i++) {
                arr[i] = Long.parseLong(br.readLine().trim());
                minT = Math.min(arr[i], minT);
            }
            
            long s = 1;
            long e = minT * m;
            while(s<=e) {
                long mid = (s+e)/2;
                long tempM = 0;
                for(long dt : arr) {
                    tempM += (mid / dt);
                }
                if(tempM < m) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
            System.out.println("#"+t+" "+s);
        }
	}
}
