import java.io.*;
import java.util.*;

public class _boj_10101 {
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());

		if (A == B && B == C && C == 60) {
			System.out.println("Equilateral");
			return;
		} else if (A + B + C == 180 && (A == B || B == C || C == A)) {
			System.out.println("Isosceles");
			return;
		} else if (A + B + C == 180 && (A != B && B != C && C != A)) {
			System.out.println("Scalene");
			return;
		} else System.out.println("Error");

	}

}
