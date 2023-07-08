import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, cheese;
	static int[][] map, result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cheese = 0;
		for (int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if (map[r][c]==1) {
					cheese++;
				}
			}
		}
		result = map.clone();
		int time=0;
		int prevcheese = cheese;
		while(cheese>0) {
			time++;
			prevcheese = cheese;
			bfs();
		}
		System.out.println(time);
		System.out.println(prevcheese);
	}
	private static void bfs() {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		boolean[][] visited = new boolean[R][C];
		queue.add(new Integer[] {0, 0});
		visited[0][0]=true;
		while(!queue.isEmpty()) {
			Integer[] top = queue.poll();
			for (int d=0; d<4; d++) {
				int nr = top[0]+dr[d]; int nc = top[1]+dc[d];
				if (nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
					visited[nr][nc]=true;
					if (map[nr][nc]==1) {
						result[nr][nc]=0;
						cheese--;
					} else {
						queue.add(new Integer[] {nr, nc});
					}
				}
			}
		}
		map=result;
	}
	
}