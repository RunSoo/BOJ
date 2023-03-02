import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int K;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.pow(2, K)];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for (int f=1; f<=K; f++) {
			sort(f, K);
		}
		
		int idx=0;
		for (int i=0; i<K; i++) {
			for (int j=0; j<(int)Math.pow(2, i); j++) {
				sb.append(list.get(idx++)+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void sort(int f, int K) {
		for (int i=0; i<(int)Math.pow(2, f-1); i++) {
			list.add(arr[(int)Math.pow(2, K-f)+i*(int)Math.pow(2, K-f+1)]);
		}
	}
}