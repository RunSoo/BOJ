import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long L = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long H = Long.parseLong(st.nextToken());
		
		double start=0;
		double end=Math.min(L, Math.min(W, H));
		for (int i=0; i<50000; i++) {
			double mid = (start+end)/2;
			long num = (long)(H/mid)*(long)(L/mid)*(long)(W/mid);
//			System.out.println("start: "+start+", end: "+end+", mid: "+mid+", num: "+num);
			if (num<N) {
				end=mid;
			} else {
				start=mid;
			}
		}
		System.out.println(start);
	}
}