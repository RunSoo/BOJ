import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] solutions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			solutions[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(solutions);
		int f = 0; int e = N-1;
		int acid = 0; int alchaly = N-1;
		int diff=Integer.MAX_VALUE;
		while (f<e) {
			int tmp = solutions[f]+solutions[e];
			if (Math.abs(tmp)<Math.abs(diff)) {
				diff=tmp;
			}
//			System.out.println(tmp+", "+f+", "+e);
			if (diff==tmp) {
				acid=f; alchaly=e;
			}
			if (tmp>0) {
				e--;
			} else {
				f++;
			}
		}
		System.out.println(solutions[acid]+" "+solutions[alchaly]);
	}
}