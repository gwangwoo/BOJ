import java.io.*;
import java.util.*;
public class _boj_1406 {
	static int N,M;
	static LinkedList<Character> editor = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char chars[] = br.readLine().toCharArray();
		N = chars.length;
		for(int i = 0 ; i < N ; i++) editor.add(chars[i]);
		ListIterator it = editor.listIterator(editor.size());
		M = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = '\0';
			char text = '\0';
			if(st.countTokens() == 2) {
				cmd = st.nextToken().charAt(0);
				text = st.nextToken().charAt(0);
				it.add(text);
			}else {
				cmd = st.nextToken().charAt(0);
				switch(cmd) {
				case 'L':
					if(!it.hasPrevious()) continue;
					it.previous();
					break;
				case 'D':
					if(!it.hasNext()) continue;
					it.next();
					break;
				case 'B':
					if(!it.hasPrevious()) continue;
					it.previous();
					it.remove();
					break;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(char s: editor) sb.append(s);
		bw.write(sb.toString());
		bw.flush();
	}
}
