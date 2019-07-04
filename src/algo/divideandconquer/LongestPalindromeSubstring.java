package algo.divideandconquer;

public class LongestPalindromeSubstring {

	public static int solution(String s, int start, int end) {

		if (start > end) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		if (s.charAt(start) == s.charAt(end)) {
			int palLength = end - start - 1;
			if (palLength == solution(s, start + 1, end - 1)) {
				return 2 + palLength;
			}
		}

		int first = solution(s, start + 1, end);
		int second = solution(s, start, end - 1);
		return Integer.max(first, second);

	}

	public static void main(String[] args) {

		String s = "BDADA";
		System.out.println(solution(s, 0, s.length() - 1));

	}

}
