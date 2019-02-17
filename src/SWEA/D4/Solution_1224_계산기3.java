//문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
//
//예를 들어
//
//“3+(4+5)*6+7”
//
//라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.
//
//"345+6*+7+"
//
//변환된 식을 계산하면 64를 얻을 수 있다.
//
//문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어갈 수 있다.
//
//이 때 괄호의 유효성 여부는 항상 옳은 경우만 주어진다.
//
//피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
//
//[입력]
//
//각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 길이가 주어진다. 그 다음 줄에 바로 테스트 케이스가 주어진다.
//
//총 10개의 테스트 케이스가 주어진다.
//
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 답을 출력한다.
package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_1224_계산기3 {
	static int T = 10;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_1224_계산기3.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		char[] arr;
		char c,top;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				c = arr[i];
				if(Character.isDigit(arr[i])) {
					sb.append(c-'0');
				}
				else if(c==')') {
					while(!stack.isEmpty() && (top=stack.pop()) !='(') {
						sb.append(top);
					}
				}
				else {
					while(!stack.isEmpty()) {
						if(postfix(stack.peek(),true)<postfix(arr[i],false)) break;
						sb.append(stack.pop());
					}
					stack.push(arr[i]);
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			int n1, n2;
			for(int i=0; i<sb.length(); i++) {
				c = sb.charAt(i);
				if(Character.isDigit(c)){
					stack2.push(c-'0');
				}
				else {
					n1 = stack2.pop();
					n2 = stack2.pop();
					switch (c) {
					case '+':
						stack2.push(n2+n1);
						break;
					case '*':
						stack2.push(n2*n1);
						break;

					default:
						break;
					}
				}
			}
			bw.write("#"+t+" "+stack2.pop()+"\n");
			stack2.clear();
		}
		bw.flush();
	}
	
	public static int postfix(char ch, boolean isInstack) {
		switch (ch) {
		case '+':
			return 1;
		case '*':
			return 2;
		default:
			return isInstack ? 0:3;
		}
	}
}
