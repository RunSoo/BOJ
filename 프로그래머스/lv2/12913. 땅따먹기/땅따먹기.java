import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(Arrays.deepToString(land));
        int N = land.length;
        int[][] dp = new int[N][4];
        for (int c=0; c<4; c++){
            dp[0][c]=land[0][c];
        }
        for (int r=1; r<N; r++){
            for (int c=0; c<4; c++){
                int max=0;
                for (int prev=0; prev<4; prev++){
                    if (prev!=c){
                        max=Math.max(max, dp[r-1][prev]);
                    }
                }
                dp[r][c]=max+land[r][c];
            }
        }
        int max = 0;
        for (int c=0; c<4; c++){
            max=Math.max(max, dp[N-1][c]);
        }
        answer=max;

        return answer;
    }
}