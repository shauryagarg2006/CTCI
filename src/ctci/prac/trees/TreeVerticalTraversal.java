package ctci.prac.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Node {
	Node left;
	Node right;
	int data;
	public Node(int val){
		data = val;
		left = null;
		right = null;
	}
}
//	   		1
//		  /   \
//	     2      3
//      / \    / \
//	   4   5  6   7
//      	   \   \
//   	        8   9 
public class TreeVerticalTraversal {

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
		Map<Integer, List<Integer>> result = new TreeMap<Integer, List<Integer>>();
		dfs(root, result, 0);
		for (Entry<Integer, List<Integer>> entryset : result.entrySet()) {
			List<Integer> values = entryset.getValue();
			System.out.println(values);
		}
	}

	public static void dfs(Node root, Map<Integer, List<Integer>> result, int column) {
		if (root == null) {
			return;
		}
		if (!result.containsKey(column)) {
			result.put(column, new ArrayList<Integer>());
		}
		result.get(column).add(root.data);
		dfs(root.left, result, column - 1);
		dfs(root.right, result, column + 1);

	}

}
