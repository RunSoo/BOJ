import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cntArr = new int[N];
		cntArr[0]=1;
		if (N>1) cntArr[1]=2;
		if (N>2) {
			for (int i=2; i<N; i++) {
				cntArr[i]=(cntArr[i-1]%10007+cntArr[i-2]%10007)%10007;
			}
		}
		System.out.println(cntArr[N-1]);
	}
}