import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int n = 1;
			TreeMap<Integer, Integer> map = new TreeMap<>();
			while (n <= N) {
				String str = sc.next();
				int num = sc.nextInt();
				if (str.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if (map.isEmpty()) {
						n++;
						continue;
					}
					int tmp = num == 1 ? map.lastKey() : map.firstKey();
//					if (map.get(tmp) == 1) {
//						map.remove(tmp);
//					}else {
//						map.put(tmp, map.get(tmp) -1);						
//					}
					if(map.put(tmp, map.get(tmp)-1)==1)
						map.remove(tmp);
				}
				n++;
			}
			System.out.println(map.isEmpty() == true ? "EMPTY" : map.lastKey() + " " + map.firstKey());
		}
	}
}