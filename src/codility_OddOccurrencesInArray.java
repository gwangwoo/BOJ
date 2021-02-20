import java.util.Arrays;

public class codility_OddOccurrencesInArray {

	static int lowerBound(int arr[], int val) {
		int left = 0;
		int right = arr.length-1;
		int res = -1;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(arr[mid] < val) {
				left = mid+1;
			}else {
				right = mid-1;
				res = mid;
			}
		}
		return res;
	}
	
	static int upperBound(int arr[] , int val) {
		int left = 0;
		int right = arr.length-1;
		int res = -1;
		while(left <= right) {
			int mid = (left+ right) >> 1;
			if(arr[mid] <= val) {
				left = mid+1;
			}else {
				right = mid-1;
				res = mid;
			}
		}
		return res;
	}
	
	public static int solution(int[] A) {
		Arrays.sort(A);
        int N = A.length;
        int res = -1;
        for(int i = 0 ; i < N ; i++) {
        	// lowerbound;
        	int low = lowerBound(A, A[i]);
        	// upperbound;
        	int upp = upperBound(A, A[i]);
        	if((upp - low)%2 != 0) return A[i]; 
        }
        return 0;
	}
	
	public static void main(String[] args) {
		int arr[] = {9,3,9,3,9,7,9};
		System.out.println(solution(arr));
	}

}
