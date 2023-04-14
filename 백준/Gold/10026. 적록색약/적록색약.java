import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static String[][] map;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0, };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < N; m++) {
				map[n][m] = String.valueOf(str.charAt(m));
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		int ans = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (!visited[n][m]) {
					bfs(new int[] { n, m });
					ans++;
				}
			}
		}
		System.out.print(ans+ " ");
		int ans1 = 0;
		visited = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if(map[n][m].equals("R")) {
					map[n][m]="G";
				}
			}
		}
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (!visited[n][m]) {
					bfs(new int[] { n, m });
					ans1++;
				}
			}
		}
		System.out.println(ans1);
	}



	private static void bfs(int[] arr) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(arr);
		visited[arr[0]][arr[1]] = true;
		while (!queue.isEmpty()) {
			int[] arrTmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = arrTmp[0] + dr[i];
				int nc = arrTmp[1] + dc[i];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]
						&& map[nr][nc].equals(map[arrTmp[0]][arrTmp[1]])) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}

			}
		}

	}
}