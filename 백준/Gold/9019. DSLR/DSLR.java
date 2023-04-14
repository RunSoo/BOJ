import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int A, B;
	static int min;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			
			bfs(A, "");
			
		}
		System.out.println(sb);
		br.close();
	}

	private static void bfs(int num, String ans) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(num, ans));
		visited[num]=true;
		while (!queue.isEmpty()) {
			// 각각의 bfs친구들을 호출하자!
			Node nodeTmp = queue.poll();
			int x = nodeTmp.a;
			String y = nodeTmp.b;
			String xStr = String.valueOf(x);
			String xStr0 = "";
			String xStr1 = "";
			String xStr2 = "";
			String xStr3 = "";
			if (xStr.length() == 1) {
				xStr3 = String.valueOf(xStr.charAt(0));
				xStr1 = xStr2 = xStr0 = "0";
			} else if (xStr.length() == 2) {
				xStr0 = xStr1 = "0";
				xStr2 = String.valueOf(xStr.charAt(0));
				xStr3 = String.valueOf(xStr.charAt(1));
			} else if (xStr.length() == 3) {
				xStr0 = "0";
				xStr1 = String.valueOf(xStr.charAt(0));
				xStr2 = String.valueOf(xStr.charAt(1));
				xStr3 = String.valueOf(xStr.charAt(2));
			} else if (xStr.length() == 4) {
				xStr0 = String.valueOf(xStr.charAt(0));
				xStr1 = String.valueOf(xStr.charAt(1));
				xStr2 = String.valueOf(xStr.charAt(2));
				xStr3 = String.valueOf(xStr.charAt(3));
			}
			if (x == B) {
				sb.append(y + "\n");
				return;
			}
			// 1. D :
			if (!visited[2 * x % 10000]) {
				queue.add(new Node(2 * x % 10000, y + "D"));
				visited[2 * x % 10000] = true;
			}
			// 2. L :
			if (!visited[Integer.parseInt(xStr1 + xStr2 + xStr3 + xStr0)]) {
				queue.add(new Node(Integer.parseInt(xStr1 + xStr2 + xStr3 + xStr0), y + "L"));
				visited[Integer.parseInt(xStr1 + xStr2 + xStr3 + xStr0)] = true;
			}
			// 3. R :
			if (!visited[Integer.parseInt(xStr3 + xStr0 + xStr1 + xStr2)]) {
				queue.add(new Node(Integer.parseInt(xStr3 + xStr0 + xStr1 + xStr2), y + "R"));
				visited[Integer.parseInt(xStr3 + xStr0 + xStr1 + xStr2)] = true;
			}
			// 4.S :
			if (x == 0) {
				if (!visited[9999]) {
					queue.add(new Node(9999, y + "S"));
					visited[9999] = true;
					continue;
				}
			} else {
				if (!visited[x - 1]) {
					queue.add(new Node(x - 1, y + "S"));
					visited[x - 1] = true;
				}
			}
		}

	}

	static class Node {
		int a;
		String b;

		public Node(int a, String b) {
			this.a = a;
			this.b = b;
		}
	}
}