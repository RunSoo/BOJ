import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N][3];
		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<3; c++) {
				nums[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		///////////////////////입력 끝
		int[][] dpmax = new int[N][3];
		int[][] dpmin = new int[N][3];
		for (int c=0; c<3; c++) {
			dpmax[0][c]=nums[0][c];
			dpmin[0][c]=nums[0][c];
		}
		if (N>1) {
			for (int r=1; r<N; r++) {
				dpmax[r][0] = Math.max(dpmax[r-1][0], dpmax[r-1][1])+nums[r][0];
				dpmin[r][0] = Math.min(dpmin[r-1][0], dpmin[r-1][1])+nums[r][0];
				dpmax[r][1] = Math.max(dpmax[r-1][0], Math.max(dpmax[r-1][1], dpmax[r-1][2]))+nums[r][1];
				dpmin[r][1] = Math.min(dpmin[r-1][0], Math.min(dpmin[r-1][1], dpmin[r-1][2]))+nums[r][1];
				dpmax[r][2] = Math.max(dpmax[r-1][1], dpmax[r-1][2])+nums[r][2];
				dpmin[r][2] = Math.min(dpmin[r-1][1], dpmin[r-1][2])+nums[r][2];
			}
		}
//		System.out.print(Arrays.deepToString(dpmax));
//		System.out.println(Arrays.deepToString(dpmin));
		System.out.print(Math.max(dpmax[N-1][0], Math.max(dpmax[N-1][1], dpmax[N-1][2]))+" ");
		System.out.println(Math.min(dpmin[N-1][0], Math.min(dpmin[N-1][1], dpmin[N-1][2])));
	}
}