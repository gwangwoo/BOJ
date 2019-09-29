import java.io.*;
import java.util.*;

public class _boj_16934_게임닉네임 {
	static int N;
	static HashSet<String> hs = new HashSet<>();
	static HashMap<String,Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < N ; tc++) {
			String str = br.readLine();
			if(!hs.contains(str)) { // 닉네임이 없다면, 
				int idx = 1;
				for(int j = 1 ; j <= str.length() ; j++) {
					String tmp = str.substring(0,j);
					if(hs.contains(tmp)) continue;
					else {
						idx = j;
						break;
					}
				}
				System.out.println(str.substring(0,idx));
				// 해쉬맵에 이 숫자는 고유하게 한번 사용되었다고 저장해준다.
				// 나중에 같은 이름의 닉네임이나왔을경우 몇번 사용되었는지 알기 위함이다.
				hm.put(str,1);
				// 나머지 닉네임으로 만들수 있는 경우들을 모두다 해쉬셋에 넣어준다.
				for(int i = 1 ; i <= str.length() ; i++) {
					hs.add(str.substring(0,i));
				}
			}else if(hm.containsKey(str)){
				// 그 닉네임이 있다면, 중복 되었으니, 숫자를 추가해줘야한다.
				// 카운트를 증가시켜주고 번호를 라벨링후 다시 해쉬맵에 넣어주는 과정.
				int val = hm.get(str);
				val++;
				hm.remove(str);
				hm.put(str, val);
				System.out.println(str+val);
			}else {
				// 얘네들은 같은 닉네임이 아니고, 한번이라도 해쉬맵에 저장되어있지않았던애들.
				// 즉 28번째줄 for문에 의해 만들어진 애들이지 실제로 등장하지 않았던 애들.
				// 그런 아이들 이므로 그대로 출력해줄수있고 해쉬맵에 저장해준다.
				System.out.println(str);
				hm.put(str, 1);
			}
		}
	}

}
