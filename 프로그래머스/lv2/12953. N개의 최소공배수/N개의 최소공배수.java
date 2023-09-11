import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        // 두 수의 최소공배수 먼저 찾기
        int LCM = arr[arr.length-1];
        
        System.out.println(Arrays.toString(arr));
        for (int i=arr.length-1; i>=0; i--){
            LCM = findLCM(arr[i], LCM);
        }
        answer=LCM;
        
        return answer;
    }
    static public int findLCM(int a, int b){
        if (b%a==0) return b;

        for (int i=2; i<=a; i++){
            if ((b*i)%a==0){
                return b*i;
            }
        }
        return a*b;
    }
}