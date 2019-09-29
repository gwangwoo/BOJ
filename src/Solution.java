import java.io.*;
import java.util.*;
public class Solution {
    static int solution(int[] A) {
        int n = A.length;
        int flag = 0;									// here
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        System.out.println(result);
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            flag += count; 										// here
            if(n != 1 && (n-2)*-2+-2 == flag) return result-1; // here
            r = Math.max(r, count);
        }
        return result + r;
    }
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int A[] = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	System.out.println(solution(A));
    }
}