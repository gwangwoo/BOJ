
public class 해쉬 {
	static final int MAX_KEY = 64;
	static final int MAX_DATA = 128;
	static final int MAX_TABLE = 4096;
	static Hash tb[] = new Hash[MAX_TABLE];
	
	static void init() {
		for(int i = 0 ; i < MAX_TABLE ; i++) {
			tb[i] = new Hash();
		}
	}
	
	static String find(String key) {
		int h = (int)hashing(key);
		int cnt = MAX_TABLE;
		
		while(tb[h].key != null && cnt-- > 0) {
			if(tb[h].key.equals(key)) {
				return tb[h].data;
			}
			h = (h+1) % MAX_TABLE;
		}
		return null;
	}
	
	static int add(String key, String data) {
		int h = (int)hashing(key);
		while(tb[h].key != null) {
			if(tb[h].key.equals(key)) {
				return 0;
			}
			h = (h+1) % MAX_TABLE;
		}
		tb[h].key = key;
		tb[h].data = data;
		return 1;
	}
	
	
	static long hashing(String str) {
		long hash = 5381;
		int c = str.length();
		for(int i = 0 ; i < c ; i++) {
			hash = ((hash << 5) + hash)+(str.charAt(i)-'0') % MAX_TABLE;
		}
		return hash % MAX_TABLE;
	}	
	
	public static void main(String[] args) {
		init();
		add("apple","사과는 맛있어~");
		add("apple","123");
		System.out.println(hashing("apple"));
		System.out.println(find("apple"));
	}
	static class Hash {
		String key;
		String data;
		Hash(){};
		Hash(String key, String data) {
			this.key = key;
			this.data = data;
		}
	}
}
