import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        
        for (int i=0; i<n-1; i++){ // 끊을 전선
            boolean[] connectedTo1 = new boolean[n+1];
            connectedTo1[1]=true;
            int cnt = 1;
            int curr = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(curr);
            while(!queue.isEmpty()){
                curr = queue.poll();
                for (int j=0; j<n-1; j++){
                    if (i!=j){
                        if (wires[j][0]==curr && !connectedTo1[wires[j][1]]){
                            connectedTo1[wires[j][1]]=true;
                            cnt++;
                            System.out.println(cnt+", "+wires[j][1]);
                            queue.add(wires[j][1]);
                        } else if (wires[j][1]==curr && !connectedTo1[wires[j][0]]){
                            connectedTo1[wires[j][0]]=true;
                            cnt++;
                            System.out.println(cnt+", "+wires[j][0]);
                            queue.add(wires[j][0]);
                        }
                    }
                }
            }
            answer = Math.min(Math.abs(2*cnt-n), answer);
        }
        
        return answer;
    }
}