//줄기세포 배양 시뮬레이션 프로그램을 만들려고 한다.
//
//줄기세포들을 배양 용기에 도포한 후 일정 시간 동안 배양을 시킨 후 줄기 세포의 개수가 몇 개가 되는지 계산하는 시뮬레이션 프로그램을 만들어야 한다.
//
// 
//
//하나의 줄기 세포는 가로, 세로 크기가 1인 정사각형 형태로 존재하며 배양 용기는 격자 그리드로 구성되어 있으며 하나의 그리드 셀은 줄기 세포의 크기와 동일한 가로, 세로 크기가 1인 정사각형이다.
//
// 
//
//각 줄기 세포는 생명력이라는 수치를 가지고 있다.
//
//초기 상태에서 줄기 세포들은 비활성 상태이며 생명력 수치가 X인 줄기 세포의 경우 X시간 동안 비활성 상태이고 X시간이 지나는 순간 활성 상태가 된다.
//
//줄기 세포가 활성 상태가 되면 X시간 동안 살아있을 수 있으며 X시간이 지나면 세포는 죽게 된다.
//
//세포가 죽더라도 소멸되는 것은 아니고 죽은 상태로 해당 그리드 셀을 차지하게 된다.
//
// 
//
//활성화된 줄기 세포는 첫 1시간 동안 상, 하, 좌, 우 네 방향으로 동시에 번식을 한다.
//
//번식된 줄기 세포는 비활성 상태이다.
//
//하나의 그리드 셀에는 하나의 줄기 세포만 존재할 수 있기 때문에 번식하는 방향에 이미 줄기 세포가 존재하는 경우 해당 방향으로 추가적으로 번식하지 않는다.
//
//두 개 이상의 줄기 세포가 하나의 그리드 셀에 동시 번식하려고 하는 경우 생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지하게 된다.
//
// 
//
//줄기 세포의 크기에 비해 배양 용기의 크기가 매우 크기 때문에 시뮬레이션에서 배양 용기의 크기는 무한하다고 가정한다.
//
// 
//
//아래 [그림1]과 [그림2]는 줄기 세포가 번식하는 예를 나타낸다.
// 
//
// 
//
//                                                           [그림 1]
// 
//
// 
//                                           [그림 2]
//
// 
//
//줄기 세포의 초기 상태 정보와 배양 시간 K시간이 주어질 때, K시간 후 살아있는 줄기 세포(비활성 상태 + 활성 상태)의 총 개수를 구하는 프로그램을 작성하라.
//
// 
// 
//
//[제약 사항]
// 
//
//초기 상태에서 줄기 세포가 분포된 영역의 넓이는 세로 크기 N, 가로 크기 M이며 N, M은 각각 1 이상 50 이하의 정수이다. (1≤N≤50, 1≤M≤50)
//배양 시간은 K시간으로 주어지며 K는 1 이상 300 이하의 정수이다. (1≤K≤300)
//배양 용기의 크기는 무한하다. 따라서 줄기 세포가 배양 용기 가장자리에 닿아서 번식할 수 없는 경우는 없다.
//줄기 세포의 생명력 X는 1 이상 10 이하의 정수이다. (1≤X≤10)
// 
//
//[입력]
// 
//
//입력의 가장 첫 줄에는 총 테스트 케이스의 개수 T가 주어진다.
//
//그 다음 줄부터는 각 테스트 케이스가 주어지며
//
//각 테스트 케이스의 첫째 줄에는 초기 상태에서줄기 세포가 분포된 세로 크기 N, 가로 크기 M, 배양 시간 K가 순서대로 주어진다.
//
//다음 N 줄에는 각 줄마다 M개의 그리드 상태 정보가 주어진다.
//
//1~10까지의 숫자는 해당 그리드 셀에 위치한 줄기 세포의 생명력을 의미하며,
//
//0인 경우 줄기 세포가 존재하지 않는 그리드이다.
//
// 
//
//[출력]
// 
//
//테스트 케이스 T에 대한 결과는 “#T”을 찍고,
//
//배양을 K시간 시킨 후 배양 용기에 있는 살아있는 줄기 세포(비활성 상태 + 활성 상태)의 개수를 출력한다. (T는 테스트케이스의 번호를 의미하며 1부터 시작한다. )
//

package SWEA.D4;

import java.io.*;

public class Solution_5653_줄기세포배양 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_5653_줄기세포배양.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
