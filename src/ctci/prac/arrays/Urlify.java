package ctci.prac.arrays;

public class Urlify {

	public static void main(String[] args) {
		System.out.println(urlify("hi ab hj    "));

	}

	public static char[] urlify(String input) {
		char[] inputArray = input.toCharArray();
		int numSpaces = 0;
		for (int iter = inputArray.length - 1; iter >= 0; iter--) {
			if (inputArray[iter] == ' ') {
				numSpaces += 1;
			} else {
				break;
			}
		}
		for (int iter = inputArray.length - 1 - numSpaces; numSpaces > 0; iter--) {
			if (inputArray[iter] != ' ') {
				inputArray[iter + numSpaces] = inputArray[iter];
			} else {
				inputArray[iter + numSpaces] = '0';
				inputArray[iter + numSpaces - 1] = '2';
				inputArray[iter + numSpaces - 2] = '%';
				numSpaces -= 2;
			}
		}

		return inputArray;
	}

}
