import java.io.*;
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] chArr = s.toCharArray();
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(Arrays.toString(chArr));
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<chArr.length; i++){
            if (chArr[i]=='('){
                queue.add(0);
            } else {
                if (!queue.isEmpty()){
                    queue.poll();
                } else {
                    answer=false;
                    break;
                }
            }
        }
        if (!queue.isEmpty()){
            answer=false;
        }
        
        return answer;
    }
}