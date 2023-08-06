import java.util.*;
class Solution {
    static boolean[] visited;
    static int maxCnt = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
        goDun(0, 0, k, dungeons);
        
        answer=maxCnt;
        return answer;
    }
    
    static public void goDun(int v, int cnt, int k, int[][] dungeons){ // 확인완료 던전 v, 방문 던전 수 cnt
        if (v== dungeons.length){
            if (cnt>maxCnt) maxCnt=cnt;
            return;
        }
        for (int i=0; i<dungeons.length; i++){
            if (!visited[i]){
                visited[i]=true;
                if (dungeons[i][0]<=k){
                    goDun(v+1, cnt+1, k-dungeons[i][1], dungeons);
                } else {
                    goDun(v+1, cnt, k, dungeons);
                }
                visited[i]=false;
            }
        }
    }
}