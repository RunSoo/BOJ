import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int lastIdx=0;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N*N+1];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[++lastIdx]=Integer.parseInt(st.nextToken());
				int curr = lastIdx;
				while (curr>1 && arr[curr]>arr[curr/2]) {
					swap(curr, curr/2);
					curr = curr/2;
				}
			}
		}
		for (int i=0; i<N-1; i++) {
			swap(1, lastIdx);
			arr[lastIdx--]=0;
			int curr=1;
			while (true) {
				int child = curr*2;
				if (curr*2+1<=lastIdx) {
					if (arr[child]<arr[curr*2+1]) {
						child = curr*2+1;
					}
				}
				
				if (child>lastIdx || arr[child]<arr[curr]) {
					break;
				}
				swap(child, curr);
				curr = child;
			}
		}
		System.out.println(arr[1]);
	
	}
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}