import java.util.*;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []type = new int[N];
		for(int i = 0; i < N ; i++) {
			type[i] = sc.nextInt();
		}
		int arr[] = new int[51];
		// counting sort
		for(int i = 0 ; i < type.length ; i++) {
			arr[type[i]]++;
		}
		int ans = 0;
		int val = 1;
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i] == 0) break;
			ans += arr[i] * val;
			val *= arr[i];
		}
		System.out.println(ans);
		
	}

}
