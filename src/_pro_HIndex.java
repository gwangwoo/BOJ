import java.io.*;
import java.util.*;

public class _pro_HIndex {
	public static int solution(int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		int n = arr.length;
		int left = 0;
		int right = 10000;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int cnt = 0;
			for(int i = 0 ; i < n ; i++) {
				if(arr[i] >= mid) cnt++;
			}
			if(cnt >= mid) {
				answer = mid;
				left = mid+1;
			}else right = mid-1;
		}
		return answer;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 5 ,6, 7 };
		System.out.println(solution(arr));
	}

}
