import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1-i2;
            }
        });
        
        for (int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            if (pq.peek()>=K){
                break;
            }
            if (pq.size()==1){
                answer=-1;
                break;
            }
            int least = pq.poll();
            int least2 = pq.poll();
            int scov = least + (least2*2);
            pq.add(scov);
            answer++;
        }
        
        return answer;
    }
}