class Solution {
    static long[] answerArr;
    public long solution(int n) {
        long answer = 0;
        
        answerArr = new long[n+1];
        if (n>0){
            answerArr[1]=1L;
        }
        if (n>1){
            answerArr[2]=2L;
        }
        
        if (n>2){
            for (int i=3; i<=n; i++){
            answerArr[i]=(answerArr[i-1]+answerArr[i-2])%1234567;
            }
        }
        
        answer=answerArr[n];
        
        return answer;
    }
}