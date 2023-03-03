import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+ " ");
			int N = Integer.parseInt(br.readLine());
			int[] stations = new int[5001];
			for (int bus=0; bus<N; bus++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				for (int i=A; i<=B; i++) {
					stations[i]++;
				}
			}
			int P = Integer.parseInt(br.readLine());
			for (int i=0; i<P; i++) {
				int t = Integer.parseInt(br.readLine());
				sb.append(stations[t]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}