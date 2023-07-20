class Solution {
    public int solution(int n) {
        int answer = 0;
        int fromOne = 0;
        int fromSum=0;
        while (n>fromSum){
            fromOne++;
            fromSum+=fromOne;
        }
        for (int i=fromOne; i>0; i--){ // fromSum-1개부터 1개로 이루어진 것 까지 있는지 확인
            // 짝수개라면?
            if (i%2==0){
               int j=i/2;
                if ((n+j)%i==0) answer++;
            } else {
                if (n%i==0) answer++;
            }
        }
        
        return answer;
    }
}