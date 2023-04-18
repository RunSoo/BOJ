import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int k=0;
        while(n>=1){
            if (n%2==0){
                n/=2;
            } else{
                k++;
                n--;
            }
        }
        ans=k;
        
        return ans;
    }
}