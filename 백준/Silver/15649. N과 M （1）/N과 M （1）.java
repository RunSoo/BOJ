import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static boolean[] visited;
	public static int[] result;
	public static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		result = new int[M];
		num = new int[N];
		for (int i=0; i<N; i++) {
			num[i]=i+1;
		}
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int idx) {
		if (idx==M) {
			for (int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0; i<N; i++) {
			if (visited[i]) continue;
			result[idx]=num[i];
			visited[i]=true;
			perm(idx+1);
			visited[i]=false;
		}
	}
}