import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] house;
	public static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				house[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		Dfs(0, 1, 0);
		System.out.println(count);
	}
	public static void Dfs(int r, int c, int d) {
		if (r==N-1 && c==N-1) {
			count++;
			return;
		}
		switch(d) {
		case 0:
			if (c+1<N && house[r][c+1]==0) {
				Dfs(r, c+1, 0);
			}
			break;
		case 1:
			if (r+1<N && house[r+1][c]==0) {
				Dfs(r+1, c, 1);
			}
			break;
		case 2: 
			if (c+1<N && house[r][c+1]==0) {
				Dfs(r, c+1, 0);
			}
			if (r+1<N && house[r+1][c]==0) {
				Dfs(r+1, c, 1);
			}
			break;
		}
		if (c+1<N && r+1<N && house[r][c+1]==0 && house[r+1][c]==0 && house[r+1][c+1]==0) {
			Dfs(r+1, c+1, 2);
		}
	}
}