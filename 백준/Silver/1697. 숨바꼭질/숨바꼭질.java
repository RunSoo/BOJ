import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] place;
	static int minTime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int len = Math.max(N, K);
		place = new int[2*len+1];
//		for (int i=0; i<=2*len; i++) {
//			place[i]=Integer.MAX_VALUE;
//		}
		find();
//		System.out.println(Arrays.toString(place));
		System.out.println(place[K]);
	}
	private static void find() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		place[N]=0;
		while(!queue.isEmpty()) {
//			System.out.println("queue: "+queue);
			int top = queue.poll();
			if (top==K) continue;
			if (top-1>=0 && place[top-1]==0) {
//				System.out.println(top+"-1");
				place[top-1]=place[top]+1;
				queue.add(top-1);
			}
			if (top+1<place.length && place[top+1]==0) {
//				System.out.println(top+"+1");
				place[top+1]=place[top]+1;
				queue.add(top+1);
			}
			if (top*2<place.length && place[top*2]==0) {
//				System.out.println(top+"*2");
				place[top*2]=place[top]+1;
				queue.add(top*2);
			}
		}
	}
}
