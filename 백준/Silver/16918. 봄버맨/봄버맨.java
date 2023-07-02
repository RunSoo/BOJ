import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r=0; r<R; r++) {
			char[] chArr = br.readLine().toCharArray();
			for (int c=0; c<C; c++) {
				map[r][c]=chArr[c];
			}
		}

		if (N%2==0) {
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					map[r][c]='O';
				}
			}
		} else {
			int time=0;
			while(N/2>time) {
				bomb();
				time++;
			}
		}
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
	private static void bomb() {
		char[][] result = new char[R][C];
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				result[r][c]='O';
			}
		}
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (map[r][c]=='O') {
					result[r][c]='.';
					for (int d=0; d<4; d++) {
						int nr=r+dr[d]; int nc=c+dc[d];
						if (nr>=0 && nr<R && nc>=0 && nc<C) {
							result[nr][nc]='.';
						}
					}
				}
			}
		}
		map=result;
	}
}