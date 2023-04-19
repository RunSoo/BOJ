import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] stuff = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0]=Integer.parseInt(st.nextToken());
			stuff[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int[][] val = new int[N][K+1]; // 0부터 K 가치까지
		for (int j=0; j<=K; j++) {
			if (stuff[0][0]<=j) val[0][j]=stuff[0][1];
		}
		for (int i=1; i<N; i++) {
			for (int j=0; j<=K; j++) {
				if (stuff[i][0]<=j) val[i][j]=stuff[i][1];
				val[i][j]=Math.max(val[i][j], val[i-1][j]);
				if (j-stuff[i][0]>=0) {
					val[i][j]=Math.max(val[i-1][j-stuff[i][0]]+stuff[i][1], val[i][j]);					
				}
			}
		}
//		System.out.println(Arrays.deepToString(val));
		System.out.println(val[N-1][K]);
	}
}