import java.util.*;
import java.lang.*;
class Solution {
    static int result = 0;
    static Map<Character, Integer> map = new HashMap<>();
    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        result=0;
        
        int answer = 0;
        
        countLine(0, n, data);
        
        answer=result;
        
        return answer;
    }
    
    public void countLine(int idx, int n, String[] data){
        if (idx==8){
            if (checkCondition(n, data)){
                result++;
            }
            return;
        }
        
        for (int i=0; i<8; i++){
            if (!map.containsKey(friends[i])){
                map.put(friends[i], idx);
                countLine(idx+1, n, data);
                map.remove(friends[i]);
            }
        }
    }
    public boolean checkCondition(int n, String[] data){
        for (int i=0; i<n; i++){
            char[] condition = data[i].toCharArray();
            if (condition[3]=='=' && Math.abs(map.get(condition[0])-map.get(condition[2]))-1!=condition[4]-'0') {
                return false;
            }
            else if (condition[3]=='<' && Math.abs(map.get(condition[0])-map.get(condition[2]))-1>=condition[4]-'0') {
                return false;
            }
            else if (condition[3]=='>' && Math.abs(map.get(condition[0])-map.get(condition[2]))-1<=condition[4]-'0') {
                return false;
            }
        }
        return true;
    }
}