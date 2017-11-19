package ctci.prac.datastructures;

import java.util.Arrays;

public class BinaryHeap {
	int size = 0;
	int capacity = 10;
	int[] storage = new int[10];

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int newData) {
		if (size == capacity) {
			storage = Arrays.copyOf(storage, 2 * capacity);
			capacity *= 2;
		}
		storage[size] = newData;
		heapifyBottomUP(size);
		size++;
	}

	public int extractMin() {
		//TODO Null Check
		if (size == 0)
			throw new IllegalStateException();
		int result = storage[0];
		if (size > 1) {
			storage[0] = storage[size - 1];
			heapifyTopDown();
		}
		size--;
		return result;

	}

	private void heapifyTopDown() {
		int index = 0;
		while (index * 2 + 1 < size) {
			int curVal = storage[index];
			int left = storage[index * 2 + 1];
			int right = Integer.MAX_VALUE;
			if (index * 2 + 2 < size)
				right = storage[index * 2 + 2];
			int minVal = left;
			int minIndex = index * 2 + 1;
			if (right < left) {
				minVal = right;
				minIndex = index * 2 + 2;
			}
			if (curVal > minVal) {
				storage[index] = minVal;
				storage[minIndex] = curVal;
			} else {
				break;
			}
			index = minIndex;
		}

	}

	private void heapifyBottomUP(int index) {
		while ((index - 1) / 2 >= 0) {
			int parent = storage[(index - 1) / 2];
			int curVal = storage[index];
			if (parent > curVal) {
				storage[(index - 1) / 2] = curVal;
				storage[index] = parent;
			} else {
				break;
			}
			index = (index - 1) / 2;
		}
	}

}
