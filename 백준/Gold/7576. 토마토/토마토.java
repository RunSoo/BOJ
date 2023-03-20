import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int M;
	public static int N;
	public static int[][] tomato;
	public static int[][] direction = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				tomato[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (tomato[r][c]==1) {
					queue.add(new int[] {r, c});
				}
			}
		}
		
		int count = bfs();
		if (cant()) {
			System.out.println(-1);
		} else {
			System.out.println(count-1);
		}
	}

	private static int bfs() {
		int step=0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int[] top = queue.poll();
				int r = top[0];
				int c = top[1];
				for (int d=0; d<4; d++) {
					int currentR = r+direction[d][0];
					int currentC = c+direction[d][1];
					if (isInTomato(currentR, currentC) && tomato[currentR][currentC]==0) {
						tomato[currentR][currentC]=1;
						queue.add(new int[] {currentR, currentC});
					}
				}
			}
			step++;
		}
		return step;
	}

	private static boolean isInTomato(int r, int c) {
		if (r>=0 && r<N && c>=0 && c<M) {
			return true;
		} return false;
	}
	
	private static boolean cant() {
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (tomato[r][c]==0) return true;
			}
		}
		return false;
	}
}