package ����;
import java.util.*;
public class ��Ǯ��_������ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int res = 9;
		int min = 0;
		while(res-- >0) {
			min = min + sc.nextInt();
		}
		System.out.println(max - min);
	}
}
