//SI 단위(국제단위계)는 kilo, mega, giga 등의 접두사를 사용하여 “수치 + 접두사 + 단위”라는 형태로
//
//다양한 물리량을 표기할 수 있도록 해준다.
//
//예를 들자면, “22.7 kilometers”라거나 “6.2 milligrams”같은 식이다.
//
//한편, SI 단위에서 kilo는 103을 나타내고, milli는 10-3을 나타낸다.
//
//그러므로 지수 표기법을 이용해 “2.27 × 104 meters”라거나 “6.2 × 10-3 grams” 같은 식으로도 표현할 수 있다.
//
//지수 표기법을 이용할 때는 수치가 1이상 10미만인 값이 되도록 조정해야 한다.
//
//어떤 물리량을 측정하면, 그 물리량은 반드시 오차를 포함한다.
//
//이 때, 측정된 물리량이 어느 정도의 정밀도를 가지는지를 나타내기 위해 유효숫자라는 개념이 생겼다.
//
//유효숫자를 고려한 물리량 표기에서 가장 마지막 숫자는 오차를 포함할 수 있지만,
//
//나머지 숫자는 모두 신뢰할 수 있는 것으로 생각한다.
//
//예를 들어 “1.35”로 표기한 경우 실제 값은 “1.345”이상 “1.355”미만인 값으로 생각하여
//
//소수점 이하 첫 번째 자리까지는 신뢰할 수 있지만, 두 번째 자리 부터는 오차를 포함한다고 보는 것이다.
//
//이처럼 “신뢰할 수 있는 자리수 + 오차를 포함하는 1자리 수”의 형태로 물리량을 표기할 때,
//
//나타난 숫자의 개수를 자릿수라고 부른다.
//
//예를 들어 “1.35”의 자릿수는 3자리다.
//
//0이 아닌 가장 왼쪽에 있는 수보다 더 왼쪽에 있는 0은 자릿수에 포함되면 안 된다.
//
//예를 들어 “0.063”은 2자리 수다. 반대로 0이 아닌 가장 오른쪽에 있는 수 보다
//
//오른쪽에 있는 0은 소수점의 위치에 따라 다르다.
//
//소수점보다 오른쪽에 0이 있으면 이는 자릿수에 포함된다. 예를 들어 “3.5700”은 5자리 수다.
//
//그러나 소수점이 없는 “35700”과 같은 형태의 수라면 자릿수는 3자리에서 5자리가 될 수 있어 명확하지 않지만,
//
//이 문제에서는 오른쪽에 있는 0들을 모두 자릿수에 포함하여 5자리 수로 보도록 한다.
//
//위와 같은 사실에 기초하여 SI단위의 형태로 주어진 물리량을 지수 형태로 바꿔주는 프로그램을 작성하라.
//
//이 문제에서 사용되는 접두사는 다음의 20가지이다.
//
//
//yotta = 1024
//
//zetta = 1021
//
//exa = 1018
//
//peta = 1015
//
//tera = 1012
//
//giga = 109
//
//mega = 106
//
//kilo = 103
//
//hecto = 102
//
//deca = 101
//
//deci = 10-1
//
//centi = 10-2
//
//milli = 10-3
//
//micro = 10-6
//
//nano = 10-9
//
//pico = 10-12
//
//femto = 10-15
//
//ato = 10-18
//
//zepto = 10-21
//
//yocto = 10-24
//
//
//[입력]
//
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//
//각 테스트 케이스의 첫 번째 줄에는 수치, 접두사, 단위가 공백 하나로 구분되어 주어진다.
//
//접두사가 없는 경우도 있어 수치와 단위만 공백 하나로 구분되어 주어질 수도 있다.
//
//수치는 소수로 주어지는 경우가 아니면 0으로 시작하지 않으며, 소수점을 포함해 길이가 1000이하이다.
//
//수치는 양수로 주어진다.
//
//접두사는 위에서 나열한 접두사들만 주어진다.
//
//단위는 위에서 주어진 접두사와 다르게 주어지며, 길이가 50이하이다.
//
//
//[출력]
//
//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
//
//a * 10 ^ b [단위]의 형태로 표현된 문자열을 출력한다.
//
//이는 1 ≤ a ＜ 10을 만족할 때 주어진 값을 a × 10b 로 나타낼 수 있다는 의미이며,
//
//단위는 단수, 복수형의 차이를 따지지 말고 입력에서 주어진 대로 출력해야 한다.
//
//입력에서 주어진 수치의 유효숫자를 모두 나타낼 수 있어야 한다.
package SWEA.D4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_6907_단위변환기프로그램 {
	static int T;
	static String num, prefix, unit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("text_D4/Solution_7088_은기의송아지세기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<String,Integer> map = new HashMap<>();
		map.put("yotta", 24);
		map.put("zetta", 21);
		map.put("exa", 18);
		map.put("peta", 15);
		map.put("tera", 12);
		map.put("giga", 9);
		map.put("mega", 6);
		map.put("kilo", 3);
		map.put("hecto", 2);
		map.put("deca", 1);
		map.put("deci", -1);
		map.put("centi", -2);
		map.put("milli", -3);
		map.put("micro", -6);
		map.put("nano", -9);
		map.put("pico", -12);
		map.put("femto", -15);
		map.put("ato", -18);
		map.put("zepto", -21);
		map.put("yocto", -24);
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			num = st.nextToken();
			prefix = st.nextToken();
			unit = st.nextToken();
		}
	}
}
