import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		getResult(0);
	}
	private static void getResult(int idx) {
		if (idx==M) {
			for (int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int prev=1;
		if (idx>0) {
			prev=result[idx-1];
		}
		for (int i=prev; i<=N; i++) {
			result[idx]=i;
			getResult(idx+1);
		}
	}
}
