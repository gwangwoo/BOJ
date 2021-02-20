public class codility_PassingCars {
    public int solution(int[] arr) {
        int N = arr.length;
        int psum[] = new int[N];
        psum[0] = arr[0];
        for(int i = 1 ; i < N ; i++) {
            psum[i] = psum[i-1] + arr[i];
        }
        int res = 0;
        for(int i = 0 ; i < N ; i++) {
            if(arr[i] == 0) {
                res += psum[N-1] - psum[i];
                if(res < 0 || res > 1_000_000_000) return -1;
            }
        }
        return res;
    }
}