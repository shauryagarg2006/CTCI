package ctci.prac.arrays;

public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(input);
		rotate(input);
		printMatrix(input);
		rotate(input);
		printMatrix(input);
		rotate(input);
		printMatrix(input);
		rotate(input);
		printMatrix(input);
	}

	public static void rotate(int[][] input) {
		int len = input.length;
		for (int out = 0; out < len / 2; out++) {
			for (int iter = out; iter < len - 1 - out; iter++) {
				int temp = input[out][iter];
				input[out][iter] = input[iter][len - 1 - out];
				input[iter][len - 1 - out] = input[len - 1 - out][len - 1 - iter];
				input[len - 1 - out][len - 1 - iter] = input[len - 1 - iter][out];
				input[len - 1 - iter][out] = temp;
			}
		}
	}

	public static void printMatrix(int input[][]) {
		System.out.println();
		for (int[] temp : input) {
			for (int number : temp) {
				System.out.print(number + "  ");
			}
			System.out.println();
		}
	}

}
