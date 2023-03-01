import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dots = new int[3][2];
		for (int r=0; r<3; r++) {
			for (int c=0; c<2; c++) {
				dots[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		if (dots[1][0]!=dots[2][0] && dots[0][0]!=dots[1][0]) {
			if ((dots[1][1]-dots[2][1])*(dots[0][0]-dots[1][0])==(dots[0][1]-dots[1][1])*(dots[1][0]-dots[2][0])) {
				System.out.println(-1.0);
			} else {
				double a = Math.sqrt((double)Math.pow(dots[0][0]-dots[1][0], 2)+(double)Math.pow(dots[0][1]-dots[1][1], 2));
				double b = Math.sqrt((double)Math.pow(dots[0][0]-dots[2][0], 2)+(double)Math.pow(dots[0][1]-dots[2][1], 2));
				double c = Math.sqrt((double)Math.pow(dots[1][0]-dots[2][0], 2)+(double)Math.pow(dots[1][1]-dots[2][1], 2));
				double max = Math.max(a+b, Math.max(b+c, c+a));
				double min = Math.min(a+b, Math.min(b+c, c+a));
				System.out.println(2*(max-min));
			}
		} else {
			if (dots[0][0]==dots[1][0] && dots[1][0]==dots[2][0]) {
				System.out.println(-1.0);
			} else {
				double a = Math.sqrt((double)Math.pow(dots[0][0]-dots[1][0], 2)+(double)Math.pow(dots[0][1]-dots[1][1], 2));
				double b = Math.sqrt((double)Math.pow(dots[0][0]-dots[2][0], 2)+(double)Math.pow(dots[0][1]-dots[2][1], 2));
				double c = Math.sqrt((double)Math.pow(dots[1][0]-dots[2][0], 2)+(double)Math.pow(dots[1][1]-dots[2][1], 2));
				double max = Math.max(a+b, Math.max(b+c, c+a));
				double min = Math.min(a+b, Math.min(b+c, c+a));
				System.out.println(2*(max-min));
			}
		}
	}
}