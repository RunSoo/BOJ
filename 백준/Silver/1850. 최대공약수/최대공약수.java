import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Math.min(A, B);
		long D = Math.max(A, B);
		long result = gcd(D, C);

		for (int i=0; i<result; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
	public static long gcd(long a, long b) {
		if (b==0L) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}
}