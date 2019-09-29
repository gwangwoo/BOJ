import java.io.*;
import java.util.*;

public class _boj_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		String str = br.readLine();
		str += "00";
		for(int i = 0 ; i < str.length()-2; i++) {
			char now = str.charAt(i);
			res++;
			switch(now ) {
			case 'c':
				char next = str.charAt(i+1);
				if(next == '=' || next == '-') ++i;
				break;
			case 'd':
				next = str.charAt(i+1);
				if(next =='-') ++i;
				else if(next == 'z') {
					next = str.charAt(i+2);
					if(next == '=') i+=2;
				}
				break;
			case 'l':
				next = str.charAt(i+1);
				if(next == 'j') ++i;
				break;
			case 'n':
				next = str.charAt(i+1);
				if(next == 'j') ++i;
				break;
			case 's':
				next = str.charAt(i+1);
				if(next == '=') ++i;
				break;
			case 'z':
				next = str.charAt(i+1);
				if(next == '=') ++i;
				break;
			}
		}
		System.out.println(res);

	}

}
