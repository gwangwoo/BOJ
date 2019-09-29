import java.util.*;
import java.io.*;

public class _boj_9656_돌게임2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int val = (int)(N % 5l);
		switch(val) {
		case 2:
			System.out.println("SK");
			break;
		case 4:
			System.out.println("SK");
			break;
		default:
			System.out.println("CY");
			break;
		}
		
	}

}
