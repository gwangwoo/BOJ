
public class codility_Matrix2021 {
	
	static boolean check(int val, int arr[]) {
		int cnt = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] >= val) {
				cnt++;
				if(cnt == val) return true;
			}else {
				cnt = 0;
			}
		}
		return false;
	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int left = 1;
		int right = 100_000;
		int res = 0;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(check(mid, A)) {
				res = mid;
				left = mid+1;
			}else right = mid-1;
		}
		return res;
	}	
	public static void main(String[] args) {
//		int arr[] =  {6, 5, 5, 6, 2, 2};
//		int arr[] = {1, 2, 5, 3, 1, 3};
		int arr[] = {3, 3, 3, 5, 4};
		System.out.println(solution(arr));
	}
}
