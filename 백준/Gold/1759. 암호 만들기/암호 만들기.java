import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] cArr, code;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cArr = new char[C];
		code = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			cArr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(cArr);
		makeCode(0, 0);
	}
	private static void makeCode(int x, int idx) {
		if (idx==L) {
			if (isValid()) {
				System.out.println(code);
			}
			return;
		}
		
		for (int i=x; i<C; i++) {
			code[idx]=cArr[i];
			makeCode(i+1, idx+1);
		}
	}
	private static boolean isValid() {
		int mo = 0;
		int ja = 0;
		for (char x : code) {
			if (x=='a' || x=='e' || x=='i' || x=='o' || x=='u' ) {
				mo++;
			} else {
				ja++;
			}
		}
		if (mo>=1 && ja>=2) {
			return true;
		}
		return false;

	}
}
