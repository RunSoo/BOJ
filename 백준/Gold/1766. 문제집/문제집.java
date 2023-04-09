import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] list;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		list = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			list[i1].add(i2); 
			indegree[i2
			         ]++;
		}
		
		topologicalsort();
	}
	private static void topologicalsort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=1; i<=N; i++) {
			if (indegree[i]==0) {
				pq.add(i);
			}
		}
		while (!pq.isEmpty()) {
			int top = pq.poll();
			System.out.print(top+" ");
			for (Integer i: list[top]) {
				indegree[i]--;
				if (indegree[i]==0) pq.add(i);
			}
		}
	}
}