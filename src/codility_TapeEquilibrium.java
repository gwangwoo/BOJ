
public class codility_TapeEquilibrium {

	public static int solution(int[] A) {
        int N = A.length;
        int psum[] = new int[N];
        psum[0] = A[0];
        for(int i = 1 ; i < N ; i++) {
            psum[i] = psum[i-1] + A[i];
        }
        int min = (int)1e9;
        for(int i = 0 ; i < N-1 ; i++) {
            int left =  psum[i];
            int right = psum[N-1] - psum[i];
            min = Math.min(min,Math.abs(left-right));
        }
        return min;  
    }
	
	public static void main(String[] args) {
		int arr[] = {-1000,1000};
		System.out.println(solution(arr));
	}
	
}
