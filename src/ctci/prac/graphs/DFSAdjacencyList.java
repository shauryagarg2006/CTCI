package ctci.prac.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSAdjacencyList {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1 } };
		DFS(edges.length, edges);
	}

	public static boolean DFS(int numCourses, int[][] prerequisites) {
		int[] status = new int[numCourses];
		List<Integer>[] edges = new LinkedList[numCourses];
		boolean result = false;
		for (int i = 0; i < numCourses; i++) {
			if (status[i] == 0) {
				if (dfscall(i, status, prerequisites)) {
					result = true;
				}
			}
		}
		return result;

	}

	public static boolean dfscall(int vertex, int[] status, int[][] edges) {
		status[vertex] = 1;
		System.out.println(" -> " + (vertex + 1));
		for (int iter = 0; iter < edges[0].length; iter++) {
			if (edges[vertex][iter] == 1) {
				if (status[iter] == 0) {
					if (dfscall(iter, status, edges)) {
						return true;
					}
				} else {
					if (status[iter] == 1) {
						return true;
					}
				}

			}
		}
		status[vertex] = 2;
		return false;
	}

}