package ctci.prac.knapsack;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weights[] = { 10, 20, 30 };
		int values[] = { 60, 100, 120 };
		int size = 50;
		System.out.println(getMaxValue(weights, values, size));
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

}
