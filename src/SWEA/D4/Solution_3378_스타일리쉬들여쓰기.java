//스타일리쉬는 프그래밍 언어의 일종으로 이 언어의 문법은 알파벳, 세 종류의 괄호 문자, 온점(‘.’) 그리고 개행으로 이루어져 있다.
//
//괄호는 소괄호 ( ‘(‘와 ‘)’ ), 중괄호 ( ‘{‘와 ‘}’ ) 그리고 대괄호 ( ‘[’와 ‘]’ )로 이루어져 있고 서로 짝이 잘 맞도록 써야 한다. (일반적인 언어에서의 괄호를 사용하는 법과 같다.)
//
//스타일리쉬는 다른 언어들과는 다르게 공백을 사용하지 않고 온점를 이용해 들여쓰기를 표현한다.
//
//당신은 스타일리쉬 언어를 마스터한 사람들을 방문하여 효과적인 들여쓰기 방법을 배우고자 한다.
//
//들여쓰기가 잘 된 스타일리쉬 코드는 각 괄호가 등장한 횟수에 따라 들여쓰기를 하는 정도가 달라지게 되는데,
//
//1 ≤ R, C, S ≤ 20을 만족하는 세 정수 R, C, S에 대해 이전 줄에서 소괄호가 짝이 맞지 않는 개수만큼 R번씩,
//
//중괄호가 짝이 맞지 않는 개수만큼 C번씩,
//
//대괄호가 짝이 맞지 않는 개수만큼 S번씩을 들여쓰기 했다면 들여쓰기가 잘 되었다고 한다.
//
//정확하게 표현하자면 각 줄에 대해 그 줄 이전까지 등장한 ‘(‘의 개수를 a, ‘)’의 개수를 b, ‘{‘의 개수를 c, ‘}’의 개수를 d, ‘[‘의 개수를 e, ‘]’의 개수를 f라고 하면 그 줄을 들여쓰기 해야 하는 칸 수는
//
//R(a – b) + C(c – d) + S(e – f)
//
//가 된다.
//
//아래는 스타일리쉬로 작성한 프로그램의 예이다.
// 
//(Welcome.to
//.........Stylish)
//{Stylish.is
//.....[.(a.programming.language.fun.to.learn)
//.......]
//.....Maybe.[
//.......It.will.be.an.official.SAMSUNG.language
//.......]
//.....}
//위의 예는 (R, C, S)=(9, 5, 2)인 예로, 온점으로 들여쓰기를 표현한 스타일리쉬 코드이다.
//
//들여쓰기가 된 양은 각 행의 처음에 온점이 연속해서 등장한 개수이다.
//
//예를 들면 위의 소스코드에서는 각 줄마다 순서대로 0, 9, 0, 5, 7, 5, 7, 7, 5만큼씩 들여쓰기가 되어있다.
//
//첫 번째 줄에 ‘(‘가 하나 등장하기 때문에 두 번째 줄의 들여쓰기 된 횟수는 9(1 - 0) + 5(0 - 0) + 2(0 - 0) = 9가 된다.
//
//첫 번째 줄에서 네 번째 줄 까지는 ‘(‘가 둘, ‘)’가 둘, ‘{‘가 하나, ‘[‘가 하나 등장하기 때문에 다섯 번째 줄의 들여쓰기 된 횟수는 9(2 - 2) + 5(1 - 0) + 2(1 - 0) = 7가 된다.
//
//스타일리쉬를 마스터한 사람들은 당신에게 그저 잘 들여쓰기 된 코드를 보여주기만 하였다.
//
//마스터마다 들여쓰기를 하는 방법도 제각각 이었다.
//
//이들의 코드를 모방하여 당신의 코드를 들여쓰기 하려면 각 줄마다 몇 번씩을 들여쓰기 해야 하는지 구하는 프로그램을 작성하라.
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 두 자연수 p, q(1 ≤ p, q ≤ 10)가 주어진다.
//
//p는 스타일리쉬를 마스터한 사람의 코드 줄 수이고, q는 당신 코드의 줄 수이다.
//
//다음 p줄 만큼 잘 들여쓰기된 스타일리쉬 코드가 주어진다.
//
//다음 q줄 만큼 당신의 스타일리쉬 코드가 주어진다.
//
//코드의 각 줄은 최대 80자로 이루어져 있으며, 당신의 코드는 들여쓰기가 되어있지 않다.
//
//
//[출력]
//
//각 테스트 케이스마다 스타일리쉬 마스터의 들여쓰기 방식을 당신의 코드에 적용했을 때, 각 줄마다 들여쓰기를 몇 번 해야 하는지 정수로 출력한다.
//
//이 때 각 정수는 공백으로 구분한다.
//
//마스터가 몇 번 들여쓰기를 하는지 정확하지 않아서 자신의 코드도 몇 번 들여쓰기를 해야 하는지 유일하게 결정되지 않는다면 -1을 출력한다.
//

