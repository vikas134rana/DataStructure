package algo.dynamic;

public class LongestCommonSubsequence {

	static int count = 0;

	public static void main(String[] args) {
		/*- String s1 = "abcdef";
		String s2 = "xabdcf";*/

		/*- String s1 = "abc";
		String s2 = "xyz";*/

		String s1 = "BACDBBADAEDCBADAH";
		String s2 = "BDCBAADACAHBAD";

		Integer[][] sol = new Integer[s1.length()][s2.length()];

		System.out.println("Longest Common Subsequence: " + solution_td(sol, s1, s2, 0, 0));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println("Longest Common Subsequence: " + solution_bu(s1, s2));
		System.out.println("Iteration: " + count);
	}

	private static int solution_td(Integer[][] sol, String s1, String s2, int i1, int i2) {

		count++;

		if (i1 >= s1.length() || i2 >= s2.length())
			return 0;

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return 1 + solution_td(sol, s1, s2, i1 + 1, i2 + 1);
		}
		if (sol[i1][i2] == null) {
			int first = solution_td(sol, s1, s2, i1 + 1, i2);
			int second = solution_td(sol, s1, s2, i1, i2 + 1);
			sol[i1][i2] = Integer.max(first, second);
		}
		return sol[i1][i2];
	}

	private static int solution_bu(String s1, String s2) {
		Integer[][] sol = new Integer[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {

				count++;

				if (i == 0 || j == 0) {
					sol[i][j] = 0;
					continue;
				}

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					sol[i][j] = sol[i - 1][j - 1] + 1;
				} else {
					int top = sol[i - 1][j];
					int left = sol[i][j - 1];
					sol[i][j] = Integer.max(top, left);
				}

			}
		}

		return sol[sol.length - 1][sol[0].length - 1];
	}

}
