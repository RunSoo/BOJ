import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int[] iArr = new int[sArr.length];
        for (int i=0; i<sArr.length; i++){
            iArr[i]=Integer.parseInt(sArr[i]);
        }
        
        Arrays.sort(iArr);
        
        String answer = "";
        answer+=(iArr[0]+" ");
        answer+=(iArr[iArr.length-1]);
        return answer;
    }
}