import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int len = words.length;
        List<String> list = new ArrayList<>();
        int person = 0;
        int round = 0;
        
        for (int i=0; i<len; i++){
            // 앞에꺼 끝난 글자랑 내꺼 맨 앞글자 일치여부
            boolean flag=true;
            if (i>0){
                char prev=words[i-1].charAt(words[i-1].length()-1);
                char now = words[i].charAt(0);
                if (prev!=now){
                    flag=false;
                }
            }
            if (!list.contains(words[i]) && words[i].length()>1 && flag){
                list.add(words[i]);
            } else{
                person=i%n+1;
                round=i/n+1;
                break;
            }
        }
        
        int[] answer = {person, round};
        return answer;
    }
}