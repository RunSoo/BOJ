import java.util.Scanner;

public class Main {
	static int N;
	static boolean[][] chess;
	static int[] queen;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new boolean[N][N];
		queen = new int[N];
		result=0;
		dfs(0);
		
		System.out.println(result);
	}
	private static void dfs(int nr) {
		if (nr==N) {
			result++;
			return;
		}
		
		if (nr>0) {
			for (int c=0; c<N; c++) {
				boolean flag=true;
				for (int ir=0; ir<nr; ir++) {
					if (queen[ir]==c || ir-nr==queen[ir]-c || ir-nr==c-queen[ir]) {
						flag=false;
						break;
					}
				}
				if (flag) {
					queen[nr]=c;
					dfs(nr+1);
				}
			}
		} else {
			for (int c=0; c<N; c++) {
				queen[nr]=c;
				dfs(nr+1);
			}
		}
	}
}