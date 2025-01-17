//삼성은행의 신입사원 정식이는 실수를 저질렀다.
//
//은행 업무가 마감되기 직전인 지금, 송금할 금액을 까먹고 말았다.
//
//하지만 다행스럽게도 정식이는 평소 금액을 2진수와 3진수의 두 가지 형태로 기억하고 다니며, 기억이 명확하지 않은 지금조차 2진수와 3진수 각각의 수에서 단 한 자리만을 잘못 기억하고 있다는 것만은 알고 있다. 
//
//예를 들어 현재 기억이 2진수 1010과 3진수 212을 말해주고 있다면 이는 14의 2진수인 1110와 14의 3진수인 112를 잘못 기억한 것이라고 추측할 수 있다.
//
//정식이는 실수를 바로잡기 위해 당신에게 부탁을 하였다.
//
//정식이가 송금액을 추측하는 프로그램을 만들어주자.
//
//( 단, 2진수와 3진수의 값은 무조건 1자리씩 틀리다.  추측할 수 없는 경우는 주어지지 않는다. )
//
//
//
//
//[입력]
//
//10개 이하의 테스트 케이스가 주어진다.
//
//첫 번째 줄에는 테스트케이스의 개수가 주어진다.
//
//하나의 케이스는 두 줄로 되어있다.
//
//각 케이스의 첫 번째 줄은 정식이가 기억하는 송금액의 2진수 표현, 두 번째 줄은 송금액의 3진수 표현이 주어진다.  
//
//(3 ≤ 2진수, 3진수의 자릿수 <40)
//
//
//[출력]
//
//원래 송금하기로 하였던 금액을 케이스마다 한 줄에 하나씩 출력한다.
package SWEA.D4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution_4366_정식이의은행업무 {
	static int T;
	static String binary, trimal;
	static Set<Long> biset;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_4366_정식이의은행업무.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder temp;
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			binary = br.readLine();
			trimal = br.readLine();
			biset = new HashSet<>();
			for(int i=0; i<binary.length(); i++) {
				temp = new StringBuilder(binary);
				if(binary.charAt(i)=='1') {
					temp.setCharAt(i, '0');
					biset.add(Long.valueOf(temp.toString(), 2));
				}else {
					temp.setCharAt(i, '1');
					biset.add(Long.valueOf(temp.toString(), 2));
				}
			}
			
			for(int i=0; i<trimal.length(); i++) {
				temp = new StringBuilder(trimal);
				if(trimal.charAt(i)=='0') {
					temp.setCharAt(i, '1');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
					temp.setCharAt(i, '2');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
				}else if(trimal.charAt(i)=='1'){
					temp.setCharAt(i, '0');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
					temp.setCharAt(i, '2');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
				}else {
					temp.setCharAt(i, '1');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
					temp.setCharAt(i, '0');
					if(biset.contains(Long.valueOf(temp.toString(),3))) {
						sb.append(Long.valueOf(temp.toString(),3)).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
