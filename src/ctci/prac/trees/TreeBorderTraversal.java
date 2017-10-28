package ctci.prac.trees;

//	   		1
//		  /   \
//	     2      3
//      / \    / \
//	   4   5  6   7
//      	   \   \
//   	        8   9 
public class TreeBorderTraversal {

	public static void main(String[] args) {

		// Initialize a tree;
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.right.right.right = new Node(9);
		root.right.left.right = new Node(8);

		traverse(root);
	}

	public static void traverse(Node root) {
		if(root!=null){
			System.out.println(root.data);
		dfsLeft(root.left);
		dfsMid(root.left);
		dfsMid(root.right);
		dfsRight(root.right);
		}
		
	}

	public static void dfsLeft(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null || root.right != null)
			System.out.println(root.data);
		dfsLeft(root.left);
	}

	public static void dfsMid(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null)
			System.out.println(root.data);
		dfsMid(root.left);
		dfsMid(root.right);
	}

	public static void dfsRight(Node root) {
		if (root == null) {
			return;
		}

		dfsLeft(root.right);
		if (root.left != null || root.right != null)
			System.out.println(root.data);
	}

}
