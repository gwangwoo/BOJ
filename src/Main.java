import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
public class Main {
   static int N;
   static int[] input = new int[10001];
   static Scanner sc = new Scanner(System.in);
   static int[] arr = { 1, 2, 3 };
   static Vector<Integer> v=new Vector<>();
   
   static boolean scope(int a) {
      return a >= 0 && a < N;
   }
   static void wider(int me, int up, int down, int cnt,int num) {
      if(cnt>=4) {
         //위아래 범위 가능 + 위아래가 me와 다르지만 + 위아래끼리 같은 경우 => 연속 팡!
         if((scope(up) && scope(down))&&(input[up]!=me&&input[down]!=me)&&input[up]==input[down]) {
            wider(input[up],up-1,down+1,2,num+cnt);
         }
         //범위 나간경우||위 확장X+아래값 다른 경우|| 아래확장X+위값 다른경우 ||위아래 가능+위아래가 me랑 달라+위아래끼리도 달라 => stop
         else if((!scope(up) && !scope(down))||(!scope(up)&&input[down]!=me)||(!scope(down)&&input[up]!=me)||((scope(up) && scope(down))&&(input[up]!=me&&input[down]!=me)&&input[up]!=input[down])){
            v.add(cnt+num);
            return;
         }
      }
      if(num>=1) {
         if((!scope(up) && !scope(down))||(!scope(up)&&input[down]!=me)||(!scope(down)&&input[up]!=me)||((scope(up) && scope(down))&&(input[up]!=me&&input[down]!=me)&&input[up]!=input[down])){
            v.add(num);
            return;
         }
      }
      if((scope(up) && scope(down))&&(input[up]!=me&&input[down]!=me)) {
         //System.out.println("위아래 다 달라");
         return;
      }
      if (scope(up) && !scope(down)) {
         //위로 가능
         if (input[up] == me) {
            wider(me, up - 1, down, cnt + 1,num);
         }
      } else if (scope(down) && !scope(up)) {
         // 아래로 가능
         if (input[down] == me) {
            wider(me, up, down + 1, cnt + 1,num);
         }
      } else if (scope(up) && scope(down)) {
         // 위 아래 확장 가능
         if (input[up] == me&&input[down] != me) {
            wider(me, up - 1, down, cnt + 1,num);
         }
         else if (input[down] == me&&input[up] != me) {
            wider(me, up, down + 1, cnt + 1,num);
         }
         else if (input[up] == me && input[down] == me) {
            wider(me, up - 1, down + 1, cnt + 2,num);
         }
      }
   }
   static void pang() {
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < arr.length; j++) {
            wider(arr[j], i - 1, i + 1, 1,0);
         }
      }
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      N = sc.nextInt();
      for (int i = 0; i < N; i++) {
         int tmp = sc.nextInt(); // 문자 하나 입력받기
         input[i] = tmp;
      }
      if(N<4) {
         System.out.println(N);
         return;
      }
      pang();
      
      if(v.size()==0) {
         System.out.println(N);
         return;
      }
      
      int resul=v.get(0);
      for (int i = 0; i < v.size(); i++) {
         if(resul<v.get(i)) resul=v.get(i);
      }
      System.out.println(N-resul);
   }
}