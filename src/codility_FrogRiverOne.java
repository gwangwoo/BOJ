import java.util.HashMap;

public class codility_FrogRiverOne {

	public static int solution(int X, int[] A) {
		int N = A.length;
		int ans = -1;
		HashMap<Integer,Boolean> hm = new HashMap<>();
		for(int i = 1 ; i<= X ; i++) hm.put(i, true);
		
		for(int i = 0 ; i < N ; i++) {
			if(hm.containsKey(A[i])) hm.remove(A[i]);
			
			if(hm.isEmpty()) {
				return i;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,1,4,2,3,5,4};
//		int arr[] = {1};
		System.out.println(solution(5,arr));
		
	}
	
}
