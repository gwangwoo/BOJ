import java.io.*;
import java.util.*;

public class _boj_16958_텔레포트 {
	static int N,M,T,res;
	static int map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int visited[][] = new int[1001][1001];
	static ArrayList<Town> town;
	static ArrayList<Town> special;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];
		town = new ArrayList<>();
		special = new ArrayList<>();
		town.add(new Town((int)1e9,(int)(1e9),0));
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int statue = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = i+1;
			town.add(new Town(r,c,statue));
			if(statue == 1) {
				special.add(new Town(r,c,statue));
			}
		}

		T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			res = Math.abs(town.get(s).r - town.get(e).r) + Math.abs(town.get(s).c - town.get(e).c);
			// 둘다 텔-텔 인경우.
			if(town.get(s).statue == 1 && town.get(e).statue == 1) {
				res = Math.min(res, M);
			// 시작점만 텔인경우.
			}else if(town.get(s).statue == 1 && town.get(e).statue == 0) {
				// 끝 점과 가까운 텔 마을을 찾음.
				int MAX = Integer.MAX_VALUE;
				int index = -1;
				for(int j = 0 ; j < special.size() ; j++) {
					Town now = special.get(j);
					int val = Math.abs(town.get(e).r - now.r) + Math.abs(town.get(e).c - now.c);
					if(MAX > val) {
						MAX = val;
						index = j;
					}
				}
				int end2nearTel = Math.abs(town.get(e).r - special.get(index).r) + Math.abs(town.get(e).c - special.get(index).c);
				end2nearTel+= M;
				res = Math.min(end2nearTel, res);
			// 끝점만 텔인인경우.
			}else if(town.get(e).statue == 1 && town.get(s).statue == 0) {
				// 시작 점과 가까운 텔을 찾음.
				int MAX = Integer.MAX_VALUE;
				int index = -1;
				for(int j = 0 ; j < special.size() ; j++) {
					Town now = special.get(j);
					int val = Math.abs(town.get(s).r - now.r) + Math.abs(town.get(s).c - now.c);
					if(MAX > val) {
						MAX = val;
						index = j;
					}
				}
				int start2nearTel = Math.abs(town.get(s).r - special.get(index).r) + Math.abs(town.get(s).c - special.get(index).c);
				start2nearTel += M;
				res = Math.min(start2nearTel, res);
			// 둘다 그-그 인경우.
			}else if(town.get(s).statue == 0 && town.get(e).statue == 0) {
				// 시작점과 가까운 텔을 찾음.
				int MAX = Integer.MAX_VALUE;
				int index = -1;
				for(int j = 0 ; j < special.size() ; j++) {
					Town now = special.get(j);
					int val = Math.abs(town.get(s).r - now.r) + Math.abs(town.get(s).c - now.c);
					if(MAX > val) {
						MAX = val;
						index = j;
					}
				}
				int start2nearTel = Math.abs(town.get(s).r - special.get(index).r) + Math.abs(town.get(s).c - special.get(index).c);
				// 끝 점과 가까운 텔을 찾음.
				MAX = Integer.MAX_VALUE;
				index = -1;
				for(int j = 0 ; j < special.size() ; j++) {
					Town now = special.get(j);
					int val = Math.abs(town.get(e).r - now.r) + Math.abs(town.get(e).c - now.c);
					if(MAX > val) {
						MAX = val;
						index = j;
					}
				}
				int end2nearTel = Math.abs(town.get(e).r - special.get(index).r) + Math.abs(town.get(e).c - special.get(index).c);
				int val = start2nearTel + end2nearTel + M;
				res = Math.min(val, res);
			}
			System.out.println(res);
		}
		
	}
	static class Town {
		int r,c,statue;
		Town(int r,int c,int statue) {
			this.r = r;
			this.c = c;
			this.statue = statue;
		}
	}
}
