import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		///////////////////입력 끝~~~~~~~
		int[] dr = {1, 0, 1};
		int[] dc = {0, 1, 1};
		int[][] dp = new int[N][M];
		dp[0][0]=map[0][0];
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				int val = 0;
				for (int d=0; d<3; d++) {
					int nr = r-dr[d];
					int nc = c-dc[d];
					if (nr>=0 && nr<N && nc>=0 && nc<M) {
//						System.out.println("nr: "+nr+", nc: "+nc);
						val = Math.max(val, dp[nr][nc]);
					}
				}
				val+=map[r][c];
//				System.out.println("val: "+val);
				dp[r][c]=val;
			}
		}
//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N-1][M-1]);
	}
}