import java.util.*;

public class codility_PermMissingElem {
	public static int solution(int[] A) {
		if(A.length == 0) return 1;
        Arrays.sort(A);
        int res = -1;
        int N = A.length;
        for(int i = 0 ; i < N ; i++) {
            if(i+1 == A[i]) continue;
            res = i+1;
            break;
        }
        if(res == -1) res = A[N-1]+1;
        return res;
    }
	public static void main(String[] args) {
		int arr[] = new int[100_000];
		for(int i = 0 ; i < 100_000 ; i++) arr[i] = i+1;
//		int arr[] = new int[1];
		System.out.println(solution(arr));
	}
	
}
