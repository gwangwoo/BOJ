package ����;
import java.util.*;
public class �ִܰ�� {
	static void floyd(int n, int[][] W, int[][] D) {
		//�� ����
		for(int i = 1 ; i <= vertex ; i++) {
			for(int j = 1 ; j <= vertex ; j++) {
				D[i][j] = W[i][j];
			}
		}
		for(int k =1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1; j <= n; j++) {
					D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
		}
	}
	
	static final int INF = 9999;
	static int vertex;
	static int edge;
	static int D[][];
	static int W[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		edge = sc.nextInt();
		int start = sc.nextInt();
		D = new int[vertex+1][vertex+1]; // �ִܰŸ� �迭
		W = new int[vertex+1][vertex+1]; // ����ġ �迭
		// �켱 INF �� �ʱ�ȭ.
		for(int i = 1; i <= vertex ; i++) {
			for(int j = 1 ; j <= vertex ; j++) {
				W[i][j] = INF;
			}
		}
		// 1,1 2,2 3,3 .... �� 0 ���� �ְ�
		for(int i = 1 ; i <=vertex ; i++) {
			W[i][i] = 0;
		}
		// �Է� �� ����
		for(int i = 0 ; i < vertex ; i++) {
			W[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		// �Է� �� ����

		floyd(vertex,W,D);
		for(int i = 1 ; i <= vertex; i++) {
			if(D[start][i] == INF) System.out.println("INF");
			else {
				System.out.println(D[start][i]);
			}
		}
	}
}