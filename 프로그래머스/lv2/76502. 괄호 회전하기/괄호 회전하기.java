import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        
        for (int i=0; i<s.length(); i++){
            String sub1 = s.substring(0, 1);
            String sub2 = s.substring(1, s.length());
            s = sub2+sub1;
            if (correctCnt(s)){
                answer++;
            }
            // System.out.println(s+", "+answer);
        }
        
        
        return answer;
    }
    public static boolean correctCnt(String str){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)=='[' || str.charAt(i)=='(' || str.charAt(i)=='{'){
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                else if (!stack.isEmpty() && ((str.charAt(i)==']' && stack.peek()=='[') || (str.charAt(i)==')' && stack.peek()=='(') || (str.charAt(i)=='}' && stack.peek()=='{'))){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}