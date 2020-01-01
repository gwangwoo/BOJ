import java.io.*;
import java.util.*;
public class _boj_16675 {
	static char Ml,Mr,Tl,Tr;
	
	static boolean game(char left, char right) {
		if(left == 'S' && right == 'P') return true;
		else if(left == 'R' && right == 'S') return true;
		else if(left == 'P' && right == 'R') return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ml = st.nextToken().charAt(0);
		Mr = st.nextToken().charAt(0);
		Tl = st.nextToken().charAt(0);
		Tr = st.nextToken().charAt(0);
		
		if(game(Ml,Tl) && game(Ml,Tr)) System.out.println("MS");
		else if(game(Mr,Tl) && game(Mr,Tr)) System.out.println("MS");
		else if(game(Tl,Ml) && game(Tl,Mr)) System.out.println("TK");
		else if(game(Tr,Ml) && game(Tr,Mr)) System.out.println("TK");
		else System.out.println("?");
	}
}
