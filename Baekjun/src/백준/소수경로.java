package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 소수경로 {
	public static List<Integer> getPrimeNumber() {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		Next_Number:
			for(int i = 3 ; i < 9999; i+=2 ) {
				for(int n : primes) {
					if(i % n == 0) {
						continue Next_Number;
					}
				}
				primes.add(i);
			}

		return primes;
	}

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int end = 0;
		boolean check[] = new boolean [10000];
		int dist [] = new int[10000];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> PrimeNumber = new ArrayList<>();
		PrimeNumber.addAll(getPrimeNumber());
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Arrays.fill(check, false);
			Arrays.fill(dist, 0);
			q.clear();
			check[n] = true;
			dist[n] = 0;
			q.add(n);
			while(!q.isEmpty()) {
				int now = q.poll();
				if(now == m) {
					end = dist[now];
					break;
				}
				
				for(int i = 1 ; i <= 9 ; i++) {
					int next = i*1000+(now%1000);
					if(Collections.binarySearch(PrimeNumber, next) > -1 ) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/1000)*1000 + (i*100) + (now%100);
					if(Collections.binarySearch(PrimeNumber, next) > -1 ) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/100)*100 + (i*10) + (now%10);
					if(Collections.binarySearch(PrimeNumber, next) > -1 ) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/10)*10 + i;
					if(Collections.binarySearch(PrimeNumber, next) > -1 ) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
			}
			System.out.println(end);
		}


	}
}