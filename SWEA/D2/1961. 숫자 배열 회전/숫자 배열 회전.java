import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+"\n");
			N = Integer.parseInt(br.readLine());
			int[][] nums = new int[N][N];
			for (int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					nums[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			int[][] ninety = turn90(nums);
			int[][] oneeighty = turn90(ninety);
			int[][] twoseventy = turn90(oneeighty);
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					sb.append(ninety[r][c]);
				}
				sb.append(" ");
				for (int c=0; c<N; c++) {
					sb.append(oneeighty[r][c]);
				}
				sb.append(" ");
				for (int c=0; c<N; c++) {
					sb.append(twoseventy[r][c]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	public static int[][] turn90(int[][] nums) {
		int[][] turned = new int[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				turned[c][N-1-r]=nums[r][c];
			}
		}
		return turned;
	}
}