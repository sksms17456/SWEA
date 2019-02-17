//4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
//
//이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
//
//예를 들어 아래와 같은 문자열은 유효하다고 판단할 수 있다.
//
//
//아래와 같은 문자열은 유효하지 않은 문자열이다. 붉은색으로 표시된 괄호의 짝을 찾을 수 없기 때문이다.
//
//
//아래 문자열은 열고 닫는 괄호의 개수는 유효하나 짝이 맞지 않는 괄호가 사용 되었기 때문에 유효하지 않다.
//
//
//[입력]
//
//각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
//
//총 10개의 테스트케이스가 주어진다.
//
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).
package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	static int T = 10;
	static int Answer;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_1218_괄호짝짓기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			int size = Integer.parseInt(br.readLine());
			Stack<Character> stk1 = new Stack<>();
			Stack<Character> stk2 = new Stack<>();
			Stack<Character> stk3 = new Stack<>();
			Stack<Character> stk4 = new Stack<>();
			
			String str = br.readLine();
			boolean isOk=true;
			for(int i=0; i<size; i++) {
				char c = str.charAt(i);
				switch (c) {
				case '(':
					stk1.push('(');
					break;
				case ')':
					if(stk1.isEmpty())
						isOk=false;
					else
						stk1.pop();
					break;
				case '{':
					stk2.push('{');
					break;
				case '}':
					if(stk2.isEmpty())
						isOk=false;
					else
						stk2.pop();
					break;
				case '[':
					stk3.push('[');
					break;
				case ']':
					if(stk3.isEmpty())
						isOk=false;
					else
						stk3.pop();
					break;
				case '<':
					stk4.push('<');
					break;
				default:
					if(stk4.isEmpty())
						isOk=false;
					else
						stk4.pop();
					break;
				}
				
			}
			if(isOk)
				Answer = 1;
			else
				Answer = 0;
			System.out.println("#"+t+" "+Answer);
		}
	}
}
