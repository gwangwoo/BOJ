import java.io.*;
import java.util.*;
public class _swea_1230 {
	static ArrayList<Integer> arl = new ArrayList<>();
	static int N,M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int tc = 1 ; tc <= 1 ; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) arl.add(Integer.parseInt(st.nextToken()));
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				char cmd = st.nextToken().charAt(0);
				switch(cmd) {
				case 'I':
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0 ; j < y ; j++) arl.add(x++, Integer.parseInt(st.nextToken()));
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j = 0 ; j < y ; j++) arl.remove(++x);
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for(int j = 0 ; j < y ; j++) arl.add(Integer.parseInt(st.nextToken()));
					break;
				}
			}
			bw.write("#"+tc+ " ");
			for(int i = 0 ; i < 10 ; i++) bw.write(arl.get(i)+ " ");
			bw.write("\n");
			bw.flush();
			arl.clear();
		}
	}

}
