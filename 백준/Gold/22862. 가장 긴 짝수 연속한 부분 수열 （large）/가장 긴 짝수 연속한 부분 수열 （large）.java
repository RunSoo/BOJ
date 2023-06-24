import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int f=0; int l=0;
		int even=0; int odd=0;
		int maxLen=0;
		if (nums[0]%2==0) {
			even++; maxLen++;
		}
		else odd++;
		while(f<=l) {
			while(odd<=K && l<N-1) {
//				System.out.println("even: "+even+", odd: "+odd+", maxLen: "+maxLen+", f: "+f+", l: "+l);
				if (nums[++l]%2!=0) {
					odd++;
				} else {
					even++;
				}
			}
			maxLen = Math.max(maxLen, even);
//			System.out.println("even: "+even+", odd: "+odd+", maxLen: "+maxLen+", f: "+f+", l: "+l);
			while (odd>K && f<=l) {
//				System.out.println("even: "+even+", odd: "+odd+", maxLen: "+maxLen+", f: "+f+", l: "+l);
				if (nums[f++]%2!=0) {
					odd--;
				} else {
					even--;
				}
			}
			if (l==N-1) {
//				System.out.println("break");
				break;
			}
		}
		System.out.println(maxLen);
	}
}
