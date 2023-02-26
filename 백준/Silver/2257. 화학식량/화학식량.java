import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] chArr = str.toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<chArr.length; i++) {
			if (chArr[i]=='(') {
				stack.push(0);
			} else if (chArr[i]==')') {
				stack.push(0);
				if (i+1<chArr.length && !Character.isDigit(chArr[i+1])) {
					stack.pop();
					int tmp=0;
					while (stack.peek()!=0) {
						tmp+=stack.pop();
					}
					stack.pop();
					stack.add(tmp);
				}
			} else if (Character.isAlphabetic(chArr[i])) {
				if (chArr[i]=='C') {
					stack.add(12);
				} else if (chArr[i]=='O') {
					stack.add(16);
				} else {
					stack.add(1);
				}
			} else {
				int times = chArr[i]-'0';
				if (stack.peek()==0) {
					stack.pop();
					int tmp = stack.pop();
					if (tmp!=0) {
						while (stack.peek()!=0) {
							tmp+=stack.pop();
						}
						stack.pop();
						stack.add(tmp*times);
					}
				} else {
					int tmp = stack.pop();
					tmp*=times;
					stack.add(tmp);
				}
			}
		}
		while(stack.size()!=1) {
			int tmp = stack.pop();
			tmp+=stack.pop();
			stack.add(tmp);
		}
		System.out.println(stack.pop());
	}
}