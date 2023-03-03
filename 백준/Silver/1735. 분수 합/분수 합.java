import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int a3 = a1*b2+a2*b1;
		int b3 = b1*b2;
		
		int c = Math.min(a3, b3);
		for (int i=2; i<Math.sqrt(c)+1; i++) {
			while (a3%i==0 && b3%i==0) {
				a3/=i;
				b3/=i;
			}
		}
		System.out.println(a3+" "+b3);
	}
}