import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int[] result = new int[number.length+1];
        for (int i=0; i<number.length; i++){
            result[i]=number[i];
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<number.length; i++){
            map.put(want[i], i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<discount.length; i++){
            if (map.containsKey(discount[i])){
                queue.add(map.get(discount[i]));
            } else {
                queue.add(number.length);
            }
        }
        
        // System.out.println(queue);
        
        int[] here = new int[result.length];
        
        Queue<Integer> tmp = new LinkedList<>();
        for (int i=0; i<10; i++){
            int in = queue.poll();
            tmp.add(in);
            here[in]++;
        }
        
        boolean[] equal = new boolean[here.length];
        int equals = 0;
        for (int i=0; i<equal.length; i++){
            if (result[i]==here[i]){
                equal[i]=true;
                equals++;
            } else {
                equal[i]=false;
            }
        }
        if (equals==want.length+1){
            answer++;
        }
        // System.out.println(equals);
        // System.out.println(Arrays.toString(here));
        
        while (!queue.isEmpty()){
            int out = tmp.poll();
            here[out]--;
            if (equal[out]){
                equal[out]=false;
                equals--;
            } else if (here[out]==result[out]){
                equal[out]=true;
                equals++;
            }
            int in = queue.poll();
            tmp.add(in);
            here[in]++;
            if (equal[in]){
                equal[in]=false;
                equals--;
            } else if (here[in]==result[in]){
                equal[in]=true;
                equals++;
            }
            if (equals==want.length+1) answer++;
            // System.out.println(equals);
            // System.out.println(Arrays.toString(here));
        }
        
        return answer;
    }
}