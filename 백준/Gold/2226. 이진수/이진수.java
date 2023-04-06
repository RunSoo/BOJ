import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger[] cntzero;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cntzero = new BigInteger[N+1]; // 1번 인덱스부터 시작
		cntzero[1]=BigInteger.ZERO;
		dp(N);
		
		System.out.println(cntzero[N]);
		
	}
	private static BigInteger dp(int n) {
		if (n==1 || cntzero[n]!=null) {
			return cntzero[n]; 
		}
		BigInteger bigNum1 = new BigInteger("1");
		BigInteger bigNum2 = new BigInteger("2");
		
		if (n%2==0) {
			return cntzero[n]=dp(n-1).multiply(bigNum2).add(bigNum1);
		} else {
			return cntzero[n]=dp(n-1).multiply(bigNum2).subtract(bigNum1);
		}
	}
}