import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int cnt=0;
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			int len = set.size();
			set.add(str);
			if (set.size()==len) {
				continue;
			}
			for (int j=1; j<str.length(); j++) {
				String str1 = str.substring(j)+str.substring(0, j);
				set.add(str1);
			}
			if (set.size()!=len) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}