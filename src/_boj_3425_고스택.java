import java.io.*;
import java.util.*;

public class _boj_3425_고스택 {
	static ArrayList<String> command;
	static ArrayList<Long> number;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("QUIT")) break;
			else {
				command = new ArrayList<>();
				number = new ArrayList<>();
				// 명령어 저장.
				while(!str.equals("END")) {
					command.add(str);
					str = br.readLine();
				}
				int T = Integer.parseInt(br.readLine());
				for(int tc = 1; tc <= T ; tc++) {
					number.add(Long.parseLong(br.readLine()));
				}
				// 입력 잘 들어옴.
//				System.out.println(command);
//				System.out.println(number);
				br.readLine();
				NEXT:
					for(int i = 0 ; i < number.size() ; i++) {
						long now = number.get(i);
						Stack<Long> stk = new Stack<>();
						stk.add(now);
						for(int j = 0 ; j < command.size() ; j++) {
							String cmd = command.get(j);
							long tmp, first, second, sum;
							switch(cmd) {
							case "POP":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.pop();
								break;
							case "INV":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								tmp = stk.pop();
								stk.add(-tmp);
								break;
							case "DUP":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								tmp = stk.pop();
								stk.add(tmp); stk.add(tmp);
								break;
							case "SWP":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								stk.add(first);
								stk.add(second);
								break;
							case "ADD":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								sum = first + second;
								if(Math.abs(sum) > 1e9) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.add(first+second);
								break;
							case "SUB":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								sum = second - first;
								if(Math.abs(sum) > 1e9) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.add(second-first);
								break;
							case "MUL":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								sum = first * second;
								if(Math.abs(sum) > 1e9) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.add(first*second);
								break;
							case "DIV":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								if(first == 0) {
									System.out.println("ERROR");
									continue NEXT;
								}
								sum = second / first;
								if(Math.abs(sum) > 1e9) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.add(sum);
								break;
							case "MOD":
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								first = stk.pop();
								if(stk.isEmpty()) {
									System.out.println("ERROR");
									continue NEXT;
								}
								second = stk.pop();
								if(first == 0) {
									System.out.println("ERROR");
									continue NEXT;
								}
								sum = second % first;
								if(Math.abs(sum) > 1e9) {
									System.out.println("ERROR");
									continue NEXT;
								}
								stk.add(sum);
								break;
							default:
								StringTokenizer st = new StringTokenizer(cmd);
								st.nextToken();
								stk.add(Long.parseLong(st.nextToken()));
								break;
							}
						}
						if(stk.size() != 1) {
							System.out.println("ERROR");
						}else {
							System.out.println(stk.pop());
						}
					}
			}
			System.out.println();
		}

	}

}
