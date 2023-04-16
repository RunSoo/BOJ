import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		///////////////
		result = new int[M];
		Arrays.sort(nums);
		visited = new boolean[N];
		getResult(0);
	}
	private static void getResult(int idx) {
		if (idx==M) {
			for (int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				result[idx]=nums[i];
				visited[i]=true;
				getResult(idx+1);
				visited[i]=false;
			}
		}
		
	}
}
