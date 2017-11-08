package ctci.prac.knapsack;

import java.util.Arrays;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weights[] = { 1, 2, 3 };
		int values[] = { 6, 10, 12 };
		int size = 6;
		// System.out.println(getMaxValue(weights, values, size));
		System.out.println(knapSack(size, weights, values, 3));
	}

	public static int getMaxValue(int[] weights, int[] values, int size) {
		int dp[] = new int[size + 1];
		dp[0] = 0;
		for (int sizeIter = 1; sizeIter <= size; sizeIter++) {
			for (int iterOptions = 0; iterOptions < values.length; iterOptions++) {
				if (weights[iterOptions] > sizeIter) {
					continue;
				} else {
					dp[sizeIter] = Math.max(dp[sizeIter], dp[sizeIter - weights[iterOptions]] + values[iterOptions]);
				}
			}
			System.out.println(sizeIter + " --> " + dp[sizeIter]);
		}
		return dp[size];
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		for (int[] row : K) {
			printRow(row);
		}

		return K[n][W];
	}

	public static void printRow(int[] row) {
		for (int i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}

}
