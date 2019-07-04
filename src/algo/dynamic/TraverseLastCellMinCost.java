package algo.dynamic;

public class TraverseLastCellMinCost {

	static int count;

	public static void main(String[] args) {

//		int[][] a = { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 }, { 2, 9, 8, 9, 3 } };
//		int[][] a = { { 4, 7, 8 }, { 6, 7, 3 }, { 3, 8, 1 } };
		int[][] a = { { 1, 2, 9 }, { 2, 3, 4 }, { 2, 6, 2 } };

		int[][] sol = new int[a.length][a[0].length];

		System.out.println("Minimum Cost to Traverse Last Cell:");
		System.out.println(solution_td(sol, a, 0, 0));
		System.out.println("Iterations: " + count);
		count = 0;
		System.out.println(solution_bu(a));
		System.out.println("Iterations: " + count);
	}

	public static int solution_td(int[][] sol, int[][] a, int i, int j) {

		count++;

		if (i == a.length - 1 && j == a[0].length - 1) {
			return a[i][j];
		}

		if (sol[i][j] == 0) {
			int right, down;
			right = down = Integer.MAX_VALUE;

			if (j + 1 != a[0].length)
				right = a[i][j] + solution_td(sol, a, i, j + 1);
			if (i + 1 != a.length)
				down = a[i][j] + solution_td(sol, a, i + 1, j);

			sol[i][j] = Integer.min(right, down);
		}
		return sol[i][j];
	}

	public static int solution_bu(int[][] a) {
		int[][] sol = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {

				count++;

				if (i == 0 && j == 0) {
					sol[i][j] = a[i][j];
					continue;
				}

				int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;

				if (j - 1 >= 0)
					left = sol[i][j - 1];
				if (i - 1 >= 0)
					up = sol[i - 1][j];

				sol[i][j] = a[i][j] + Integer.min(left, up);

			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(sol[i][j] + "\t");
			}
			System.out.println();
		}

		return (sol[a.length - 1][a[0].length - 1]);
	}
}
