import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> list[];
	static int[] parent;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); list[b].add(a);
		}
		parent = new int[N+1];
		parent[1]=1;
		find();
		for (int i=2; i<N+1; i++) {
			System.out.println(parent[i]);
		}
	}
	private static void find() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int i=0; i<list[top].size(); i++) {
				if (parent[list[top].get(i)]==0) {
					parent[list[top].get(i)]=top;
					queue.add(list[top].get(i));
				}
			}
		}
	}
}
