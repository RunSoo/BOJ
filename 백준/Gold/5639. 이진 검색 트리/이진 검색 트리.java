import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public void insert(int x) {
			if (x<this.data) {
				if (this.left==null) {
					this.left = new Node(x);
				} else {
					this.left.insert(x);
				}
			} else {
				if (this.right==null) {
					this.right = new Node(x);
				} else {
					this.right.insert(x);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node Root=new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String input = br.readLine();
			if (!isInteger(input)) break;
			Root.insert(Integer.parseInt(input));
		}
		
		postOrder(Root);
	}
	
	public static void postOrder(Node node) {
		if (node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}