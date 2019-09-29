import java.io.*;
import java.util.*;

public class _boj_16434_드래곤앤던전 {
	static long N,M;
	static H stage[];
	
	static boolean isPossible(long HP) {
		long hp = HP;
		long atk = M;
		
		for(int i = 0 ; i < stage.length ; i++) {
			if(stage[i].command == 1) {
				long target_atk = stage[i].atk;
				long target_hp = stage[i].hp;
				long damage = 0l;
				if(target_hp % atk == 0) {
					damage = target_hp / atk -1;
				}else damage = target_hp / atk;
				
				damage *= target_atk;
				hp -= damage;
				if(hp <= 0) {
					return false;
				}
			}else {
				long atk_up = stage[i].atk;
				long hp_up = stage[i].hp;
				
				atk += atk_up;
				hp = Math.min(HP, hp + hp_up);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		stage = new H[(int)N];
		for(int tc = 0 ; tc < N ; tc++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			long target_atk = Long.parseLong(st.nextToken());
			long target_hp = Long.parseLong(st.nextToken());
			stage[tc] = new H(command, target_atk, target_hp);
		}
		
		long l,r;
		l = 1; r = Long.MAX_VALUE-1;
		while(l < r) {
			long mid = (l+r)/2l;
			
			if(isPossible(mid)) {
				r = mid;
			}else {
				l = mid+1;
			}
		}
		System.out.println(l);
		
	}
	static class H {
		long command,atk,hp;
		H(long command, long atk, long hp) {
			this.command = command;
			this.atk = atk;
			this.hp = hp;
		}
	}
}
