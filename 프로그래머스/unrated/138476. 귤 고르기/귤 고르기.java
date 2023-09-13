import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tangerine);
        
        int start=tangerine[0];
        int len = 0;
        for (int i=0; i<tangerine.length; i++){
            if (tangerine[i]==start){
                len++;
            } else {
                // System.out.println(i+", "+len+", "+map);
                if (map.containsKey(len)){
                    map.replace(len, map.get(len)+1);
                } else {
                    map.put(len, 1);
                }
                len=1;
                start=tangerine[i];
            }
        }
        if (map.containsKey(len)){
            map.replace(len, map.get(len)+1);
        } else {
            map.put(len, 1);
        }
                
        
        Set<Integer> set = map.keySet();
        int[] cntTangerine = new int[set.size()];
        int idx=0;
        for (Integer i:set){
            cntTangerine[idx++]=i;
        }
        
        Arrays.sort(cntTangerine);
        
        // System.out.println(map);
        
        outer: for (int i=idx-1; i>=0; i--){
            int cnt = map.get(cntTangerine[i]); 
            while (cnt!=0){
                k-=cntTangerine[i];
                map.replace(cntTangerine[i], cnt-1);
                answer++;
                if (k<=0){
                    break outer;
                }
                cnt--;
            }
        }
        
        return answer;
    }
}