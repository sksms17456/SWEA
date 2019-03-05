//숫자 만들기 게임    
//                                                                        
//숫자  게임을 만들려고 한다. 숫자 게임은 임의의 수 하나로 시작 한다. 이 수를 시작수라 한다.                                
//1. 시작 수는 자연수 1이상 99999이하의 수이다.                                                        
//2. 시작 수의 사이를 터치하면 수는 두개 또는 그 이상으로 쪼개진다.                                               
//3. 쪼개진 수를 모두 곱한다.                                                                     
//4. 곱한 수가 10이상이면 2~3번을 반복한다.                                                           
//5. 한번 쪼개지면 turn 수가 증가 한다.                                                             
//6. 최대 턴수가 나오도록 한다.                                                                    
//                                                                                      
//예를들어 시작 수 123인 경우  3가지로 쪼개지는 경우가 나온다.                                                 
//첫번째는 123의 수를  1과 23 사이를 터치하면  1,23 두 수로 쪼개지고 두수를 곱하면  23이 되고                          
//23사이를 또 터치하면 2와 3이 되서 두수를  곱한수 6은 더이상 쪼개질 수 없어 턴은 2번이 된다.                             
//123: 1, 23 => 23 :2 3 =>6            2번                                               
//같은 방식으로                                                                               
//두번째 경우 123: 12, 3 => 36 :3 6 =>18:1 8 => 8     3번                                       
//세번째 경우 123: 1 2 3 => 6                         1번                                       
//위 경우 중 최대의 turn 수는 3번이므로 답은 3이된다.                                                     
//                                                                                      
//[입력 형식]                                                                               
//첫줄은 테스트 케이스                                                                           
//두번째줄 부터 테스트 케이스개의 시작수가 입력된다.                                                          
//                                                                                      
//[출력 형식]                                                                               
//#테스트케이스  턴수                                                           

package SWEA.D5;

import java.io.*;

public class Solution_7206_숫자게임 {
	static int T, N, ans, cnt;
	static String line;
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("text_D5/Solution_7206_숫자게임.txt"));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			cnt=0;
			line = br.readLine();
			
			
			
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
