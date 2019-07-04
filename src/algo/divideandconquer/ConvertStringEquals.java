package algo.divideandconquer;

public class ConvertStringEquals {

	public static int minEdit(String s1, String s2, int i1, int i2) {

		if (i1 >= s1.length()) {
			return s2.length() - i2;
		} else if (i2 >= s2.length()) {
			return s1.length() - i1;
		}

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return minEdit(s1, s2, i1 + 1, i2 + 1);
		}

		int update = 1 + minEdit(s1, s2, i1 + 1, i2 + 1);
		int insert = 1 + minEdit(s1, s2, i1 + 1, i2);
		int delete = 1 + minEdit(s1, s2, i1, i2 + 1);

		return min(update, insert, delete);
	}

	private static int min(int... a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String s1 = "abedf";
		String s2 = "abcdeg";

		System.out.println("Min Edit require to convert " + s1 + " to " + s2 + " :");
		System.out.println(minEdit(s1, s2, 0, 0));
	}

}
