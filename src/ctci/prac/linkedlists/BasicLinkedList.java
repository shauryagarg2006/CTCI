package ctci.prac.linkedlists;

import java.util.Iterator;

class Index {
	int index = 0;
}

public class BasicLinkedList<T extends Comparable<T>> implements Iterable<T> {
	Node<T> head;

	private static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public BasicLinkedList() {
		head = null;
	}

	public T delete() {
		if (head == null) {
			return null;
		} else {
			T data = head.data;
			head = head.next;
			return data;
		}
	}

	public T insert(T data) {
		Node<T> temp = new Node<T>(data);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		return data;
	}

	public T head() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}

	public void removeDuplicates() {
		Node<T> iter = head;
		while (iter != null && iter.next != null) {
			Node<T> prev = iter;
			Node<T> curr = iter.next;
			while (curr != null) {
				if (curr.data == iter.data) {
					prev.next = curr.next;
				}
				prev = prev.next;
				curr = curr.next;
			}
			iter = iter.next;
		}

	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("");
		Node<T> iter = head;
		while (iter != null) {
			result.append("->" + iter.data);
			iter = iter.next;
		}
		return result.toString();
	}

	public T returnKLastElement(int k) {
		Index index = new Index();
		return returnKLastElementImpl(head, index, k);
	}

	private T returnKLastElementImpl(Node<T> head, Index index, int k) {
		if (head == null) {
			return null;
		}
		T result = returnKLastElementImpl(head.next, index, k);
		if (index.index == k) {
			result = head.data;
		}
		index.index++;
		return result;
	}

	public void partition(T value) {
		Node<T> curr = head;
		while (curr != null) {
			if (curr.data.compareTo(value) >= 0) {
				break;
			}
			curr = curr.next;
		}
		if (curr == null)
			return;
		Node<T> iter = curr;
		while (iter.next != null) {
			if (iter.next.data.compareTo(value) < 0) {
				T temp = curr.data;
				curr.data = iter.next.data;
				iter.next.data = temp;
				curr = curr.next;
			}
			iter = iter.next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> iter = head;

			@Override
			public boolean hasNext() {
				return iter != null;
			}

			@Override
			public T next() {
				T data = iter.data;
				iter = iter.next;
				return data;
			}
		};
	}

}
