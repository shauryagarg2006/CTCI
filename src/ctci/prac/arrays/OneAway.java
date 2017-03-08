package ctci.prac.arrays;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(isOneAway("dhauryagarg", "ahauryadarg"));

	}

	public static boolean isOneAway(String first, String second) {
		boolean result = false;
		if (Math.abs(first.length() - second.length()) > 1) {
			return result;
		}
		for (int iterF = 0, iterS = 0; iterF < first.length() && iterS < second.length();) {
			if (first.charAt(iterF) != second.charAt(iterS)) {
				if (result) {
					return false;
				}
				result = true;
				if (first.length() > second.length()) {
					iterF++;
				} else if (first.length() < second.length()) {
					iterS++;
				} else {
					iterF++;
					iterS++;
				}
			} else {
				iterF++;
				iterS++;
			}
		}
		return true;
	}

}
