import java.io.*;
import java.util.*;

public class _boj_17390 {
	static final int MAX = 300001;
	static int arr[];
	static int seg[] = new int[MAX*4];
	static int N,M;
	
	static int query(int low, int hi, int node, int x, int y) {
		if(low > y || hi < x) return 0;
		if(low <= x && y <= hi) return seg[node];
		int mid = (x+y) / 2;
		int l = query(low,hi,node*2,x,mid);
		int r = query(low,hi,node*2+1,mid+1,y);
		return l+r;
	}
	
	static void init(int node, int x, int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x+y)/2;
		init(node*2,x,mid);
		init(node*2+1,mid+1,y);
		seg[node] = seg[node*2] + seg[node*2+1];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		arr[0] = -1;
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		init(1,1,N);
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			bw.write(query(l,r,1,1,N)+"\n");
		}
		bw.flush();
	}
}