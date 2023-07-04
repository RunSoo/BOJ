import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, H, D; // 한변 길이, 체력, 내구도
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] visited;
	static int minMove;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		int[] start = new int[2];
		for (int r=0; r<N; r++) {
			char[] chArr = br.readLine().toCharArray();
			for (int c=0; c<N; c++) {
				map[r][c]=chArr[c];
				if (map[r][c]=='S') {
					start[0]=r; start[1]=c;
				}
			}
		}
		visited = new int[N][N];
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				visited[r][c]=Integer.MAX_VALUE;
//			}
//		}
		minMove = Integer.MAX_VALUE;
		move(start[0], start[1]);
		if (minMove==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minMove);
		}
	}
	private static void move(int ir, int ic) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] {ir, ic, H, 0, 0}); // r, c, 체력, 우산, 이동횟수
		visited[ir][ic]=H;
		while(!queue.isEmpty()) {
			Integer[] top = queue.poll();
//			System.out.println("top: "+Arrays.toString(top));
			for (int d=0; d<4; d++) {
				int nr = top[0]+dr[d]; int nc = top[1]+dc[d];
				if (nr>=0 && nr<N && nc>=0 && nc<N) {
					int hp=top[2]; int um = top[3];
					if (map[nr][nc]=='U') {
						um = D-1;
						if (visited[nr][nc]<hp+um) {
							visited[nr][nc]=hp+um;
							queue.add(new Integer[] {nr, nc, hp, um, top[4]+1});
						}
						
					} else if (map[nr][nc]=='.') {
						if (um>0) {
							um--;
						} else {
							hp--;
						}
						if (hp>0 && visited[nr][nc]<hp+um) {
							visited[nr][nc]=hp+um;
							queue.add(new Integer[] {nr, nc, hp, um, top[4]+1});
						}
					} else if (map[nr][nc]=='E'){
//						System.out.println("end: "+nr+", "+nc+", "+top[2]+", "+top[3]+", "+(top[4]+1));
						minMove = Integer.min(minMove, top[4]+1);
					}
				}
			}
		}
	}
}