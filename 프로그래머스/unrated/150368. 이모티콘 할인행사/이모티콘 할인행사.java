import java.util.*;

class Solution {
    static int maxprice, maxpeop;
    static int[] emoticon;
    static int[][] user;
    public int[] solution(int[][] users, int[] emoticons) {
        emoticon = new int[emoticons.length];
        user = new int[users.length][2];
        
        emoticon = Arrays.copyOf(emoticons, emoticons.length);
        for (int i=0; i<users.length; i++){
            user[i]=Arrays.copyOf(users[i], users[i].length);
        }
        int[] sale = new int[emoticons.length];
        maxpeop=0;
        maxprice=0;
        
        int[] answer;
        
        dfs(0, sale);
        
        answer=new int[]{maxpeop, maxprice};
        
        return answer;
    }
    private static void dfs(int idx, int[] sale) {
		if (idx==emoticon.length){
            int[] result = calculate(sale);
            System.out.println(Arrays.toString(result));
            if (result[0]==maxpeop){
                maxprice=Math.max(result[1], maxprice);
            } else if (result[0]>maxpeop){
                maxpeop=result[0];
                maxprice=result[1];
            }
            return;
        }
        for (int i=1; i<=4; i++){
            sale[idx]=i*10;
            dfs(idx+1, sale);
        }
    }
    
    public static int[] calculate(int[] sale){
        int[] result = new int[2];
        int peop=0;
        int price=0;
        for (int i=0; i<user.length; i++){
            int myprice=0;
            for (int j=0; j<emoticon.length; j++){
                if (sale[j]>=user[i][0]){
                    myprice+=emoticon[j]*(100-sale[j])/100;
                }
            }
            if (myprice>=user[i][1]){
                peop++;
            } else {
                price+=myprice;
            }
        }
        result = new int[]{peop, price};
        return result;
    }
}