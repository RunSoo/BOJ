import java.util.*;

class Solution {
    static int[][][] dp;
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int answer = 0;
        
        N = board.length;
        dp = new int[4][N][N];
        for (int dir=0; dir<4; dir++){
            for (int r=0; r<N; r++){
                for (int c=0; c<N; c++){
                    dp[dir][r][c]=Integer.MAX_VALUE;
                }
            }
        }
        
        for (int dir=0; dir<4; dir++){
            dp[dir][0][0]=0;
        }
        
        bfs(board);
        
        // for (int dir=0; dir<4; dir++){
        //     System.out.println("---"+dir+"---");
        //     System.out.println(Arrays.deepToString(dp[dir]));
        // }
        
        answer = Integer.MAX_VALUE;
        for (int dir=0; dir<4; dir++){
            answer = Math.min(answer, dp[dir][N-1][N-1]);
        }
            
        return answer;
    }
    
    static void bfs(int[][] board){
        Queue<Integer[]> q = new LinkedList<>();
        for (int dir=0; dir<4; dir++){
            q.add(new Integer[]{0, 0, dir});
        }
        while(!q.isEmpty()){
            Integer[] top = q.poll();
            
            // System.out.println("top: "+Arrays.toString(top));
            
            if (!(top[0]==N-1 && top[1]==N-1)){
                for (int d=0; d<4; d++){
                    int nr = top[0]+dr[d];
                    int nc = top[1]+dc[d];
                    if (nr>=0 && nr<N && nc>=0 && nc<N && board[nr][nc]==0){
                        if (d==top[2]){
                            int cost = dp[top[2]][top[0]][top[1]]+100;
                            if (dp[d][nr][nc]==Integer.MAX_VALUE || dp[d][nr][nc]>cost){
                                dp[d][nr][nc]=cost;
                                q.add(new Integer[]{nr, nc, d});
                            }
                        } else {
                            int cost = dp[top[2]][top[0]][top[1]]+600;
                            if (dp[d][nr][nc]==Integer.MAX_VALUE || dp[d][nr][nc]>cost){
                                dp[d][nr][nc]=cost;
                                q.add(new Integer[]{nr, nc, d});
                            }
                        }
                    }
                }
            }
        }
        
    }
}