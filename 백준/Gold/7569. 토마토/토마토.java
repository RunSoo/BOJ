import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int M;
	public static int N;
	public static int H;
	public static int[][][] tomato;
	public static int[][] direction = {
			{0, 0, 1},
			{0, 0, -1},
			{1, 0, 0},
			{-1, 0, 0},
			{0, 1, 0},
			{0, -1, 0}
	};
	public static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<M; c++) {
					tomato[h][r][c]=Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (tomato[h][r][c]==1) {
						queue.add(new int[] {h, r, c});
					}
				}
			}
		}
		int count=bfs();
		if (cant()) {
			System.out.println(-1);
		} else {
			System.out.println(count-1);
		}
	}

	private static int bfs() {
		int step = 0;
		
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int i=0; i<size; i++) {
				int[] top = queue.poll();
				int h = top[0];
				int r = top[1];
				int c = top[2];
				for (int d=0; d<6; d++) {
					int currentH = h+direction[d][0];
					int currentR = r+direction[d][1];
					int currentC = c+direction[d][2];
					if (isInTomato(currentH, currentR, currentC) && tomato[currentH][currentR][currentC]==0) {
						tomato[currentH][currentR][currentC]=1;
						queue.add(new int[] {currentH, currentR, currentC});
					}
				}
			}
			step++;
		}
		
		return step;
	}

	private static boolean isInTomato(int currentH, int currentR, int currentC) {
		if (currentH>=0 && currentH<H && currentR>=0 && currentR<N && currentC>=0 && currentC<M) {
			return true;
		}
		return false;
	}
	
	public static boolean cant() {
		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (tomato[h][r][c]==0) {
						return true;
					}
				}
			}
		}
		return false;
	}
}