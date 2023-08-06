import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        int[] dc = {-1, 0};
        
        dp[0][0]=triangle[0][0];
        
        for (int r=0; r<n; r++){
            for (int c=0; c<=r; c++){
                for (int d=0; d<2; d++){
                    int pr = r-1;
                    int pc = c+dc[d];
                    if (pr>=0 && pc>=0){
                        dp[r][c]=Math.max(dp[r][c], dp[pr][pc]+triangle[r][c]);
                    }
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        for (int c=0; c<n; c++){
            answer = Math.max(dp[n-1][c], answer);
        }
                    
        return answer;
    }
}