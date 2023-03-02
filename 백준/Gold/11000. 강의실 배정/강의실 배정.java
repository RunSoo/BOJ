import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] times = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(times, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}
			}
		});
		
		for (int i=0; i<N; i++) {
			if (pq.size()>0 && pq.peek()<=times[i][0]) {
				pq.poll();
			}
			pq.add(times[i][1]);
		}
		System.out.println(pq.size());
	}
}