import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int result;
	static Map<Integer, List<Integer>> friends= new HashMap<Integer, List<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++) {
			friends.put(i,new ArrayList<>());
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends.get(a).add(b);
			friends.get(b).add(a);
		}
		result = 0;
		visited = new boolean[N];
		for (int i=0; i<N; i++) {
			if (visited[i]==false) {
				dfs(i, 0);
				if (result==1) { 
					break;
				}
			}
			
		}
		System.out.println(result);
	}
	private static void dfs(int person, int step) {
		 if (step==4) {
			 result=1;
			 return;
		 }
		 
		 if (visited[person]==true) return;
		
		 visited[person]=true;
		 for (int i=0; i<friends.get(person).size(); i++) {
			 if (visited[friends.get(person).get(i)]) continue;
			 dfs(friends.get(person).get(i), step+1);
		 }
		 visited[person]=false;
	}
	
}