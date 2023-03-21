import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<Integer, Integer> map = new HashMap<>(); 
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map.put(1, 0);
		map.put(2, 1);
		map.put(3, 1);
		System.out.println(getNum(N));
	}
	public static int getNum(int N) {
		if (map.containsKey(N)) {
			return map.get(N);
		} else {
			int result=0;
			if (N>3) {
				if (N%6==0) {
					result=Math.min(Math.min(getNum(N/2), getNum(N/3)), getNum(N-1))+1;
				} else if (N%3==0) {
					result=Math.min(getNum(N/3), getNum(N-1))+1;
				} else if (N%2==0) {
					result=Math.min(getNum(N/2), getNum(N-1))+1;
				} else {
					result=getNum(N-1)+1;
				}
			}
			map.put(N, result);
			return map.get(N);
		}
	}
}