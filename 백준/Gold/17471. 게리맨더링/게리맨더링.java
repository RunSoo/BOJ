import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] pop;
	static int min;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pop = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			pop[i] = sc.nextInt();
		}
		for (int n = 0; n <= N; n++) {
			graph[n] = new ArrayList<>();
		}
		for (int n = 1; n <= N; n++) {
			int tmp = sc.nextInt();
			for (int t = 0; t < tmp; t++) {
				int a = sc.nextInt();
				graph[n].add(a);
			}
		}
//        System.out.println(Arrays.toString(graph));
		min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			visited = new boolean[N + 1];
			arr = new int[i];
			dfs(i, 1, 0);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void dfs(int total, int num, int k) {
		if (k == total) {
			int[] arrTmp = new int[total];
			for (int i = 0; i < total; i++) {
				arrTmp[i] = arr[i];
			}
//            System.out.println(Arrays.toString(arrTmp));
			visited = new boolean[N + 1];
			bfs(arrTmp);
			return;
		}
		for (int i = num; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[k] = i;
				dfs(total, i + 1, k + 1);
				visited[i] = false;
			}
		}
	}

	private static void bfs(int[] arrTmp) {
		int[] area1 = new int[arrTmp.length];
		for (int i = 0; i < arrTmp.length; i++) {
			area1[i] = arrTmp[i];
			visited[area1[i]] = true;
		}
		int[] area2 = new int[N - arrTmp.length];
		int n = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				area2[n++] = i;
			}
		}
//		System.out.println("-----area1-----");
//		System.out.println(Arrays.toString(area1));
//		System.out.println("-----area2-----");
//		System.out.println(Arrays.toString(area2));
		visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(area1[0]);
		visited[area1[0]] = true;
		int cnt1 = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();
//			System.out.println("----x----");
//			System.out.println(x);
			cnt1++;
			for (int a : graph[x]) {
				if (!visited[a] && inThere(a, area1)) {
					queue.add(a);
					visited[a] = true;
				}
			}
		}

		Queue<Integer> queue2 = new LinkedList<>();
		int cnt2 = 0;
		queue2.add(area2[0]);
		visited[area2[0]] = true;
		while (!queue2.isEmpty()) {
			int x = queue2.poll();
			cnt2++;
			for (int a : graph[x]) {
				if (!visited[a] && inThere(a, area2)) {
					queue2.add(a);
					visited[a] = true;
				}
			}
		}

//		System.out.println("-----cnt1-----");
//		System.out.println(cnt1);
//		System.out.println("-----cnt2-----");
//		System.out.println(cnt2);
		if (cnt2 == area2.length && cnt1 == area1.length) {

			int tmp1 = 0;
			int tmp2 = 0;
			for (int a : area1) {
				tmp1 += pop[a];
			}
			for (int a : area2) {
				tmp2 += pop[a];
			}
			if (min > Math.abs(tmp1 - tmp2)) {
//				System.out.println("여기서 바뀌었어요");
				min = Math.abs(tmp1 - tmp2);
			}

		}
		visited=new boolean[N+1]	;
	}

	private static boolean inThere(int a, int[] area) {
		for (int x : area) {
			if (x == a) {
				return true;
			}
		}
		return false;
	}

}