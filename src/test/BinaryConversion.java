package test;

public class BinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinaryRepr(8);
	}

	public static void printBinaryRepr(int n) {
		if (n == 0) {
			System.out.print(0 + "  ");
			return;
		}
		printBinaryRepr(n/2);
		System.out.print(n%2 + "  ");

	}

}
