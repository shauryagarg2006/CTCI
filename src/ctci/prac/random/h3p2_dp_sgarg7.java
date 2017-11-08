package ctci.prac.random;

import java.util.Scanner;

public class h3p2_dp_sgarg7 {
	public static int scalarMultiplications = 0;

	public static void main(String[] args) {

		System.out.println("Please Enter , seperated values for dimensions of matrices and then hit enter\n");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] strs = line.trim().split(",");
		int[] dim = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			dim[i] = Integer.parseInt(strs[i].trim());
		}
		matrixDp(dim);
	}

	public static void matrixDp(int dim[]) {
		scalarMultiplications = 0;
		int numMatrices = dim.length - 1;
		int result = 0;
		// To store the values which led to the optimal solution in order to
		// know the parenthesization
		int parenthesis[][] = new int[numMatrices][numMatrices];
		long timeStart = System.nanoTime();
		result = matrixDpHelper(dim, parenthesis);
		long timeEnd = System.nanoTime();
		System.out.println("Number of multiplication required: " + result);
		System.out.println("Optmial parenthesization is as follows:");
		printParenthesis(parenthesis, 1, numMatrices);
		System.out.println("\n#Time taken : " + (timeEnd - timeStart) / 1000);
		System.out.println("#Scalat Multiplication : " + scalarMultiplications);
	}

	public static int matrixDpHelper(int dim[], int parenthesis[][]) {

		int numMatrices = dim.length - 1;
		int dp[][] = new int[numMatrices][numMatrices];
		// Making diagonal 0
		for (int iter = 1; iter <= numMatrices; iter++)
			dp[iter - 1][iter - 1] = 0;

		for (int i = numMatrices - 1; i >= 1; i--) {
			for (int j = i + 1; j <= numMatrices; j++) {
				dp[i - 1][j - 1] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int tempResult = dp[i - 1][k - 1] + dp[k][j - 1] + dim[i - 1] * dim[k] * dim[j];
					scalarMultiplications++;
					if (tempResult < dp[i - 1][j - 1]) {
						dp[i - 1][j - 1] = tempResult;
						parenthesis[i - 1][j - 1] = k;
					}

				}
			}

		}
		return dp[0][numMatrices - 1];
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
