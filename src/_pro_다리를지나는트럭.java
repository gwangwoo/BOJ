import java.util.*;

public class _pro_다리를지나는트럭 {
	public static void main(String[] args) {
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {100};
		
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		
		System.out.println(solution(bridge_length, weight, truck_weights));
		
	}
	
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int nowWeight = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Truck> bridgeQ = new LinkedList<>();
        int N = truck_weights.length;
        for(int i = 0 ; i < N ; i++) q.add(truck_weights[i]);
        while(true) {
        	if(q.isEmpty() && bridgeQ.isEmpty()) break; 
        	time++;
        	if(!bridgeQ.isEmpty()) {
        		int qSize = bridgeQ.size();
        		while(qSize-- > 0) {
        			Truck truck = bridgeQ.poll();
        			if(--truck.time == 0) {
        				nowWeight -= truck.weight;
        				continue;
        			}
        			bridgeQ.add(truck);
        		}
        	}
        
        	if(!q.isEmpty() && (weight >= q.peek() + nowWeight) && bridgeQ.size() < bridge_length) {
        		int now = q.poll();
        		bridgeQ.add(new Truck(now, bridge_length));
        		nowWeight += now;
        	}
        }
        
        return time;
    }
	static class Truck {
		int weight, time;
		Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}
}
