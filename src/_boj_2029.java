import java.io.*;
import java.util.*;

public class _boj_2029 {
    static final int N = 10;
    static char map[][] = new char[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        //   위	  좌		아래	  우
        // (0,1) (1,0) (3,1) (1,3)
        // (0,4) (1,3) (3,4) (1,6)
        // (0,7) (1,6) (3,7) (1,9)

        // (3,1) (4,0) (6,1) (4,3)
        int cnt1 = 0;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (map[i * 3][1 + (j * 3)] == '-' && map[1 + (i * 3)][j * 3] == '|' && map[3 + (i * 3)][1 + j * 3] == '-' && map[1 + (i * 3)][3 + (j * 3)] == '|') cnt1++;
        // (0,1) (0,4) | (1,0) (4,0) | (6,1) (6,4) | (1,6) (4,6)
        // (0,4) (0,7) | (1,3) (4,3) | (6,4) (6,7) | (1,9) (4,9)
		// (3,1) (3,4) | (4,0) (7,0) | (9,1) (9,4) | (4,6) (7,9)
        int cnt2 = 0;
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < 2; j++) {
				if (map[i * 3][1 + j * 3] != '-' || map[i * 3][4 + j * 3] != '-') continue;
				if (map[1 + i * 3][j * 3] != '|' || map[4 + i * 3][j * 3] != '|') continue;
				if (map[6 + i * 3][1 + j * 3] != '-' || map[6 + i * 3][4 + j * 3] != '-') continue;
				if (map[1 + i * 3][6 + j * 3] != '|' || map[4 + i * 3][6 + j * 3] != '|') continue;
				cnt2++;
		}
	}

        // (0,1) (0,4) (0,7)
	int cnt3 = 1;
        if(map[0][1] == '.' || map[0][4] == '.' || map[0][7] == '.') cnt3 = 0;
		if(map[1][0] == '.' || map[4][0] == '.' || map[7][0] == '.') cnt3 = 0;
		if(map[9][1] == '.' || map[9][4] == '.' || map[9][7] == '.') cnt3 = 0;
		if(map[1][9] == '.' || map[4][9] == '.' || map[7][9] == '.') cnt3 = 0;

		int total = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i * 3][1 + (j * 3)] == '-') total++;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[1 + (i * 3)][j * 3] == '|') total++;
			}
		}
		System.out.println((24-total) +" " + (cnt1+cnt2+cnt3));



    }
}
