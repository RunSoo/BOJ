import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static char[][] candy;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		for (int r=0; r<N; r++) {
			candy[r]=br.readLine().toCharArray();
		}
		
		int maxNum=Integer.MIN_VALUE;
		
		for (int r=0; r<N; r++) {
			for (int c=1; c<N; c++) {
				swap(r, c-1, r, c);
				maxNum=Math.max(maxNum, maxCandy());
				swap(r, c-1, r, c);
			}
		}
		
		for (int c=0; c<N; c++) {
			for (int r=1; r<N; r++) {
				swap(r-1, c, r, c);
				maxNum=Math.max(maxNum, maxCandy());
				swap(r-1, c, r, c);
			}
		}
		
		System.out.println(maxNum);
	}
	
	public static void swap(int r1, int c1, int r2, int c2) {
		char tmp=candy[r1][c1];
		candy[r1][c1]=candy[r2][c2];
		candy[r2][c2]=tmp;
	}
	
	public static int maxCandy() {
		int num=1;
		int maxNum=Integer.MIN_VALUE;
		for (int r=0; r<N; r++) {
			for (int c=1; c<N; c++) {
				if (candy[r][c-1]==candy[r][c]) {
					num++;
				} else {
					if (maxNum<num) maxNum=num;
					num=1;
				}
			}
			if (maxNum<num) maxNum=num;
			num=1;
		}
		
		for (int c=0; c<N; c++) {
			for (int r=1; r<N; r++) {
				if (candy[r-1][c]==candy[r][c]) {
					num++;
				} else {
					if (maxNum<num) maxNum=num;
					num=1;
				}
			}
			if (maxNum<num) maxNum=num;
			num=1;
		}
		return maxNum;
	}
}