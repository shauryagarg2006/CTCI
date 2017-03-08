package ctci.prac.stacks;

public class Stack<T> {
	Node<T> head;

	private static class Node<T> {
		Node next;
		T data;

		public Node(T input) {
			this.data = input;
			this.next = null;
		}
	}

	public Stack() {
		head = null;
	}

	public void push(T input) {
		Node<T> temp = new Node<T>(input);
		if (head == null)
			head = temp;
		else {
			temp.next = head;
			head = temp;
		}
	}

	public T pop() {
		T result;
		if (head == null) {
			throw new NullPointerException();
		} else {
			result = head.data;
			head = head.next;
		}
		return result;
	}

	public T peek() {
		if (head == null) {
			throw new NullPointerException();
		} else {
			return head.data;
		}
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		Node<T> iter = head;
		StringBuffer result = new StringBuffer();
		while (iter != null) {
			result.append("-->" + iter.data);
		}
		return result.toString();
	}
}
