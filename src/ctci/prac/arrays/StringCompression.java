package ctci.prac.arrays;

public class StringCompression {

	public static void main(String args[]) {
		System.out.println(stringCompression("abcdef"));
	}

	public static String stringCompression(String input) {
		StringBuilder result = new StringBuilder();
		if (input == null || input.length() < 2) {
			return input;
		}
		int count = 1;
		char prevChar = input.charAt(0);
		for (int iter = 1; iter < input.length(); iter++) {
			if (prevChar != input.charAt(iter)) {
				result.append(String.valueOf(prevChar) + count);
				count = 1;
				prevChar = input.charAt(iter);
			} else {
				count++;
			}

		}
		result.append(String.valueOf(prevChar) + count);
		return input.length() > result.length() ? result.toString() : input;
	}

}
