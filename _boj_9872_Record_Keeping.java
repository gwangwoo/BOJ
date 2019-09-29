import java.io.*;
import java.util.*;

public class _boj_9872_Record_Keeping {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hm = new HashMap<>();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> arr = new ArrayList<>();
			for(int i = 0 ; i < 3 ; i++) {
				arr.add(st.nextToken());
			}
			String str1,str2,str3,res = "";
			boolean flag = false;
			Loop:
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(i == j) continue;
					for(int k = 0 ; k < 3 ; k++) {
						if(j == k || k == i) continue;
						str1 = arr.get(i); str2 = arr.get(j); str3 = arr.get(k);
						res = str1+str2+str3;
						if(hm.containsKey(res)) {
							int val = hm.get(res);
							hm.remove(res);
							hm.put(res, ++val);
							flag = true;
							break Loop;
						}
					}
				}
			}
			if(flag) continue;
			else {
				hm.put(res, 1);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.addAll(hm.values());
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
	}

}
