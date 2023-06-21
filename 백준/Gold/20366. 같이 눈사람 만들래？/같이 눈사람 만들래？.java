import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] snow = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			snow[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snow);
		int min = Integer.MAX_VALUE
				;
		for (int al=0; al<N-3; al++) {
			for (int ar=al+3; ar<N; ar++) {
				int el = al+1; int er=ar-1;
				while (el<er) {
					int anna = snow[al]+snow[ar];
					int elsa = snow[el]+snow[er];
					int result = anna-elsa;
					min = Math.min(Math.abs(result), min);
					if (result<0) er--;
					else el++;
				}
			}
		}
		System.out.println(min);
	}
}