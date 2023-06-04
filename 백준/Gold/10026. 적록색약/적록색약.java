import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] grid;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int dist1, dist2;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		for (int r=0; r<N; r++) {
			grid[r]=br.readLine().toCharArray();
		}
		visited1 = new boolean[N][N];
		dist1=0;
		normdist();
		visited2 = new boolean[N][N];
		dist2=0;
		cbdist();
		System.out.println(dist1+" "+dist2);
	}
	private static void cbdist() {
		Queue<Integer[]> queue = new LinkedList<>();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (visited2[r][c]==false) {
					char start = grid[r][c];
					queue.add(new Integer[] {r, c});
					while(!queue.isEmpty()) {
						Integer[] top = queue.poll();
						for (int d=0; d<4; d++) {
							int nr = top[0]+dr[d];
							int nc = top[1]+dc[d];
							if (nr>=0 && nc>=0 && nr<N && nc<N && visited2[nr][nc]==false) {
								if (start=='R' || start=='G') {
									if (grid[nr][nc]=='R'|| grid[nr][nc]=='G') {
										visited2[nr][nc]=true;
										queue.add(new Integer[] {nr, nc});
									}
								} else {
									if (grid[nr][nc]==start) {
										visited2[nr][nc]=true;
										queue.add(new Integer[] {nr, nc});
									}
								}
							}
						}
					}
					dist2++;
				}
			}
		}
		
	}
	private static void normdist() {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (visited1[r][c]==false) {
					char start = grid[r][c];
					queue.add(new Integer[]{r, c});
					while(!queue.isEmpty()) {
						Integer[] top = queue.poll();
						for (int d=0; d<4; d++) {
							int nr = top[0]+dr[d];
							int nc = top[1]+dc[d];
							if (nr>=0 && nr<N && nc>=0 && nc<N && visited1[nr][nc]==false && grid[nr][nc]==start) {
								visited1[nr][nc]=true;
								queue.add(new Integer[] {nr, nc});
							}
						}
					}
					dist1++;
				}
			}
		}
	}
	
}
