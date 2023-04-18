import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수

		if (T>0) {
			p = new int[N+1];
			for (int i=1; i<=N; i++) {
				p[i]=i;
			}
			for (int i=0; i<T; i++) {
				p[Integer.parseInt(st.nextToken())]=-1;
			}
			boolean[] party = new boolean[M];
			List<Integer>[] list = new ArrayList[M];
			for (int i=0; i<M; i++) {
				list[i]=new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				int len = Integer.parseInt(st.nextToken());
				for (int j=0; j<len; j++) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			////////
			for (int i=0; i<M; i++) {
				for (int j=0; j<list[i].size()-1; j++) {
					union(list[i].get(j), list[i].get(j+1));
				}
			}
			
			for (int i=0; i<M; i++) {
				for (int j=0; j<list[i].size(); j++) {
					if (p[list[i].get(j)]==-1) {
						party[i]=true;
						break;
					}
				}
			}
			
			int cnt=0;
			for (int i=0; i<M; i++) {
				if (!party[i]) cnt++;
			}
			System.out.println(cnt);
		} else {
			System.out.println(M);
		}
	}

	private static void union(Integer i1, Integer i2) {
		if (p[i1]==p[i2]) return;
		else if (p[i1]==-1) {
			int target=p[i2];
			for (int i=0; i<p.length; i++) {
				if (p[i]==target) {
					p[i]=-1;
				}
			}
		} else if (p[i2]==-1) {
			int target=p[i1];
			for (int i=0; i<p.length; i++) {
				if (p[i]==target) {
					p[i]=-1;
				}
			}
		} else {
			int target=p[i2];
			for (int i=0; i<p.length; i++) {
				if (p[i]==target) p[i]=p[i1];
			}
		}
		
	}
}
