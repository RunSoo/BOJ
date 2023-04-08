import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static List<Integer>[] list;
	static int[] node;
	static boolean[] visited;
	static List<Integer> apple;
	static boolean[] eatapple;
	static int maxcnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i=0; i<N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			list[i1].add(i2); list[i2].add(i1);
		}
		node = new int[N];
		apple = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			node[i]=Integer.parseInt(st.nextToken());
			if (node[i]==1) apple.add(i);
		}
		maxcnt=0;
		eatapple = new boolean[apple.size()];
		if (apple.contains(0)) {
			eatapple[apple.indexOf(0)]=true;
			applecombi(1, 1);
		} else {
			applecombi(0, 0);
		}	
		System.out.println(maxcnt);
	}
	private static void applecombi(int idx, int cnt) {
		if (cnt==Math.min(K, apple.size())) {
//			System.out.println(Arrays.toString(eatapple));
			maxcnt = Math.max(maxcnt, bfs());
			return;
		}
		if (idx==apple.size()) return;
		eatapple[idx]=true;
		applecombi(idx+1, cnt+1);
		eatapple[idx]=false;
		applecombi(idx+1, cnt);
		
	}
	private static int bfs() {
		int pcnt=0;
		visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		visited[0]=true;
		if (node[0]==2) pcnt++;
		queue.add(0);
		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (Integer i: list[top]) {
				if (!visited[i]) {
					if (node[i]==1) {
						if (eatapple[apple.indexOf(i)]) {
							visited[i]=true;
							queue.add(i);
						}
					} else if (node[i]==2) {
						pcnt++;
//						System.out.println(pcnt);
						visited[i]=true;
						queue.add(i);
					} else if (node[i]==0) {
						visited[i]=true;
						queue.add(i);
					}
				}
			}
		}
		return pcnt;
	}
}