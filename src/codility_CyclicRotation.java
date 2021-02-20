
public class codility_CyclicRotation {

	public static void last2first(int arr[]) {
		int last = arr[arr.length-1];
		int N = arr.length-1;
		for(int i = N ; i > 0 ; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = last;
		return;
	}
	
	public static int[] solution(int[] A, int K) {
        int res[] = A.clone();
        int N = res.length;
        if(N == K) return A;
		int num = K % N;
		
		for(int i = 0 ; i < num ; i++) last2first(res);
		return res;
    }
	
	public static void main(String[] args) {
		int arr[] = {3, 8, 9, 7, 6};
		int res[] = (solution(arr,0));
		
		System.out.println(3/0);
		for(int i = 0 ; i <res.length ; i++) System.out.print(res[i] + " ");
		System.out.println();
	}
	
	

}
