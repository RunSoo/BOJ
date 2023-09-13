import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int cntO = 0;
        int cntX = 0;
        
        char[][] tik = new char[3][3];
        for (int r=0; r<3; r++){
            tik[r]=board[r].toCharArray();
            for (int c=0; c<3; c++){
                if (tik[r][c]=='O') cntO++;
                else if (tik[r][c]=='X') cntX++;
            }
        }
        
        // System.out.println(cntO+", "+cntX);
        
        if (!(cntO==cntX || cntO-1==cntX)){
            answer=0;
        } else {
            answer=0;
            outer: for (int r=0; r<3; r++){
                for (int c=0; c<3; c++){
                    char tmp = tik[r][c];
                    tik[r][c]='.';
                    if (isValid(tik)){
                        // System.out.println(r+", "+c);
                        answer=1;
                        break outer;
                    }
                    tik[r][c]=tmp;
                }
            }
        }
        
        
        
        return answer;
    }
    static boolean isValid(char[][] tik){
        int cntO=0;
        int cntX=0;
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                if (tik[r][c]=='O') cntO++;
                else if (tik[r][c]=='X') cntX++;
            }
        }
        if (!(cntO==cntX || cntO-1==cntX)) return false;
        
        for (int r=0; r<3; r++){
            if (tik[r][0]=='O' && tik[r][1]=='O' && tik[r][2]=='O') return false;
            if (tik[r][0]=='X' && tik[r][1]=='X' && tik[r][2]=='X') return false;
            if (tik[0][r]=='O' && tik[1][r]=='O' && tik[2][r]=='O') return false;
            if (tik[0][r]=='X' && tik[1][r]=='X' && tik[2][r]=='X') return false;
        }
        if (tik[0][0]=='O' && tik[1][1]=='O' && tik[2][2]=='O') return false;
        if (tik[0][0]=='X' && tik[1][1]=='X' && tik[2][2]=='X') return false;
        if (tik[0][2]=='O' && tik[1][1]=='O' && tik[2][0]=='O') return false;
        if (tik[0][2]=='X' && tik[1][1]=='X' && tik[2][0]=='X') return false;
        
        return true;
    }
}