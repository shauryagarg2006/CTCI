package test;

class Node {
	int data = 0;

	public Node(int data) {
		this.data = data;
	}
}

public class Nodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node(10);
		Node b = new Node(20);
		Node c = new Node(30);
		Node d = a;
		a = b;
		System.out.println(d.data);
		System.out.println(a.data);
		

	}

}
