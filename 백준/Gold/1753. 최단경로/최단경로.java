import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int v, w;
		public Node(int v, int w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
		
	}
	
	static int V, E, K;
	static List<Node>[] adjList;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			adjList[i]=new ArrayList<>();
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
		}
		
//		for (int i=0; i<=V; i++) {
//			System.out.println(adjList[i]);
//		}
		
		dijkstra(K);
		
		for (int i=1; i<=V; i++) {
			if (dist[i]!=INF) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.w-o2.w;
			}
		});
		
		boolean[] check = new boolean[V+1];
		pq.add(new Node(start, 0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
//			System.out.println("pq: "+pq);
			Node currNode = pq.poll();
			int curr = currNode.v;
//			System.out.println(curr);
			
			if (check[curr]==true) continue;
			check[curr]=true;
			for (Node next : adjList[curr]) {
				int newDist = dist[currNode.v]+next.w;
				if (newDist<dist[next.v]) {
					dist[next.v]=newDist;
					pq.add(new Node(next.v, newDist));
				}
			}
		}
	}
}