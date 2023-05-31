import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n; // 전체 사람의 수
	static int a, b; // 두 사람 번호
	static int m; // 관계의 개수
	static List<Integer> rel[];
	static int[] visited;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		rel = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			rel[i]=new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
			rel[x].add(y); rel[y].add(x);
		}
		
		visited = new int[n+1];
		findchon(a, b);
		if (visited[b]==0) {
			System.out.println(-1);
		} else {
			System.out.println(visited[b]);
		}
	}
	private static void findchon(int a, int b) {
		Stack<Integer> stack = new Stack<>();
		stack.add(a);
		while(!stack.isEmpty()) {
			int top = stack.pop();
//			System.out.println("top: "+top);
//			System.out.println("stack: "+stack);
			for (int i: rel[top]) {
				if (visited[i]==0) {
					stack.add(i);
					visited[i]=visited[top]+1;
					if (i==b) return;
				}
			}
		}
	}
}
