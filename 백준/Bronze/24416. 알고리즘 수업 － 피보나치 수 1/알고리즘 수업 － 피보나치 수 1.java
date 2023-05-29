import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, type1, type2;
	static int[] t2;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		type1=1; type2=0;
		fibo1(N);
		t2 = new int[N+1];
		t2[1]=1; t2[2]=1;
		fibo2(3);
		System.out.println(type1+" "+type2);
	}
	private static int fibo1(int n) {
		if (n==1 || n==2) {
			return 1;
		}
		type1++;
		return fibo1(n-1)+fibo1(n-2);
	}
	private static void fibo2(int n) {
		type2++;
		t2[n]=t2[n-1]+t2[n-2];
		if (n==N) return;
		fibo2(n+1);
	}
}
