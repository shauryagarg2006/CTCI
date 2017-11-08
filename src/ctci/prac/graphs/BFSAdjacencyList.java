package ctci.prac.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyList {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1 } };
		BFS(edges);
	}

	public static boolean BFS(int[][] edges) {
		int numVertex = edges.length;
		int[] status = new int[numVertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numVertex; i++) {
			if (status[i] == 0) {
				status[i] = 1;
				queue.add(i);
				bfscall(queue, status, edges);
			}
		}
		return false;

	}

	public static void bfscall(Queue<Integer> queue, int[] status, int[][] edges) {
		while (!queue.isEmpty()) {
			int curVertex = queue.poll();
			System.out.println("--> " + (curVertex + 1));
			for (int i = 0; i < edges.length; i++) {
				if (edges[curVertex][i] == 1 && status[i] == 0) {
					status[i] = 1;
					queue.add(i);
				}
			}
		}
	}

}