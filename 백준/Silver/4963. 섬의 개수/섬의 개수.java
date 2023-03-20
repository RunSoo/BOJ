import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] directions = {
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{1, -1},
			{1, 0},
			{1, 1},
			{0, -1},
			{0, 1}
	};
	public static int[][] land;
	public static int w;
	public static int h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w==0 && h==0) break;
			land = new int[h][w];
			for (int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<w; c++) {
					land[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for (int r=0;r<h; r++) {
				for (int c=0; c<w; c++) {
					if (land[r][c]==1) {
						dfs(r, c);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int r, int c) {
		land[r][c]=0;
		for(int d=0; d<8; d++) {
			int nextRow = r+directions[d][0];
			int nextColumn = c+directions[d][1];
			
			if (isinLand(nextRow, nextColumn) && land[nextRow][nextColumn]==1) {
				dfs(nextRow, nextColumn);
			}
		}
	}

	private static boolean isinLand(int r, int c) {
		if (r>=0 && r<h && c>=0 && c<w) {
			return true;
		}
		return false;
	}
}