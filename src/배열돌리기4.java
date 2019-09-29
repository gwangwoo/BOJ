import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 배열돌리기4 {
	static int[][] brr;
	static int [][] arr;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static int m=6000;
	public static class tripple{
		int r;
		int c;
		int s;
		public tripple(int r, int c, int s) {
			// TODO Auto-generated constructor stub
			this.r=r;
			this.c=c;
			this.s=s;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		brr=new int[N][M];//초기 배
		for(int row=0;row<N;row++) {
			st=new StringTokenizer(br.readLine());
			for(int col=0;col<M;col++) {
				brr[row][col]=Integer.parseInt(st.nextToken());
			}
		}
		arr=new int [N][M];
		for(int i=0;i<brr.length;i++) {
			System.arraycopy(brr[i], 0, arr[i],0,brr[i].length);
		}
		tripple [] tr=new tripple[K];
		for(int tc=0;tc<K;tc++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			tr[tc]=new tripple(r,c,s);
		}
		//dfs
		dfs(tr,0,N,M);
		
		System.out.println(m);
		
	}
	static void dfs(tripple[] tr,int idx,int N,int M)
	{
		if(idx==tr.length) {
			for(int i=0;i<tr.length;i++) {
				int start_r=tr[i].r-tr[i].s-1;
				int start_c=tr[i].c-tr[i].s-1;
				int s=tr[i].s;
				while(s>0) {
					rotate(start_r,start_c,s);
					start_r++;
					start_c++;
					s/=2;
				}
			}
			for(int row=0;row<N;row++) {
				int sum=0;
				for(int col=0;col<M;col++) {
					sum+=arr[row][col];
				}
				if(m>sum) {
					m=sum;
					
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<M;j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int i=0;i<N;i++) {
				arr[i]=brr[i].clone();
			}
			return;
		}
		for(int i=idx;i<tr.length;i++) {
			swap(tr,i,idx);
			dfs(tr,idx+1,N,M);
			swap(tr,i,idx);
		}
	}
	
	static void swap(tripple[] tr, int i,int j) {
		tripple tmp=tr[i];
		tr[i]=tr[j];
		tr[j]=tmp;
	}
	static void rotate(int start_row, int start_col,int s) {
		int tmp=arr[start_row][start_col];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<s*2;j++) {
				start_row+=dr[i];
				start_col+=dc[i];
				int t=arr[start_row][start_col];
				arr[start_row][start_col]=tmp;
				tmp=t;
			}
		}
	}
}