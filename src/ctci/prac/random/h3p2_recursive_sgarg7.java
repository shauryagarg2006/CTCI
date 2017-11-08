package ctci.prac.random;

import java.util.Scanner;

public class h3p2_recursive_sgarg7 {
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
		matrixRecursive(dim);
	}

	public static void matrixRecursive(int dim[]) {
		numRecusiveCalls = 0;
		int result = 0;
		int numMatrices = dim.length - 1;
		int parenthesis[][] = new int[numMatrices][numMatrices];
		long timeStart = System.nanoTime();
		result = matrixRecursiveHelper(dim, 1, numMatrices, parenthesis);
		long timeEnd = System.nanoTime();
		System.out.println("\nTime taken : " + (timeEnd - timeStart));
		System.out.println("Number of multiplication required: " + result);
		System.out.println("Optmial parenthesization is as follows:");
		printParenthesis(parenthesis, 1, numMatrices);
		System.out.println("#Time taken : " + (timeEnd - timeStart) / 1000);
		System.out.println("#Recursive Calls : " + numRecusiveCalls);
	}

	public static int matrixRecursiveHelper(int dim[], int i, int j, int parenthesis[][]) {
		numRecusiveCalls++;
		if (i == j)
			return 0;
		int result = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int resultAtK = matrixRecursiveHelper(dim, i, k, parenthesis)
					+ matrixRecursiveHelper(dim, k + 1, j, parenthesis) + dim[i - 1] * dim[k] * dim[j];
			if (resultAtK < result) {
				result = resultAtK;
				parenthesis[i - 1][j - 1] = k;
			}
		}
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
