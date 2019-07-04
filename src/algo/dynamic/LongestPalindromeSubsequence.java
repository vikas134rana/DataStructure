package algo.dynamic;

public class LongestPalindromeSubsequence {

	private static int count;

	public static void main(String[] args) {

		String s = "AMDADAXM";

		Integer[][] sol = new Integer[s.length()][s.length()];

		System.out.println("Longest Common Subsequence: " + solution_td(sol, s, 0, s.length() - 1));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println("Longest Common Subsequence: " + solution_bu(s));
		System.out.println("Iteration: " + count);
	}

	private static int solution_bu(String s) {
		int[][] sol = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			count++;
			sol[i][i] = 1;
		}

		for (int g = 1; g < s.length(); g++) {

			for (int i = 0; i + g < s.length(); i++) {
				count++;
				int j = i + g;

				if (s.charAt(i) == s.charAt(j)) {
					sol[i][j] = 2 + sol[i + 1][j - 1];
				} else {
					sol[i][j] = Integer.max(sol[i + 1][j], sol[i][j - 1]);
				}
				j = i;
			}
		}
		return sol[0][sol.length - 1];
	}

	private static int solution_td(Integer[][] sol, String s, int start, int end) {

		count++;
		if (start > end)
			return 0;

		if (start == end)
			return 1;

		if (sol[start][end] == null) {
			if (s.charAt(start) == s.charAt(end)) {
				return 2 + solution_td(sol, s, start + 1, end - 1);
			}

			int first = solution_td(sol, s, start + 1, end);
			int second = solution_td(sol, s, start, end - 1);
			sol[start][end] = Integer.max(first, second);
		}
		return sol[start][end];
	}

	// Iteration1
	// F: s:0 e:4

	// Iteration11
	// F: s:1 e:4
	// Iteration12
	// F: s:0 e:3

	// Iteration111
	// F: s:2 e:4
	// Iteration112
	// F: s:1 e:3

	// Iteration121
	// F: s:1 e:3
	// Iteration122
	// F: s:0 e:2

	// Iteration1111
	// F: s:3 e:4
	// Iteration1112
	// F: s:2 e:3

	// Iteration1121
	// F: s:2 e:3
	// Iteration1122
	// F: s:1 e:2

}
