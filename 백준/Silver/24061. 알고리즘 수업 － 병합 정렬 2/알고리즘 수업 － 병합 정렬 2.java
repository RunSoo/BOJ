import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] tmp;
	static int[] result;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tmp = new int[N];
		result = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0, N-1);
		StringBuilder sb = new StringBuilder();
		if (count<K) {
			sb.append("-1");
		} else {
			for (int i=0; i<N; i++) {
				sb.append(result[i]+" ");
			}
		}
		System.out.println(sb);
	}
	private static void merge_sort(int start, int end) {
		if (start<end) {
			int mid = (start+end)/2;
			merge_sort(start, mid);
			merge_sort(mid+1, end);
			merge(start, mid, end);
		}
		
	}
	private static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int k = start;
		while (i<=mid && j<=end) {
			if (arr[i]<arr[j]) {
				tmp[k++]=arr[i++];
				count++;
				if (count==K) {
					for (int idx=0; idx<N; idx++) {
						result[idx]=arr[idx];
					}
					for (int idx=start;idx<k; idx++) {
						result[idx]=tmp[idx];
					}
				}
			} else {
				tmp[k++]=arr[j++];
				count++;
				if (count==K) {
					for (int idx=0; idx<N; idx++) {
						result[idx]=arr[idx];
					}
					for (int idx=start;idx<k; idx++) {
						result[idx]=tmp[idx];
					}
				}
			}
			
		}
		while (i<=mid) {
			tmp[k++]=arr[i++];
			count++;
			if (count==K) {
				for (int idx=0; idx<N; idx++) {
					result[idx]=arr[idx];
				}
				for (int idx=start;idx<k; idx++) {
					result[idx]=tmp[idx];
				}
			}
		}
		while (j<=end) {
			tmp[k++]=arr[j++];
			count++;
			if (count==K) {
				for (int idx=0; idx<N; idx++) {
					result[idx]=arr[idx];
				}
				for (int idx=start;idx<k; idx++) {
					result[idx]=tmp[idx];
				}
			}
		}
		for (int idx=start; idx<=end; idx++) {
			arr[idx]=tmp[idx];
		}
	}
}