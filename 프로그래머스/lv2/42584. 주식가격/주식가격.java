import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer[]> stack = new Stack<>();
        for (int i=0; i<prices.length; i++){
            if (stack.isEmpty() || stack.peek()[1]<=prices[i]){
                stack.add(new Integer[]{i, prices[i]});
            } else {
                Integer[] top = stack.pop();
                answer[top[0]] = i-top[0];
                while (!stack.isEmpty() && stack.peek()[1]>prices[i]){
                    top = stack.pop();
                    answer[top[0]] = i-top[0];
                }
                stack.add(new Integer[]{i, prices[i]});
            }
        }
        while (!stack.isEmpty()){
            Integer[] top = stack.pop();
            answer[top[0]] = prices.length-1-top[0];
        }
        
        return answer;
    }
}