import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        StringBuilder answer = new StringBuilder();
        
        while (st.hasMoreTokens()){
            String word = st.nextToken();
            
            if (word.equals(" ")){
                answer.append(" ");
            } else {
                answer.append(Character.toUpperCase(word.charAt(0)));
                answer.append(word.substring(1).toLowerCase());
            }
        }
        
        return answer.toString();
    }
}