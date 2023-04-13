import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> brokenButtonList=new ArrayList<>();
		for(int m = 0 ; m<M;m++) {
			int brokenButton = sc.nextInt();
			brokenButtonList.add(brokenButton);
		}
		int min = Math.abs(100-N);
		
		for(int i = 0 ; i<=999999;i++) {
			String str = String.valueOf(i);
			boolean check = true;
			for(int k = 0 ; k<str.length();k++) {
				if(brokenButtonList.contains(str.charAt(k)-'0')) {
					check=false;break;
				}
			}
			if(check==false) continue;
			
			min = Math.min(min, str.length()+Math.abs(i-N));
		}
		System.out.println(min);
	}
}