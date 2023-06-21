import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, M;
	static int[] doll;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		doll = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			doll[i] = Integer.parseInt(st.nextToken());
		}
		////////////
		findfirst();
//		System.out.println(M);
		
		if (M!=-1) findMin();
		
		System.out.println(M);
	}
	private static void findfirst() {
		int st=-1;
		for (int i=0; i<N; i++) {
			if (doll[i]==1) {
				st=i;
				break;
			}
		}
		if (st==-1) {
			M=-1;
			return;
		}
		int ed=st;
		int cnt=1;
		while (cnt<K && ed<N-1) {
			ed++;
			if (doll[ed]==1) cnt++;
		}
		if (cnt<K) {
			M=-1;
		} else {
			M = ed-st+1;
		}
	}
	private static void findMin() {
		boolean flag=true;
		while (flag) {
			M--;
//			System.out.println("M: "+M);
			int st=0; 
			int cnt=0;
			for (int i=0; i<M; i++) {
				if (doll[i]==1) cnt++;
			}
//			System.out.println("cnt: "+cnt);
			if (cnt<K) {
				flag=false;
				while (st<=N-M) {
//					System.out.println("st: "+st);
					if (doll[st]==1) {
						cnt--;
					}
					st++;
					if (st+M<=N && doll[st+M-1]==1) {
						cnt++;
					}
//					System.out.println("inner cnt: "+cnt);
					if (cnt>=K) {
						flag=true;
						break;
					}
				}
			}
		}
		if (!flag) M++;
	}
}
