import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int V;
	public static int[][] nodes;
	public static boolean[] visited;
	public static String dfsStr="";
	public static String bfsStr="";
	public static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		nodes = new int[2*M][2];
		
		visited = new boolean[N+1];
		for (int r=0; r<M; r++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			nodes[2*r][0]=a;
			nodes[2*r][1]=b;
			nodes[2*r+1][0]=b;
			nodes[2*r+1][1]=a;
		}
		
		Arrays.sort(nodes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]) {
					return o1[1]-o2[1];
				} else {
					return o1[0]-o2[0];
				}
			}
		});
		
		dfs(V);
		System.out.println(dfsStr);
		visited = new boolean[N+1];
		bfs();
		System.out.println(bfsStr);
	}
	
	public static void dfs(int idx) {
		visited[idx]=true;
		dfsStr+=idx+" ";
		for (int r=0; r<2*M; r++) {
			if (nodes[r][0]==idx && visited[nodes[r][1]]==false) {
				dfs(nodes[r][1]);
			}
		}
	}
	
	public static void bfs() {
		queue.add(V);
		visited[V]=true;
		while (!queue.isEmpty()) {
			int top = queue.poll();
			bfsStr+=top+" ";
			
			for (int r=0; r<2*M; r++) {
				if (nodes[r][0]==top && visited[nodes[r][1]]==false) {
					queue.add(nodes[r][1]);
					visited[nodes[r][1]]=true;
				}
			}
		}
		
	}
	
}