import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		for (int r=0; r<N; r++) {
			char[] chArr = br.readLine().toCharArray();
			for (int c=0; c<M; c++) {
				A[r][c]=chArr[c]-'0';
			}
		}
		for (int r=0; r<N; r++) {
			char[] chArr = br.readLine().toCharArray();
			for (int c=0; c<M; c++) {
				B[r][c]=chArr[c]-'0';
			}
		}
		///////////////////////
		int cnt=0;
		for (int r=0; r<N-2; r++) {
			for (int c=0; c<M-2; c++) {
				if (A[r][c]!=B[r][c]) {
					cnt++;
					for (int dr=0; dr<3; dr++) {
						for (int dc=0; dc<3; dc++) {
//							if (r+dr>=0 && r+dr<N && c+dc>=0 && c+dc<M) {
								if (A[r+dr][c+dc]==0) {
									A[r+dr][c+dc]=1;
								} else {
									A[r+dr][c+dc]=0;
								}
//							}
						}
					}
				}
			}
		}
		boolean flag=true;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (A[r][c]!=B[r][c]) {
					flag=false;
				}
			}
		}
		if (flag) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
//		System.out.println(Arrays.deepToString(A));
//		System.out.println(Arrays.deepToString(B));
	}
}
