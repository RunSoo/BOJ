import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static boolean result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        result = false;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);

            if (result) {
                System.out.println(1);
                return;
            }

            visited[i] = false;
        }

        System.out.println(0);
    }

    private static void dfs(int cur, int depth) {
        if (depth == 4) {
            result = true;
            return;
        }

        for (int next : graph[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}