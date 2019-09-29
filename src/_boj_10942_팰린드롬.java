import java.io.*;
import java.util.*;

public class _boj_10942_팰린드롬 {
	static int N,M;
	static int arr[];
	
	static boolean isPalin(int u,int v) {
		while(true) {
			if(u == v) break;
			if(arr[u] == arr[v]) {
				u++;
				v--;
				if(u > N || v == 0) return true;
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		while(M-- >0) {
			st = new StringTokenizer(br.readLine());
			int uu = Integer.parseInt(st.nextToken());
			int vv = Integer.parseInt(st.nextToken());
			int u, v;
			if(uu < vv) {
				u = uu;
				v = vv;
			}else {
				v = uu;
				u = vv;
			}
			if(isPalin(u,v)) {
				bw.write("1\n");
			}else bw.write("0\n");
			bw.flush();
		}
	}

}
