import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 종이 크기 10 * 10
	// 각 색종이 5개씩 (1~5)
	// 색종이 최소 개수
	static int[][] map;
	static int[] paper;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int r=0; r<10; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<10; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		paper = new int[6]; // 0 인덱스 비우고 쓸꺼임
		for (int i=1; i<6; i++) {
			paper[i]=5;
		}
		
		min = Integer.MAX_VALUE;
		dfs(0);
		
		
		
		if (min!=Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
	}
	private static void dfs(int cnt) {
		// 이 전까지는 했다고 치고
		// 이 시점에서 부터 첫 1을 찾자
		int nr=-1;
		int nc=-1;
		outer: for (int r=0; r<10; r++) {
			for (int c=0; c<10; c++) {
				if (map[r][c]==1) {
					nr=r; nc=c;
					break outer;
				}
			}
		}
//		for (int r=0; r<10; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		
		
		if (cnt>=min) {
			return;
		}
		
		if (nr==-1 && nc==-1) {
//			System.out.println("nr: "+nr+", nc: "+nc+", cnt: "+cnt);
			min = Math.min(min, cnt);
			return;
		}
		
		
		// 최대 크기 몇짜리 색종이 덮을 수 있는지
		int maxSize = getMaxSize(nr, nc);
//		System.out.println("maxSize: "+maxSize);
		
		// 최대 크기로 덮는 것 부터 최소 크기로 덮는 것 까지
		for (int size=maxSize; size>=1; size--) {
			if (nr==5 && nc==9) {
//				System.out.println(size);
			}
			if (paper[size]!=0) {
				for (int r=nr; r<nr+size; r++) {
					for (int c=nc; c<nc+size; c++) {
						map[r][c]=0;
					}
				}
				paper[size]--;
				// 색종이 개수 하나 늘려서 보내고
				dfs(cnt+1);
				// 다시 되돌림
				for (int r=nr; r<nr+size; r++) {
					for (int c=nc; c<nc+size; c++) {
						map[r][c]=1;
					}
				}
				paper[size]++;
			}
		}
	}
	private static int getMaxSize(int nr, int nc) {
		int maxsize=1;
		for (int size=5; size>=2; size--) {
			boolean flag=true;
			if (nr+size>10 || nc+size>10) {
				continue;
			}
			outer: for (int r=nr; r<nr+size; r++) {
				for (int c=nc; c<nc+size; c++) {
					if (r>=0 && r<10 && c>=0 && c<10 && map[r][c]!=1) {
						flag=false;
						break outer;
					}
				}
			}
			if (flag==true) {
				maxsize=size;
				break;
			}
		}
		return maxsize;
		
	}
}