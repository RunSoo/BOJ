import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // int[] answer = {};
        // String str1 = "06:00";
        // String str2 = "09:00";
        // System.out.println(timeDiff(str1, str2));
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        for (int i=0; i<records.length; i++){
            String[] tmpStr = records[i].split(" ");
            if (!map.containsKey(tmpStr[1])){
                map.put(tmpStr[1], tmpStr[0]);
            } else {
                int time = timeDiff(map.get(tmpStr[1]), tmpStr[0]);
                if (!timeMap.containsKey(tmpStr[1])){
                    timeMap.put(tmpStr[1], time);
                } else {
                    timeMap.replace(tmpStr[1], timeMap.get(tmpStr[1])+time);
                }
                map.remove(tmpStr[1]);
            }
        }
        Set<String> set = map.keySet();
        for (String s : set){
            int time = timeDiff(map.get(s), "23:59");
            if (!timeMap.containsKey(s)){
                timeMap.put(s, time);
            } else {
                timeMap.replace(s, timeMap.get(s)+time);
            }
        }
        
        Set<String> result = timeMap.keySet();
        String[] resultArr = new String[result.size()];
        int idx=0;
        for (String s: result){
            resultArr[idx++]=s;
        }
        
        Arrays.sort(resultArr);
        
        int[] answer = new int[resultArr.length];
        
        for (int i=0; i<resultArr.length; i++){
            answer[i]=price(timeMap.get(resultArr[i]), fees[0], fees[1], fees[2], fees[3]);
        }
        
        System.out.println(Arrays.toString(resultArr));
        System.out.println(timeMap);
        
        return answer;
    }
    static public int timeDiff(String str1, String str2){
        String[] strArr1 = str1.split(":");
        String[] strArr2 = str2.split(":");
        int hour1 = Integer.valueOf(strArr1[0]);
        int hour2 = Integer.valueOf(strArr2[0]);
        int min1 = Integer.valueOf(strArr1[1]);
        int min2 = Integer.valueOf(strArr2[1]);
        if (hour1>hour2){
            return (hour1-hour2)*60+min1-min2;
        } 
        return (hour2-hour1)*60+min2-min1;
    }
    
    static public int price(int P, int basicTime, int basicPrice, int nextTime, int nextPrice){
        int result=0;
        if (P<=basicTime){
            return basicPrice;
        } else {
            int tmpInt = (P-basicTime+nextTime-1)/nextTime;
            return (basicPrice+nextPrice*tmpInt);
        }
    }
}