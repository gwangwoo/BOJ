package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 비트마스크 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = 0;
		int T = br.read(); 	// 연산의 수
		int x = 0;
		while(T-- != 0) {
			String str = sc.next();
			if(str.equals("add")) {
				x = br.read(); x--;
				S = (S | (1 << x));
			} else if (str.equals("remove")) {
				x = br.read(); x--;
				S = (S & ~(1<<x));
			} else if(str.equals("check")) {
				x = br.read(); x--;
				int res = (S & (1 << x));
				if(res == 0) {
					bw.write(0);
				}else {
					bw.write(1);
				}
			} else if(str.equals("toggle")) {
				x = br.read(); x--;
				S = (S ^ (1 << x));
			} else if(str.equals("all")) {
				S = ((1<<20) - 1);
			} else if(str.equals("empty")) {
				S = 0;
			}
		}
	}

}
