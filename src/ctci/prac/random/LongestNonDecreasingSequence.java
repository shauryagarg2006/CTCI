package ctci.prac.random;

import java.util.Arrays;

public class LongestNonDecreasingSequence {

	public static int resultValue = 1;

	public static void main(String[] args) {
		int input[] = { 3, 45, 23, 9, 3, 99, 108, 76, 12, 77, 16, 18, 4, 19, 3, 45, 23, 9, 3, 99, 108, 76, 12, 77, 16,
				18, 4, 19, 1000 };
		System.out.println(lnds(input, 0, Integer.MIN_VALUE));
		lndsTwo(input, input.length);
		System.out.println(resultValue);
		System.out.println(lndsdp(input));

	}

	public static int lnds(int input[], int index, int currentVal) {
		// base case
		if (index == input.length)
			return 0;
		if (input[index] < currentVal)
			return lnds(input, index + 1, currentVal);
		else
			return Math.max(lnds(input, index + 1, currentVal), lnds(input, index + 1, input[index]) + 1);
	}

	public static int lndsTwo(int input[], int length) {
		// base case
		if (length == 1) {
			return 1;
		} else {
			int result, max = 0;
			for (int iter = 1; iter < length; iter++) {
				result = lndsTwo(input, iter);
				if (input[length - 1] >= input[iter - 1]) {
					result = result + 1;
				} else {
					result = 1;
				}
				max = result > max ? result : max;
			}
			resultValue = resultValue > max ? resultValue : max;
			return max;
		}
	}

	public static int lndsdp(int input[]) {
		int dp[] = new int[input.length];
		int index[] = new int[input.length];
		Arrays.fill(index, -1);
		dp[0] = 1;
		for (int iter = 1; iter < input.length; iter++) {
			dp[iter] = 1;
			for (int lookback = 0; lookback < iter; lookback++) {
				if (input[iter] >= input[lookback]) {
					if (dp[iter] < dp[lookback] + 1) {
						index[iter] = lookback;
						dp[iter] = dp[lookback] + 1;
					}
				}
			}
		}
		int result = 0;
		int lastElementIndex = -1;
		for (int iter = 0; iter < input.length; iter++)
			if (dp[iter] > result) {
				result = dp[iter];
				lastElementIndex = iter;
			}
		while (lastElementIndex >= 0) {
			System.out.print(input[lastElementIndex] + " ");
			lastElementIndex = index[lastElementIndex];
		}
		System.out.println("");
		return result;
	}

}
