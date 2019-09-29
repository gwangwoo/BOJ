import java.io.*;
import java.util.*;

public class _boj_16939_2x2x2큐브 {
	static int map[] = new int[25];	
	static int tmp[] = new int[25];
	
	static void init() {
		for(int i = 1 ; i <= 24 ; i++) tmp[i] = map[i];
	}

	static void TR() {
		tmp[13] = map[5];
		tmp[14] = map[6];
		tmp[5] = map[17];
		tmp[6] = map[18];
		tmp[17] = map[21];
		tmp[18] = map[22];
		tmp[21] = map[13];
		tmp[22] = map[14];
		check(tmp);
	}
	static void TL() {
		tmp[13] = map[21];
		tmp[14] = map[22];
		tmp[5] = map[13];
		tmp[6] = map[14];
		tmp[17] = map[5];
		tmp[18] = map[6];
		tmp[21] = map[17];
		tmp[22] = map[18];
		check(tmp);
	}
	static void BR() {
		tmp[15] = map[7];
		tmp[16] = map[8];
		tmp[7] = map[19];
		tmp[8] = map[20];
		tmp[19] = map[23];
		tmp[20] = map[24];
		tmp[23] = map[15];
		tmp[24] = map[16];
		check(tmp);
	}
	static void BL() {
		tmp[15] = map[23];
		tmp[16] = map[24];
		tmp[7] = map[15];
		tmp[8] = map[16];
		tmp[19] = map[7];
		tmp[20] = map[8];
		tmp[23] = map[19];
		tmp[24] = map[20];
		check(tmp);
	}
	static void LD() {
		tmp[24] = map[1];
		tmp[22] = map[3];
		tmp[1] = map[5];
		tmp[3] = map[7];
		tmp[5] = map[9];
		tmp[7] = map[11];
		tmp[9] = map[24];
		tmp[11] = map[22];
		check(tmp);
	}
	static void LU() {
		tmp[24] = map[9];
		tmp[22] = map[11];
		tmp[1] = map[24];
		tmp[3] = map[22];
		tmp[5] = map[1];
		tmp[7] = map[3];
		tmp[9] = map[5];
		tmp[11] = map[7];
		check(tmp);
	}
	static void RD() {
		tmp[23] = map[2];
		tmp[21] = map[4];
		tmp[2] = map[6];
		tmp[4] = map[8];
		tmp[6] = map[10];
		tmp[8] = map[12];
		tmp[10] = map[23];
		tmp[12] = map[21];
		check(tmp);
	}
	static void RU() {
		tmp[23] = map[10];
		tmp[21] = map[12];
		tmp[2] = map[23];
		tmp[4] = map[21];
		tmp[6] = map[2];
		tmp[8] = map[4];
		tmp[10] = map[6];
		tmp[12] = map[8];
		check(tmp);
	}
	static void FL() {
		tmp[20] = map[11];
		tmp[18] = map[12];
		tmp[2] = map[20];
		tmp[1] = map[18];
		tmp[13] = map[2];
		tmp[15] = map[1];
		tmp[11] = map[13];
		tmp[12] = map[15];
		check(tmp);
	}
	static void FR() {
		tmp[20] = map[2];
		tmp[18] = map[1];
		tmp[2] = map[13];
		tmp[1] = map[15];
		tmp[13] = map[11];
		tmp[15] = map[12];
		tmp[11] = map[20];
		tmp[12] = map[18];
		check(tmp);
	}
	static void BBL() {
		tmp[19] = map[9];
		tmp[17] = map[10];
		tmp[4] = map[19];
		tmp[3] = map[17];
		tmp[14] = map[4];
		tmp[16] = map[3];
		tmp[9] = map[14];
		tmp[10] = map[16];
		check(tmp);
	}
	static void BBR() {
		tmp[19] = map[4];
		tmp[17] = map[3];
		tmp[4] = map[14];
		tmp[3] = map[16];
		tmp[14] = map[9];
		tmp[16] = map[10];
		tmp[9] = map[19];
		tmp[10] = map[17];
		check(tmp);
	}
	static boolean check(int arr[]) {
		for(int i = 1 ; i <= 3 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		for(int i = 5 ; i <= 7 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		for(int i = 9 ; i <= 11 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		for(int i = 13 ; i <= 15 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		for(int i = 17 ; i <= 19 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		for(int i = 21 ; i <= 23 ; i++) {
			if(arr[i] != arr[i+1]) return false;
		}
		System.out.println(1);
		System.exit(0);
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <=  24 ; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		TR();
		init();
		TL();
		init();
		BR();
		init();
		BL();
		init();
		LD();
		init();
		LU();
		init();
		RD();
		init();
		RU();
		init();
		FL();
		init();
		FR();
		init();
		BBL();
		init();
		BBR();
		System.out.println(0);
	}
}
