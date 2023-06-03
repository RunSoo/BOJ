import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pick = new int[M];
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i=0; i<M; i++) {
			pick[i]=Integer.parseInt(st.nextToken());
		}
		for (int i=1; i<=N; i++) {
			deque.offer(i);
		}
		int cnt=0;
		for (int i=0; i<M; i++) {
//			System.out.println(deque);
			int idx = deque.indexOf(pick[i]);
			int mid;
			if (deque.size()%2==0) {
				mid=deque.size()/2-1;
			}
			else {
				mid=deque.size()/2;
			}
			if (idx<=mid) {
				for (int j=0; j<idx; j++) {
					int tmp = deque.pollFirst();
					deque.offerLast(tmp);
					cnt++;
				}
			}
			else {
				for (int j=0; j<deque.size()-idx; j++) {
					int tmp = deque.pollLast();
					deque.offerFirst(tmp);
					cnt++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(cnt);
		
	}
}
