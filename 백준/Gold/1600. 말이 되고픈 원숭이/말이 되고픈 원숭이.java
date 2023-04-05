import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;
	static int[] hr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hc = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] mr = {-1, 1, 0, 0};
	static int[] mc = {0, 0, -1, 1};
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int r=0; r<H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<W; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		/////입력 다받음
		
		visit = new boolean[H][W][K+1];
		
		min = Integer.MAX_VALUE;
		bfs(0, 0);
		
		if (min!=Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
		
		
	}
	private static void bfs(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] {r, c, 0, 0}); // 몇 번 말처럼 뛴 세계에 있는지, 몇 번 이동했는지
		for (int k=0; k<=K; k++) {
			visit[r][c][k]=true;
		}
		while (!queue.isEmpty()) {
			Integer[] top = queue.poll();
//			System.out.println(Arrays.toString(top));
			
			for (int t=0; t<top.length; t++) {
				if (top[0]==H-1 && top[1]==W-1) {
					min = Math.min(min, top[3]);
					return;
				}
				
				// 원숭이처럼 뛰자!
				for (int d=0; d<4; d++) {
					int nr=top[0] + mr[d];
					int nc=top[1] + mc[d];
					if (nr>=0 && nr<H && nc>=0 && nc<W && !visit[nr][nc][top[2]] && map[nr][nc]==0) {
						queue.add(new Integer[] {nr, nc, top[2], top[3]+1});
						visit[nr][nc][top[2]]=true;							
					}
				}
				// 말처럼 뛰자!
				if (top[2]<K) {
					for (int d=0; d<8; d++) {
						int nr = top[0]+hr[d];
						int nc = top[1]+hc[d];
						if (nr>=0 && nr<H && nc>=0 && nc<W && !visit[nr][nc][top[2]+1] && map[nr][nc]==0) {
							queue.add(new Integer[] {nr, nc, top[2]+1, top[3]+1});
							visit[nr][nc][top[2]+1]=true;							
						}
					}
				}
			}
		}
	}
}