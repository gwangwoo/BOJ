import java.util.*;

public class _pro_프린터 {
	
	public static void main(String[] args) {
//		int[] priorities = {1, 1, 9, 1, 1, 1};
//		int location = 0;
		
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Word> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int N = priorities.length;
        for(int i = 0 ; i < N ; i++) {
        	q.add(new Word(i, priorities[i]));
        	pq.add(-priorities[i]);
        }
        while(!pq.isEmpty()) {
        	int priorityNumber = -pq.poll();
        	while(true) {
        		if(!q.isEmpty() && q.peek().priority == priorityNumber) break;
        		q.add(q.poll());
        	}
        	Word now = q.poll();
        	if(now.idx == location) return ++answer;
        	else answer++;
        }
        
        return answer;
    }
	
	static class Word {
		int idx,priority;
		Word(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
	}
}
