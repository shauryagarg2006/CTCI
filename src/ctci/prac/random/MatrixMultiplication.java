package ctci.prac.random;

public class MatrixMultiplication {

	public static void main(String[] args) {

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7 };
			System.out.println("######################4############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}
		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9 };
			System.out.println("######################6############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9, 4, 5 };
			System.out.println("######################8############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9, 4, 5, 6, 7 };
			System.out.println("######################10############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9, 4, 5, 6, 7, 3, 2 };
			System.out.println("######################12############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9, 4, 5, 6, 7, 3, 2, 6, 9 };
			System.out.println("######################14############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

		if (true) {
			int dim[] = { 5, 2, 4, 7, 7, 8, 9, 4, 5, 6, 7, 3, 2, 6, 9, 4, 3 };
			System.out.println("######################16############################");
			h3p2_dp_sgarg7.matrixDp(dim);
			h3p2_memoized_sgarg7.matrixMemoized(dim);
			h3p2_recursive_sgarg7.matrixRecursive(dim);
		}

	}

}
