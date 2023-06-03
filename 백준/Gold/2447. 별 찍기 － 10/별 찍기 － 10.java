import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] star;
	static int N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				star[r][c]=' ';
			}
		}
		empty(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				sb.append(star[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void empty(int nr, int nc, int n) {
		if (n==1) {
			star[nr][nc]='*';
			return;
		}
		for (int ir=0; ir<3; ir++) {
			for (int ic=0; ic<3; ic++) {
				if (ir==1 && ic==1) continue;
				empty(nr+ir*n/3, nc+ic*n/3, n/3);
			}
		}
	}
}