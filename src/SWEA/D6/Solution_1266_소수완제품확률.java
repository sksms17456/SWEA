//가구를 만드는 공장이 있다.
//
//숙련된 가구 장인은 혼자서 하나의 가구를 5분에 만들어낸다.
//
//그러나 가구를 만들어도 결함이 있을 수 있으며, 결함이 없는 가구를 완제품이라고 한다.
//
//사장은 두 명의 가구 장인을 시합을 시켰다.
//
//그런데 사장은 두 가구 장인이 만들어 내는 완제품의 수가 최소 한 명이라도 소수일 확률이 궁금해졌다.
//
//가구 장인 A, B가 있을 때 평소 각 장인의 5분 안에 완제품을 만들 확률이 주어진다.
//
//skillOfMasterA는 A장인이 5분 안에 완제품을 만들 확률이며 skillOfMasterB는 B장인이 5분 안에 완제품을 만들 확률이다.
//
//주어진 시간은 90분이며, 각 가구 장인은 5분 안에 최대 1개의 완제품을 만들 수 있다고 가정한다.
//
//두 가구 장인이 만든 완제품의 수가 최소 한 명이라도 소수일 확률을 구하는 프로그램을 작성하시오.
// 
//
//
//
//예를 들어 skillOfMasterA의 확률이 100%이고 skillOfMasterB의 확률이 100%일 경우
//
//최종적으로 A가 18개, B가 18개의 완제품을 만들어 내고 18은 소수가 아니기 때문에 소수일 확률은 0.0이다.
//
//[제약 사항]
//
//skillOfMasterA와 skillOfMasteB은 5분 안에 완제품을 만들 확률이며 값의 범위는 0 <= skillOfMasterA, skillOfMasteB <=100으로 주어진다.
//
//[입력]
//
//맨 위의 줄에는 전체 테스트 케이스의 수 T가 주어진다.
//
//그 다음 줄부터 T개의 테스트 케이스가 주어진다.
//
//각 테스트 케이스는 한 줄에 주어지며, 0 <= skillOfMasterA <=100인 정수 값이 주어지고 공백을 하나 둔 다음 0 <= skillOfMasteB <=100인 정수 값이 주어진다.
//
//[출력]
//
//총 T줄에 T개의 테스트 케이스 각각에 대한 답을 한 줄에 출력한다.
//
//각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음, 각 테스트 케이스에 주어진 skillOfMasterA, skillOfMasteB의 값을 이용하여 완제품이 최소 한 명이라도 소수일 확률을 출력한다.
//
//확률의 출력이 소수점 이하 6자리를 넘어가면 소수점 7번 자리에서 반올림한다.

package SWEA.D6;

import java.io.*;

public class Solution_1266_소수완제품확률 {
    static int T, sum;
    static int[] Comb = new int[19];
    static int[] Arr = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
    static double A, B, a, b;
    static String[] line;
     
    public static void comb(int[] arr) {
        arr[0] = 1;
        for(int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1]*(arr.length-i)/i;
        }
    }
    public static void solve() {
        a = 0;
        b = 0;
        for(int i=0; i<Arr.length; i++) {
            a += Comb[Arr[i]]*Math.pow(A, Arr[i])*Math.pow(1-A, 18-Arr[i]);
            b += Comb[Arr[i]]*Math.pow(B, Arr[i])*Math.pow(1-B, 18-Arr[i]);
        }
    }
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new FileReader("text_D6/Solution_1266_소수완제품확률.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        comb(Comb);
         
        T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            line = br.readLine().split(" ");
            A = Double.parseDouble(line[0])/100;
            B = Double.parseDouble(line[1])/100;
             
            solve();
             
            sb.append("#"+t+" "+String.format("%6f", 1-a*b)+"\n");
        }
        System.out.println(sb);
    }
}