package SWEA.D4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기 {
	static int T, p, q;
	static int[][] master, mine;
	static boolean[][][] table;
	static boolean isSpaceEnd;
	static String line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_3378_스타일리쉬들여쓰기.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            master = new int[p][4];
            for(int i=0;i<p;i++){
                tableInit();                 
                line = br.readLine().trim();
                isSpaceEnd = false;
                for(int j=0;j<line.length();j++){
                    switch(line.charAt(j)){
                    case '(' :
                    	master[i][0] ++;
                        isSpaceEnd=true;
                        break;
                    case ')':
                    	master[i][0]--;
                        isSpaceEnd=true;
                        break;
                    case '{':
                    	master[i][1]++;
                        isSpaceEnd=true;
                        break;
                    case '}':
                    	master[i][1]--;
                        isSpaceEnd=true;
                        break;
                    case '[':
                    	master[i][2]++;
                        isSpaceEnd=true;
                        break;
                    case ']':
                    	master[i][2]--;
                        isSpaceEnd=true;
                        break;
                    case '.':
                        if(!isSpaceEnd){
                        	master[i-1][3]++;
                        }
                        break;
                    default:
                        isSpaceEnd=true;
                        break;
                    }
                }
                if(i+1<p){
                	master[i+1][0] = master[i][0];
                	master[i+1][1] = master[i][1];
                	master[i+1][2] = master[i][2];
                }
            }
            for(int i=0;i<p-1;i++){
                setTable(master[i][0], master[i][1], master[i][2], master[i][3]);
            }
            
            mine = new int[q][3];
            for(int i=0;i<q;i++){
            	line = br.readLine().trim();
                for(int j=0;j<line.length();j++){
                    switch(line.charAt(j)){
                    case '(' :
                    	mine[i][0] ++;
                        break;
                    case ')':
                    	mine[i][0]--;
                        break;
                    case '{':
                    	mine[i][1]++;
                        break;
                    case '}':
                    	mine[i][1]--;
                        break;
                    case '[':
                    	mine[i][2]++;
                        break;
                    case ']':
                    	mine[i][2]--;
                        break;
                    default:
                        break;
                    }
                }
                if(i+1<q){
                	mine[i+1][0] = mine[i][0];
                	mine[i+1][1] = mine[i][1];
                	mine[i+1][2] = mine[i][2];
                }
            }
            sb.append('#').append(tc).append(' ').append(0).append(' ');
            for(int i=0;i<q-1;i++){
                sb.append(getValue(mine[i][0], mine[i][1], mine[i][2])).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
     
    static void tableInit(){
        table = new boolean[21][21][21];
        for(int s=1;s<=20;s++){
            for(int m=1;m<=20;m++){
                for(int l=1;l<=20;l++){
                    table[s][m][l]=true;
                }
            }
        }
    }
     
    static void setTable(int small,int medium,int large,int value){
        for(int s=1;s<=20;s++){
            for(int m=1;m<=20;m++){
                for(int l=1;l<=20;l++){
                    if(!table[s][m][l]){
                        continue;
                    }
                    if(s*small+m*medium+l*large!=value){
                        table[s][m][l]=false;
                    }
                }
            }
        }
    }
     
    static int getValue(int small,int medium,int large){
        int getVal = -1;
        for(int s=1;s<=20;s++){
            for(int m=1;m<=20;m++){
                for(int l=1;l<=20;l++){
                    if(!table[s][m][l]){
                        continue;
                    }
                    int tempval = s*small+m*medium+l*large;
                    if(getVal==-1){
                        getVal=tempval;
                    }
                    else if(getVal!=tempval){
                        return -1;
                    }
                }
            }
        }
        return getVal;
    }
 
}