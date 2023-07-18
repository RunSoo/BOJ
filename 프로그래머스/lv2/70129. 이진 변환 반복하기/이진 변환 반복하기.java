import java.util.*;
class Solution {
    public int[] solution(String s) {
        char[] digits = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<digits.length; i++){
            list.add(digits[i]);
        }
        //System.out.println(list);
        int twocnt=0;
        int zerocnt=0;
        while(list.size()!=1){
            twocnt++;
            while(list.contains('0')){
                Iterator<Character> iterator = list.iterator();
                while(iterator.hasNext()){
                    if (iterator.next()=='0'){
                        iterator.remove();
                        zerocnt++;
                    }
                }
            }
            s = Integer.toBinaryString(list.size());
            list.clear();
            digits = s.toCharArray();
            for (int i=0; i<digits.length; i++){
                list.add(digits[i]);
            }
            System.out.println(list);
        }
        int[] answer = {twocnt, zerocnt};
        return answer;
    }
}