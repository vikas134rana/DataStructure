package algo.dynamic;

public class LongestPalindromeSubstring {

	static int count = 0;

	public static void main(String[] args) {

		String s = "MABDADAXBM";

		int[][] sol = new int[s.length()][s.length()];
		System.out.println("Longest Palindrome Substring: " + solution_td(sol, s, 0, s.length() - 1));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println("Longest Palindrome Subsequence: " + solution_bu(s));
		System.out.println("Iteration: " + count);
	}

	private static int solution_td(int[][] sol, String s, int start, int end) {

		count++;

		if (start > end)
			return 0;

		if (start == end)
			return 1;

		if (sol[start][end] == 0) {
			if (s.charAt(start) == s.charAt(end)) {
				int len = end - start - 1;
				if (len == solution_td(sol, s, start + 1, end - 1))
					return 2 + len;
			}

			int first = solution_td(sol, s, start + 1, end);
			int second = solution_td(sol, s, start, end - 1);
			sol[start][end] = Integer.max(first, second);
		}
		return sol[start][end];
	}

	private static int solution_bu(String s) {

		int start = 0;
		int end = 0;
		int len = s.length();
		boolean[][] sol = new boolean[len][len];

		for (int i = 0; i < s.length(); i++)
			sol[i][i] = true;

		for (int g = 1; g < s.length(); g++) {
			for (int i = 0; i + g < s.length(); i++) {

				int j = i + g;

				if (s.charAt(i) == s.charAt(j)) {
					if (g == 1)
						sol[i][j] = true;
					else
						sol[i][j] = sol[i + 1][j - 1] == true ? true : false;
					if (sol[i][j]) {
						start = i;
						end = j;
					}
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				System.out.print(sol[i][j] + "\t");
			}
			System.out.println();
		}

		return end - start + 1;
	}
}
