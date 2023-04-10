import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cntArr = new int[N+1];
		cntArr[1]=0;
		if (N>=2) {
			cntArr[2]=1;			
		}
		if (N>=3) {
			cntArr[3]=1;			
		}
		for (int i=4; i<=N; i++) {
			cntArr[i]=cntArr[i-1]+1;
			if (i%2==0 && i%3==0) cntArr[i]=Math.min(cntArr[i], Math.min(cntArr[i/2]+1, cntArr[i/3]+1));
			else if (i%2==0) cntArr[i]=Math.min(cntArr[i], cntArr[i/2]+1);
			else if (i%3==0) cntArr[i]=Math.min(cntArr[i], cntArr[i/3]+1);
		}
		System.out.println(cntArr[N]);
	}
}