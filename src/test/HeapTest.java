package test;

import ctci.prac.datastructures.BinaryHeap;

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryHeap heap = new BinaryHeap();
		heap.insert(4);
		heap.insert(10);
		heap.insert(15);
		heap.insert(12);
		heap.insert(1);
		heap.insert(100);
		System.out.println(heap.isEmpty());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.isEmpty());

	}

}
