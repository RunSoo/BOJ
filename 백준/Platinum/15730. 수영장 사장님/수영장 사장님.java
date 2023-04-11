import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sum, maxHeight;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int n = 0; n < N; n++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(n==0||m==0||n==N-1||m==M-1) {
				pq.add(new Node(n, m, arr[n][m]));
				visited[n][m]=true;
				}
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node nodeTmp = pq.poll();
//			System.out.println(nodeTmp.toString());
			for(int i = 0 ; i<4;i++) {
				int nr = nodeTmp.a+dr[i];
				int nc = nodeTmp.b+dc[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc]) {
					if(arr[nr][nc]<nodeTmp.c) {
						cnt+=nodeTmp.c-arr[nr][nc];
					}
					pq.add(new Node(nr, nc, Math.max(arr[nr][nc], nodeTmp.c)));
					visited[nr][nc]=true;
				}
			}
			
		}
		System.out.println(cnt);
		
	}
	static class Node implements Comparable<Node>{
		
		int a;
		int b;
		int c;
		private Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return this.c-o.c;
		}@Override
		public String toString() {
			return "["+this.a+", "+this.b+", "+this.c+"]";
		}
		
	}
	
}