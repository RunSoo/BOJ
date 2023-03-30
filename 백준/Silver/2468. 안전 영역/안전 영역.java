import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] sink;
	static int maxHeight=0;
	static int minHeight=Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int maxCnt = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, map[r][c]);
				maxHeight = Math.max(maxHeight, map[r][c]);
			}
		}
		
		for (int rain=minHeight-1; rain<=maxHeight; rain++) {
			int cnt=0;
			sink = new boolean[N][N];
			getSink(rain);
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (sink[r][c]) {
						sink[r][c]=false;
						bfs(r, c);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
	
	private static void bfs(int r, int c) {
		for (int i=0; i<4; i++) {
			if (r+dr[i]>=0 && r+dr[i]<N && c+dc[i]>=0 && c+dc[i]<N && sink[r+dr[i]][c+dc[i]]) {
				sink[r+dr[i]][c+dc[i]]=false;
				bfs(r+dr[i], c+dc[i]);
			}
		}
	}

	private static void getSink(int rain) {
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (map[r][c]>rain) sink[r][c]=true;
			}
		}
	}
}