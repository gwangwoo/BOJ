package ����;

public class �ζ�2 {
	static int k;
	static String[] S;
	public static void go(String[] S, int i , String str, int count) {
		// ������ ���
		if(count == 6) {
			System.out.println(str);
			return;
		}
		//�ƴҰ��
		if(i==S.length) return;
		go(S,i+1,str+S[i],count+1);
		go(S,i+1,str,count);
	}
	public static void main(String[] args) {

	}

}
