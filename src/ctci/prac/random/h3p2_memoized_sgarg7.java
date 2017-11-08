package ctci.prac.random;

import java.util.Scanner;

public class h3p2_memoized_sgarg7 {
	public static int numRecusiveCalls = 0;

	public static void main(String[] args) {

		System.out.println("Please Enter , seperated values for dimensions of matrices and then hit enter\n");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] strs = line.trim().split(",");
		int[] dim = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			dim[i] = Integer.parseInt(strs[i].trim());
		}
		matrixMemoized(dim);
	}

	public static void matrixMemoized(int dim[]) {

		// cache to store the intermediate results --> memory function for our
		// implementation
		int result = 0;
		numRecusiveCalls = 0;
		int numMatrices = dim.length - 1;
		int cache[][] = new int[numMatrices][numMatrices];
		int parenthesis[][] = new int[numMatrices][numMatrices];
		long timeStart = System.nanoTime();
		result = matrixMemoizedHelper(dim, 1, dim.length - 1, cache, parenthesis);
		long timeEnd = System.nanoTime();
		System.out.println("Number of multiplication required: " + result);
		System.out.println("Optmial parenthesization is as follows:");
		printParenthesis(parenthesis, 1, numMatrices);
		System.out.println("\nTime taken : " + (timeEnd - timeStart) / 1000);
		System.out.println("Recursive Calls : " + numRecusiveCalls);
	}

	public static int matrixMemoizedHelper(int dim[], int i, int j, int cache[][], int parenthesis[][]) {
		numRecusiveCalls++;
		if (i == j)
			return 0;
		int result = Integer.MAX_VALUE;
		if (cache[i - 1][j - 1] > 0)
			return cache[i - 1][j - 1];
		for (int k = i; k < j; k++) {
			int resultAtK = matrixMemoizedHelper(dim, i, k, cache, parenthesis)
					+ matrixMemoizedHelper(dim, k + 1, j, cache, parenthesis) + dim[i - 1] * dim[k] * dim[j];
			if (resultAtK < result) {
				result = resultAtK;
				parenthesis[i - 1][j - 1] = k;
			}

		}
		cache[i - 1][j - 1] = result;
		return result;
	}

	/**
	 * Function to print the parenthesization of matrix multiplication which led
	 * to the optimal solution
	 */
	public static void printParenthesis(int s[][], int i, int j) {
		if (i == j)
			System.out.print(" A" + i + " ");
		else {
			System.out.print("(");
			printParenthesis(s, i, s[i - 1][j - 1]);
			printParenthesis(s, s[i - 1][j - 1] + 1, j);
			System.out.print(")");
		}
	}

}
