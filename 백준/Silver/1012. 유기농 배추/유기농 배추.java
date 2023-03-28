import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[][] map;
	static int[][] lettuce;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	static int noWorm;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			visited = new boolean[K];
			noWorm = K;
			lettuce = new int[K][2];
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				lettuce[i][0]=Integer.parseInt(st.nextToken());
				lettuce[i][1]=Integer.parseInt(st.nextToken());
			}
			cnt=0;
			for (int i=0; i<K; i++) {
				if (visited[i]==false) {
					search(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	private static void search(int v) {
		if (noWorm==0) return;
		visited[v]=true;
		for (int i=0; i<K; i++) {
			if (!visited[i]) {
				for (int j=0; j<4; j++) {
					if (lettuce[i][0]==lettuce[v][0]+dr[j] && lettuce[i][1]==lettuce[v][1]+dc[j]) {
						search(i);
					}
				}
			}
		}
	}
}