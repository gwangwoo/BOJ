import java.io.*;

public class _15894_수학은체육과목입니다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine())*4;
		bw.write(Long.toString(N));
		bw.flush();
	}
}
