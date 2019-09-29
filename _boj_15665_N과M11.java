import java.io.*;
import java.util.*;

public class _boj_15665_N과M11 {
	static int N,M;
	static int arr[];
	static void dfs(int index , String str) throws IOException {
		if(index == M) {
			bw.write(str+ "\n");
			return;
		}

		for(int i = 0 ; i < N ; i++) {
			dfs(index+1, str+arr[i]+" " );
		}
	}

static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(br.readLine());
	HashSet<Integer> hs = new HashSet<>();
	for(int i = 0 ; i < N ; i++) {
		hs.add(Integer.parseInt(st.nextToken()));
	}
	ArrayList<Integer> arl = new ArrayList<>(hs);
	arr = new int[arl.size()];
	for(int i = 0 ; i < arl.size() ; i++) {
		arr[i] = arl.get(i);
	}
	N = arr.length;
	Arrays.sort(arr);
	dfs(0,"");
	bw.flush();
}

}
