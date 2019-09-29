import java.io.*;
import java.util.*;

public class _boj_1244_스위치켜고끄기 {
	static int N,M;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 남학생은 배수 전부다 리버스.
		// 여햑생은 팰린드롭 리버스.
		// 남학생은 1. 여학생은 2.
		M = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				for(int j = num ; j < N+1 ; j+=num) {
					arr[j] = arr[j] == 1 ? 0 : 1;
				}
			}else {
				arr[num] = arr[num] == 1 ? 0 : 1;
				for(int j = 1 ; j < N+1 ; j++) {
					int left = num-j;
					int right = num+j;
					if(left == 0 || right == N+1) break;
					if(arr[left] == arr[right]) {
						arr[left] = arr[left] == 1 ? 0 : 1;
						arr[right] = arr[right] == 1 ? 0 : 1;
					}else {
						break;
					}
				}
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
		
	}

}
