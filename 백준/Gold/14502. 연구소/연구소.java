import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int maxSafe;
	static boolean[][] visited;
	static int zeroCnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int localCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		zeroCnt=0;
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if (map[r][c]==0) zeroCnt++;
			}
		}
		maxSafe=0;
		buildWall(0); // 0개 벽 지음
		
		System.out.println(maxSafe);
	}
	private static void buildWall(int cnt) {
		if (cnt==3) {
//			System.out.println(Arrays.deepToString(map));
			localCnt=zeroCnt-3;
			visited = new boolean[N][M];
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (map[r][c]==2) {
						dfs(r, c);
					}
				}
			}
			maxSafe = Math.max(maxSafe, localCnt);
			return;
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (map[r][c]==0) {
					map[r][c]=1;
					buildWall(cnt+1);
					map[r][c]=0;
				}
			}
		}
	}
	private static void dfs(int ir, int ic) {
		for (int d=0; d<4; d++) {
			int nr = ir+dr[d];
			int nc = ic+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0 && !visited[nr][nc]) {
				visited[nr][nc]=true;
				localCnt--;
				dfs(nr, nc);
			}
		}
	}

}