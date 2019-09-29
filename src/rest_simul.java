import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class rest_simul {
	static Cus cus[];
	static Step step[];
	static Cook cook[];
	static Table table[];
	static int hour,cnum,snum,tnum;
	static Queue<Cus> q = new LinkedList<>();
	static Queue<Integer> cook_q = new LinkedList<>();
	static Queue<Integer> step_q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		hour = Integer.parseInt(st.nextToken());
		cnum = Integer.parseInt(st.nextToken());
		snum = Integer.parseInt(st.nextToken());
		tnum = Integer.parseInt(st.nextToken());
		
		hour *= 60*hour;
		step = new Step[snum];
		cook = new Cook[cnum];
		table = new Table[tnum];
		
		
		int time = 0;
		
		while(time < hour) {
			// 테이블에 있는 사람 다 먹었으면 뺴주기.
			// 그리고 답 증가시키기.
			
			
			// 손님은 테이블에 앉기 전에 최대 1시간을 기다릴수 있다.
			if(!q.isEmpty()) {
				int N = q.size();
				while(N-- > 0) {
					Cus now = q.poll();
					now.waittime++;
					if(now.waittime > 60) continue;
					q.add(now);
				}
			}
			
			// 10분이 되면 손님 입장.
			if(time == 0 ||time % 10 == 0) {
				for(int i = 0 ; i < 7 ; i++) {
					q.add(new Cus(0));
				}
			}
			// 비어있는 자리에 앉히고 요리사 큐 index 전달.
			for(int i = 0 ; i < tnum ; i++) {
				if(!table[i].isUse) {
					Cus now = q.poll();
					table[i].isUse = true;
					cook_q.add(i);
					table[i].usetime = -1;
				}
			}
			// 밥있는애들 밥먹이기.
			for(int i = 0 ; i < tnum ; i++) {
				if(table[i].usetime != 0) {
					table[i].usetime--;
					if(table[i].usetime == 0) {
						
					}
				}
			}
			
			
			// 요리사 요리시키기.
			for(int i = 0 ; i < cnum ; i++) {
				if(cook[i].isCook) {
					cook[i].cost--;
					if(cook[i].cost == 0) {
						cook[i].isCook = false;
						table[cook[i].who_s_dish].usetime = 11;
					}
				}
			}
			
			
			// 요리사 요리추가하는 곳,
			for(int i = 0 ; i < cnum ; i++) {
				if(!cook[i].isCook) {
					if(cook_q.isEmpty()) break;
					int index = cook_q.poll();
					cook[i].isCook = true;
					cook[i].cost = 4;
					cook[i].who_s_dish = index;
				}
			}
			
			
		}
		
		
	}	
	static class Cus {
		int waittime;
		Cus(int waittime) {
			this.waittime = waittime;
		}
	}
	
	static class Step {
		boolean isWork;
		int step_time;
		Step(boolean isWork, int step_time) {
			this.isWork = isWork;
			this.step_time = step_time;
		}
	}
	static class Cook {
		boolean isCook;
		int cost;
		int who_s_dish;
		Cook(boolean isCook, int cost,int who_s_dish) {
			this.isCook = isCook;
			this.cost = cost;
			this.who_s_dish = who_s_dish;
		}
	}
	static class Table {
		boolean isUse;
		int usetime;
		Table(boolean isUse, int usetime) {
			this.isUse = isUse;
			this.usetime = usetime;
		}
		
	}
}
