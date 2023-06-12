import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static Integer[] goal;
	static int[][] result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		goal = new Integer[2];
		for (int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<m; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if (map[r][c]==2) {
					goal[0]=r; goal[1]=c;
				}
			}
		}
		////////////////
		result = new int[n][m];
		bfs();
		for (int r=0; r<n; r++) {
			for (int c=0; c<m; c++) {
				if (map[r][c]==1 && result[r][c]==0) {
					result[r][c]=-1;
				}
			}
		}
		for (int r=0; r<n; r++) {
			for (int c=0; c<m; c++) {
				System.out.print(result[r][c]+" ");
			}
			System.out.println();
		}
	}
	private static void bfs() {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(goal);
		while(!queue.isEmpty()) {
			Integer[] top = queue.poll();
			for (int i=0; i<4; i++) {
				int nr = top[0]+dr[i];
				int nc = top[1]+dc[i];
				if (nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==1 && result[nr][nc]==0) {
					result[nr][nc]=result[top[0]][top[1]]+1;
					queue.add(new Integer[] {nr, nc});
				}
			}
		}
	}
	
}
