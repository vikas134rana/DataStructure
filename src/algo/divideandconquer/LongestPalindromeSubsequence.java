package algo.divideandconquer;

public class LongestPalindromeSubsequence {

	public static int solution(String s, int start, int end) {

		if (start > end) {
			return 0;
		}

		if (s.charAt(start) == s.charAt(end)) {
			int match = start == end ? 1 : 2;
			return match + solution(s, start + 1, end - 1);
		}

		int first = solution(s, start + 1, end);
		int second = solution(s, start, end - 1);
		return Integer.max(first, second);
	}

	public static void main(String[] args) {

		String s = "ELRMENMET";
		System.out.println("Longest Palindrome Subsequence size: " + solution(s, 0, s.length() - 1));

	}

}
