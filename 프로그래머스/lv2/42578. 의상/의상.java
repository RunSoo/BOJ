import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++){
            if (map.containsKey(clothes[i][1])){
                map.replace(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        // System.out.println(map);
        
        List<Integer> valueList = new ArrayList<>(map.values());
        
        System.out.println(valueList);
        
        if (valueList.size()>0){
            answer=1;
            for (int i=0; i<valueList.size(); i++){
                answer*=valueList.get(i)+1;
            }
            answer-=1;
        }
        
        return answer;
    }
}