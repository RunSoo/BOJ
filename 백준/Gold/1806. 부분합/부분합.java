import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] iArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			iArr[i]=Integer.parseInt(st.nextToken());
		}
		int f = 0; int e=0;
		int minLen = N;
		
		int sum=0;
		for (int i=f; i<N; i++) {
			sum+=iArr[i];
		}
		
		if (sum<S) {
			System.out.println(0);
		} else {
			sum=iArr[0];
			while (f<=e) {
//				System.out.println("minLen: "+minLen+", sum: "+sum+", f: "+f+", e: "+e);
				while(sum<S && e<N-1) {
					sum+=iArr[++e];
				}
				if (e==N-1 && sum<S) break;
				while (f<=e && sum>=S) {
					sum-=iArr[f++];
				}
				
				minLen = Math.min(minLen, e-f+2);
				
				if ((f==N-2 && e==N-1) || (f==N-1 && e==N-1)) break;
			}
			System.out.println(minLen);
		}
	}
}
