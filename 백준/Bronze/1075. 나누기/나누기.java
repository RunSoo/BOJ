import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		System.out.println(getEvery(N, F));
	}
	
	public static String getEvery(int N, int F) {
		char[] givN = (N+"").toCharArray();
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				givN[givN.length-2]=(char) (i+'0');
				givN[givN.length-1]=(char)(j+'0');
				String tmp="";
				for (int k=0; k<givN.length; k++) {
					tmp +=givN[k]+"";
				}
				int num = Integer.parseInt(tmp);
				if (num%F==0) {
					return ""+givN[givN.length-2]+givN[givN.length-1];
				}
			}
		}
		return null;
	}
}