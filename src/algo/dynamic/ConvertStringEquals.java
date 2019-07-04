package algo.dynamic;

public class ConvertStringEquals {

	static int count = 0;

	public static void main(String[] args) {
		String s1 = "TABLE";
		String s2 = "TBRES";
		Integer[][] sol = new Integer[s1.length() + 1][s2.length() + 1];

		System.out.println("Min Edit require to convert " + s1 + " to " + s2 + " :");
		System.out.println(solution_td(sol, s1, s2, 0, 0));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println(solution_bu(s1, s2));
		System.out.println("Iteration: " + count);
	}

	private static int solution_td(Integer[][] sol, String s1, String s2, int i1, int i2) {

		count++;

		if (sol[i1][i2] == null) {

			if (i1 >= s1.length()) {
				return s2.length() - i2;
			}

			if (i2 >= s2.length()) {
				return s1.length() - i1;
			}

			if (s1.charAt(i1) == s2.charAt(i2)) {
				return solution_td(sol, s1, s2, i1 + 1, i2 + 1);
			}

			int update = 1 + solution_td(sol, s1, s2, i1 + 1, i2 + 1);
			int insert = 1 + solution_td(sol, s1, s2, i1 + 1, i2);
			int delete = 1 + solution_td(sol, s1, s2, i1, i2 + 1);
			sol[i1][i2] = Integer.min(update, Integer.min(insert, delete));
		}
		return sol[i1][i2];
	}

	private static int solution_bu(String s1, String s2) {

		Integer[][] a = new Integer[s1.length() + 1][s2.length() + 1];

		for (int i = a.length - 1; i >= 0; i--) {

			for (int j = a[0].length - 1; j >= 0; j--) {
				count++;

				if (i >= a.length - 1) {
					System.out.println("I: " + i + "\t" + "J: " + j + "\t" + "A[0].len: " + a[0].length);
					a[i][j] = a[0].length - 1 - j;
					continue;
				}

				if (j >= a[0].length - 1) {
					a[i][j] = a.length - 1 - i;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					a[i][j] = a[i + 1][j + 1];
					continue;
				}

				int update = 1 + a[i + 1][j + 1];
				int insert = 1 + a[i][j + 1];
				int delete = 1 + a[i + 1][j];
				a[i][j] = Integer.min(update, Integer.min(insert, delete));

			}
		}

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[0].length; j++) {

				System.out.print(a[i][j] + " ");

			}
			System.out.println();
		}

		return a[0][0];
	}
}
