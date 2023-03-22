import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static int N;
	public static int K;
	public static int[] arr;
	public static int[] tmp;
	public static int count;
	public static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		merge_sort(0,arr.length-1);
		System.out.println(result==0?"-1":result);
	}
	
	public static void merge_sort(int start, int end) {
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
			if (arr[i]<=arr[j]) {
				tmp[k++]=arr[i++];
				count++;
				if (count==K) result=tmp[k-1];
			} else {
				tmp[k++]=arr[j++];
				count++;
				if (count==K) result=tmp[k-1];
			}
		}
		while (i<=mid) {
			tmp[k++]=arr[i++];
			count++;
			if (count==K) result=tmp[k-1];
		}
		while (j<=end) {
			tmp[k++]=arr[j++];
			count++;
			if (count==K) result=tmp[k-1];
		}
		for (int idx=start; idx<=end; idx++) {
			arr[idx]=tmp[idx];
		}
	}
}