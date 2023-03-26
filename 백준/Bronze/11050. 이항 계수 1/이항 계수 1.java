import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K>0) System.out.println(combination(N, K));
		else System.out.println(1);
	}

	private static int combination(int n, int k) {
		if (k==1) return n;
		if (n==1) return 0;
		
		return combination(n-1, k-1)+combination(n-1, k);
	}
}