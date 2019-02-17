package SWEA.D5;

import java.util.Scanner;

public class MagicSqare {
	static int N, n=1, val;
	static int[][] sqare;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sqare = new int[N][N];
		
		if(N%2==1) {
			odd();
		}else if(N%4==0) {
			even();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(sqare[i][j]+"\t");
			}
			System.out.println();
		}
		if(isMagic()) {
			System.out.println(N+"*"+N+" 마방진이고, 한 행의 합은 "+val+"이고, 마방진의 총 합은 "+val*N+"입니다.");
		}
	}
	
	//마방진인지 확인하는 함수
	public static boolean isMagic() {
		int sum;
		val = N*(N*N+1)/2;
		for(int i=0; i<N; i++) {
			sum = 0;
			for(int j=0; j<N; j++) {
				sum+=sqare[i][j];
			}
			if(sum!=val)
				return false;
		}
		return true;
	}
	
	//홀수마방진
	public static void odd() {
		int i = 0;
		int j = N/2;
		while(n<=N*N) {
			sqare[i][j] = n;
			
			if(n%5==0) {
				i = i+1;
			}else {
				i = i-1;
				j = j+1;
				
				if(i<0) i = N-1;
				if(j>N-1) j = 0;
			}
			n++;
		}
	}
	
	//4의배수마방진
	public static void even() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sqare[i][j] = n++;
			}
		}
		int v = N/4;
		for(int i=0; i<v; i++) {
			for(int j=v; j<3*v; j++) {
				int temp = sqare[i][j];
				sqare[i][j] = sqare[N-1-i][N-1-j];
				sqare[N-1-i][N-1-j] = temp;
			}
		}
		for(int j=0; j<v; j++) {
			for(int i=v; i<3*v; i++) {
				int temp = sqare[i][j];
				sqare[i][j] = sqare[N-1-i][N-1-j];
				sqare[N-1-i][N-1-j] = temp;
			}
		}
	}
}
