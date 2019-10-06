import java.io.*;
import java.util.*;
public class _boj_1085 {
	static int x,y,w,h;
	//색깔왜안돼.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int x_res = Math.min(Math.abs(x-0), Math.abs(w-x));
		int y_res = Math.min(Math.abs(y-0), Math.abs(h-y));
		System.out.println(Math.min(x_res, y_res));
	}
}