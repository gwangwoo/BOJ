import java.util.*;
import java.io.*;

public class _boj_11728_파일합치기 {
	static int N,M;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int brr[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
        	brr[i] = Integer.parseInt(st.nextToken());
        }
        int idx1 = 0; int idx2 = 0;
        while(true) {
        	if(idx1 == N || idx2 == M) break;
        	if(arr[idx1] == brr[idx2]) {
        		bw.write(arr[idx1++] + " " + brr[idx2++]+ " ");
        	}else if(arr[idx1] > brr[idx2]) {
        		bw.write(brr[idx2++] + " ");
        	}else {
        		bw.write(arr[idx1++] + " ");
        	}
        }
        if(idx1 < N) {
        	while(true) {
        		if(idx1 == N) break;
        		bw.write(arr[idx1++] + " ");
        	}
        }
        if(idx2 < M) {
        	while(true) {
        		if(idx2 == M) break;
        		bw.write(brr[idx2++] + " ");
        	}
        }
        bw.write("\n");
        bw.flush();
	}

}

