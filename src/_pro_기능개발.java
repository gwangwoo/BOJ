import java.util.*;

public class _pro_기능개발 {
	public static void main(String[] args) {
//		int progresses[] = {93, 30, 55};
//		int speeds[] = {1, 30, 5};
		
		int progresses[] = {95, 90, 99, 99, 80, 99};
		int speeds[] = {1, 1, 1, 1, 1, 1};
		
		System.out.println(solution(progresses, speeds));
	}


	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answerArl = new ArrayList<>();
		Queue<Task> q = new LinkedList<>();
		int N = progresses.length;
		for(int i = 0 ; i < N ; i++) {
			q.add(new Task(progresses[i], speeds[i]));
		}

		while(!q.isEmpty()) {
			int qSize = q.size();
			int day = 0;
			int cnt = 0;
			boolean flag = false;
			while(qSize-- > 0) {
				Task t = q.poll();
				int progress = t.progress;
				int speed = t.speed;
				// first
				if(day == 0) {
					day = (100 - progress) / speed;
					if((100 - progress) % speed != 0) day++;
					cnt++;
					continue;
				}
				// other
				
				if((progress + speed * day) >= 100 && !flag) {
					cnt++;
					continue;
				}else {
					flag = true;
					if(progress + speed*day > 100) progress = 100; 
					else progress += speed*day;
					q.add(new Task(progress, speed));
				}
			}
			answerArl.add(cnt);
		}
		int answer[] = new int[answerArl.size()];
		for(int i = 0 ; i < answerArl.size() ; i++) {
			answer[i] = answerArl.get(i);
			System.out.println(answer[i]);
		}
		
		return answer;
	}

	static class Task {
		int progress, speed;
		Task(int progress, int speed) {
			this.progress = progress;
			this.speed = speed;
		}
	}
}
