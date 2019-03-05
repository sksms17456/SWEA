//삼삼 트리플(Samsam-Triple)은 여러 사람이 할 수 있는 게임이다.
//
//이 게임에는 카드를 이용하는데, 카드에는 1에서 9까지의 숫자가 카드에 적혀 있고
//
//적힌 숫자의 색이 빨강(R), 초록(G), 파랑(B)중의 하나로 총 27종류의 카드를 사용한다.
//
//각 종류의 카드는 모두 4장씩 존재하여 총 108장의 카드로 게임을 진행한다.
//
//이 게임에 참가하는 사람들은 9장의 카드를 패로 가져간다.
//
//그리고, 차례를 번갈아 가면서 카드 한 장을 버린 다음 한 장을 새롭게 뽑아오는 것을 반복한다.
//
//이렇게 순서대로 차례를 진행하다가 세 장의 카드로 이루어진 세트를 3개 만든 사람이 승리한다.
//
//각 세트는 동일한 색의 카드 세 장으로 이루어져야 하며, 세 숫자가 모두 같거나, 세 숫자가 모두 연속된 숫자여야 한다.
//
//9와 1은 연속하지 않은 숫자로 생각하여 9, 1, 2가 적힌 세 카드는 한 세트가 될 수 없다.
//
//4, 5, 6가 적힌 세 카드는 한 세트가 될 수 있다.
//
//당신은 이 게임의 모바일 버전을 개발하는 일을 도와 주기로 했다.
//
//9장의 카드에 어떤 숫자가 어떤 색으로 적혀져 있는지 주어질 때
//
//승리 조건을 만족하도록 3개의 세트를 구성할 수 있는지 판별하는 프로그램을 작성해야 한다.
// 
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 길이가 9인 문자열이 주어진다.
//
//i번째 문자는 ‘1’에서 ‘9’사이 이며, i번째 카드에 적힌 숫자를 나타낸다.
//
//두번째 줄에도 길이가 9인 문자열이 주어진다.
//
//i번째 문자는 ‘R’,‘G’,’B’중 하나이며, i번째 카드에 적힌 색을 나타낸다.
//
//같은 종류의 카드가 다섯 장 이상 주어지지 않는다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//이 카드 패로 승리할 수 있으면 “Win”을 출력하고 아직 조건을 만족하지 못했다면 “Continue”를 출력한다.
package SWEA.D3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_6781_삼삼트리플게임 {
	static class Card implements Comparable<Card>{
		int num;
		char color;
		public Card(int num, char color) {
			super();
			this.num = num;
			this.color = color;
		}
		@Override
		public int compareTo(Card o) {
			if(this.color>o.color) return 1;
			else if(this.color<o.color) return -1;
			return 0;
		}		
	}
	static int T, triple;
	static int[] cnt;
	static String numline, colorline;
	static ArrayList<Card> list;
	static boolean isWin;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D3/Solution_6781_삼삼트리플게임.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			isWin=true;
			list = new ArrayList<>();
			numline = br.readLine();
			colorline = br.readLine();
			cnt = new int[10];
			triple = 0;
			
			for(int i=0; i<9; i++) {
				list.add(new Card(numline.charAt(i)-'0',colorline.charAt(i)));
			}
			Collections.sort(list);
			for(int i=0; i<7; i++) {
				if(list.get(i).color!=list.get(i+1).color || list.get(i+1).color!=list.get(i+2).color) {
					isWin=false;
					break;
				}
				cnt[list.get(i).num]++;
				cnt[list.get(i+1).num]++;
				cnt[list.get(i+2).num]++;
				
				i=i+2;
			}
			if(isWin) {
				for(int i=1; i<cnt.length-2; i++) {
					if(cnt[i]==1 && cnt[i+1]>0 && cnt[i+2]>0) {
						cnt[i]--;
						cnt[i+1]--;
						cnt[i+2]--;
						triple++;
						i--;
					}
				}
				if(triple!=3) {
					top:
					for(int i=0; i<cnt.length; i++) {
						while(cnt[i]>=3) {
							cnt[i]-=3;
							triple++;
							if(triple==3)
								break top;
						}
					}	
				}
				if(triple!=3) {
					for(int i=1; i<cnt.length-2; i++) {
						if(cnt[i]>0 && cnt[i+1]>0 && cnt[i+2]>0) {
							cnt[i]--;
							cnt[i+1]--;
							cnt[i+2]--;
							triple++;
							i--;
						}
					}
				}
				
				if(triple==3) {
					sb.append("#"+t+" Win\n");
				}else {
					sb.append("#"+t+" Continue\n");
				}
			}else {
				sb.append("#"+t+" Continue\n");
			}
		}
		System.out.println(sb);
	}
}
