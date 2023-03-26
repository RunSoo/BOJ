import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int[][] nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		nums = new int[N+1][N+1];
		for (int i=0; i<=N; i++) {
			nums[i][1]=i;
			nums[i][0]=1;
			nums[i][i]=1;
		}
		for (int i=2; i<=N; i++) {
			for (int j=1; j<i; j++) {
				nums[i][j]=nums[i-1][j]+nums[i-1][j-1];
				nums[i][j]%=10007;
			}
		}
		System.out.println(nums[N][K]);
	}
}