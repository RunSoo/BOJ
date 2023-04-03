import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, cnt, cntTotal;
	static int[][] arr;
	static Node node;
	static int[] dr, dc;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dr = new int[] { 1, 0, 0, 1 };
		dc = new int[] { 0, -1, 1, 0 };
		arr = new int[N][N];
		for (int n = 0; n < N; n++) {
			String str = sc.next();
			for (int m = 0; m < N; m++) {
				arr[n][m] = str.charAt(m) - 48;
			}
		}
		cntTotal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					cntTotal++;
					bfs(i, j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cntTotal);
		for (int i : list) {
			System.out.println(i);
		}
	}

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}
	}

	private static void bfs(int i, int j) {
		cnt = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j));
		arr[i][j]=0;
		cnt++;
		while (!queue.isEmpty()) {
			Node nodeTmp = queue.poll();

			int x = nodeTmp.i;
			int y = nodeTmp.j;
			if (x + 1 < N && arr[x + 1][y] == 1) {
				queue.add(new Node(x + 1, y));
				arr[x + 1][y] = 0;
				cnt++;
			}
			if (x - 1 >= 0 && arr[x - 1][y] == 1) {
				queue.add(new Node(x - 1, y));
				arr[x - 1][y] = 0;
				cnt++;
			}
			if (y + 1 < N && arr[x][y + 1] == 1) {
				queue.add(new Node(x, y + 1));
				arr[x][y + 1] = 0;
				cnt++;
			}
			if (y - 1 >= 0 && arr[x][y - 1] == 1) {
				queue.add(new Node(x, y - 1));
				arr[x][y - 1] = 0;
				cnt++;
			}
		}
		list.add(cnt);
	}
}