package SWEA.D3;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution_1208_Flatten2 {
   static int boxrange = 100;
   static int boxheight = 101;
   public static void main(String[] args) throws Exception{
      BufferedReader input = new BufferedReader(new FileReader("text_D3/Solution_1208_Flatten.txt"));
//      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
      
      for(int t=1; t<=13; t++) {
         int cntarr[] = new int[boxheight];
         int dump = Integer.parseInt(input.readLine());
         int high = 1;
         int low = 100;
         
         ArrayList<Integer> boxes = new ArrayList<Integer>();
         String testCase[] = input.readLine().split(" ");
         
         for(String s : testCase) {
        	 cntarr[Integer.parseInt(s)]++;
        	 high = Math.max(high, Integer.parseInt(s));
             low = Math.min(low, Integer.parseInt(s));
         }
         while(dump>0) {
            if(cntarr[high]>0) {
               cntarr[high]--;
               cntarr[high-1]++;
               if(cntarr[low]==1) {
                  cntarr[low+1]++;
                  low++;
               }
               else {   
                  cntarr[low]--;
                  cntarr[low+1]++;
               }
               dump--;
               if(high==low)
                  break;
            }
            else {
               high = high-1;
            }
         }
         output.write("#"+t+" "+(high-low)+"\n");
      }
      output.flush();
   }
}