import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] chArr;
	static boolean[][][] visited;
	static int[] start;
	static int mincnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chArr = new char[N][M];
		start = new int[2];
		for (int r=0; r<N; r++) {
			chArr[r]=br.readLine().toCharArray();
			for (int c=0; c<M; c++) {
				if (chArr[r][c]=='0') {
					start[0]=r; start[1]=c;
				}
			}
		}
		visited = new boolean[N][M][1<<6]; 
		mincnt = Integer.MAX_VALUE;
		
		bfs(start[0], start[1]);
		
		if(mincnt!=Integer.MAX_VALUE) {
			System.out.println(mincnt);
		} else {
			System.out.println(-1);
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		// 3번째 인덱스는 몇번 이동했는지
		// 4번째 인덱스는 몇번 키를 갖고 있는지 (A~F)
		queue.add(new Integer[] {r, c, 0, Integer.parseInt("000000",2)});
//		visited[r][c]=true;
		while (!queue.isEmpty()) {
			Integer[] top = queue.poll();
//			System.out.println(top[0]+", "+top[1]+", "+top[2]+", "+top[3]);
			if (top[2]>mincnt) {
//				System.out.println("너무 많음");
				return;
			}
			
			if (chArr[top[0]][top[1]]=='1') {
//				System.out.println("top[2]: "+top[2]);
				mincnt = Math.min(mincnt, top[2]);
				return;
			}
			for (int d=0; d<4; d++) {
				int nr = top[0]+dr[d];
				int nc = top[1]+dc[d];
				// 벽 아니고 범위 내에 있음
				if (nr>=0 && nr<N && nc>=0 && nc<M && chArr[nr][nc]!='#') {
					if ((chArr[nr][nc]=='.' || chArr[nr][nc]=='0' || chArr[nr][nc]=='1') && !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					} else if (chArr[nr][nc]=='a' && !visited[nr][nc][top[3]|(1<<5)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<5)});
						visited[nr][nc][top[3]|(1<<5)]=true;
					} else if (chArr[nr][nc]=='b' && !visited[nr][nc][top[3]|(1<<4)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<4)});
						visited[nr][nc][top[3]|(1<<4)]=true;
					} else if (chArr[nr][nc]=='c' && !visited[nr][nc][top[3]|(1<<3)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<3)});
						visited[nr][nc][top[3]|(1<<3)]=true;
					} else if (chArr[nr][nc]=='d' && !visited[nr][nc][top[3]|(1<<2)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<2)});
						visited[nr][nc][top[3]|(1<<2)]=true;
					} else if (chArr[nr][nc]=='e' && !visited[nr][nc][top[3]|(1<<1)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<1)});
						visited[nr][nc][top[3]|(1<<1)]=true;
					} else if (chArr[nr][nc]=='f' && !visited[nr][nc][top[3]|(1<<0)]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]|(1<<0)});
						visited[nr][nc][top[3]|(1<<0)]=true;
					} else if (chArr[nr][nc]=='A' && !visited[nr][nc][top[3]]) {
						if ((top[3]&(1<<5))==(1<<5)) {
							queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
							visited[nr][nc][top[3]]=true;
						}
					} else if (chArr[nr][nc]=='B' && (top[3]&(1<<4))==(1<<4)&& !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					} else if (chArr[nr][nc]=='C' && (top[3]&(1<<3))==(1<<3)&& !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					} else if (chArr[nr][nc]=='D' && (top[3]&(1<<2))==(1<<2)&& !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					} else if (chArr[nr][nc]=='E' && (top[3]&(1<<1))==(1<<1)&& !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					} else if (chArr[nr][nc]=='F' && (top[3]&(1<<0))==(1<<0)&& !visited[nr][nc][top[3]]) {
						queue.add(new Integer[] {nr, nc, top[2]+1, top[3]});
						visited[nr][nc][top[3]]=true;
					}
				}
			}
		}
	}
}