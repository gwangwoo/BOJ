import java.io.*;
import java.util.*;

public class _boj_18235_V2 {

    static int N, A, B;
    static int[] visitedA, visitedB;
    static int[] dx = {-1, 1};

    public static void main(String... args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        visitedA = new int[N + 1];
        visitedB = new int[N + 1];
        Arrays.fill(visitedA, -1);
        Arrays.fill(visitedB, -1);
        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 0, true));
        queue.add(new Node(B, 0, false));
        visitedA[A] = 0;
        visitedB[B] = 0;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int cur = tmp.idx;
            int cnt = tmp.cnt;
            boolean flag = tmp.flag;

            if (visitedA[cur] == visitedB[cur] && visitedB[cur] > -1)
                return visitedB[cur];

            for (int i = 0; i < 2; i++) {
                int next = cur + dx[i] * (1 << cnt);

                if (next < 1 || next > N)
                    continue;

                if (flag)
                    visitedA[next] = cnt + 1;

                else
                    visitedB[next] = cnt + 1;

                queue.add(new Node(next, cnt + 1, flag));
            }
        }

        return -1;
    }

static class Node {
    	int idx, cnt;
    	boolean flag;
    	
    	public Node(int idx, int cnt, boolean flag) {
    		this.idx = idx;
    		this.cnt = cnt;
    		this.flag = flag;
    	}
    }
}
