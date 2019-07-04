package algo.divideandconquer;

public class LongestCommonSubsequence {

	public static int solution(String s1, String s2, int i1, int i2) {

		if (i1 >= s1.length() || i2 >= s2.length())
			return 0;

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return 1 + solution(s1, s2, i1 + 1, i2 + 1);
		}

		int first = solution(s1, s2, i1 + 1, i2);
		int second = solution(s1, s2, i1, i2 + 1);

		return Integer.max(first, second);
	}

	public static void main(String[] args) {
		/*- String s1 = "abcdef";
		String s2 = "xabdcf";*/
		
		/*- String s1 = "abc";
		String s2 = "xyz";*/
		
		String s1 = "BACDB";
		String s2 = "BDCB";
		
		
		System.out.println("Longest Common Subsequence: " + solution(s1, s2, 0, 0));
	}
}
