import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int C;
	public static int[][] connect;
	public static boolean[] caught;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		connect = new int[2*C][2];
		for (int i=0; i<C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connect[2*i][0]=a;
			connect[2*i][1]=b;
			connect[2*i+1][0]=b;
			connect[2*i+1][1]=a;
		}
		caught = new boolean[N+1];
		caught[1]=true;
		virus(1);
		int cnt=0;
		for (int i=1; i<=N; i++) {
			if (caught[i]) cnt++;
		}
		System.out.println(cnt-1);
	}
	
	public static void virus(int idx) {
		for (int i=0; i<2*C; i++) {
			if (connect[i][0]==idx) {
				if (!caught[connect[i][1]]) {
					caught[connect[i][1]]=true;
					virus(connect[i][1]);
				}
			}
		}
	}
}