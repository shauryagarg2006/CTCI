package ctci.prac.stacks;

public class Queue<T> {
	Node<T> head;
	Node<T> tail;

	private static class Node<T> {
		Node next;
		T data;

		public Node(T input) {
			this.data = input;
			this.next = null;
		}
	}

	public Queue() {
		head = null;
		tail = null;
	}

	public void enqueue(T data) {
		Node<T> temp = new Node<T>(data);
		if (head == null && tail == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public T dequeue() {
		if (head == null) {
			return null;
		} else {
			T data = head.data;
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return data;
		}

	}

	public T peek() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}

}