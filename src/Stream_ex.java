import java.util.*;

public class Stream_ex {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
		// 기존 코딩 방식.
		long count = 0;
		for(String str : names) {
			if(str.contains("o")) count++;
		}
		System.out.println(count);
		
		// 스트림 사용
		count = 0;
		count = names.stream().filter(x -> x.contains("o")).count();
		System.out.println(count);
	}
}
