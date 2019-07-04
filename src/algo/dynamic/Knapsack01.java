package algo.dynamic;

public class Knapsack01 {

	private static int count;

	public static void main(String[] args) {
		int[] values = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int W = 7;
		Integer[][] sol = new Integer[values.length][W];

		System.out.println("Max Knapsack Value:");
		System.out.println(solution_td(sol, values, weights, 0, values.length - 1, W));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println(solution_bu(values, weights, W));
		System.out.println("Iteration: " + count);
	}

	private static int solution_td(Integer[][] sol, int[] values, int[] weights, int start, int end, int W) {

		count++;
		if (W == 0 || start > end) {
			return 0;
		}

		if (sol[start][W - 1] == null) {

			int first = 0;
			if (W >= weights[start])
				first = values[start] + solution_td(sol, values, weights, start + 1, end, W - weights[start]);
			int second = solution_td(sol, values, weights, start + 1, end, W);
			sol[start][W - 1] = Integer.max(first, second);
		}

		return sol[start][W - 1];
	}

	private static int solution_bu(int[] values, int[] weights, int W) {

		Integer[][] sol = new Integer[values.length + 1][W + 1];

		for (int i = 0; i < sol.length; i++) {

			for (int j = 0; j < sol[0].length; j++) {

				if (i == 0 || j == 0) {
					sol[i][j] = 0;
					continue;
				}

				if (j < weights[i - 1]) {
					sol[i][j] = sol[i - 1][j];
				} else {
					sol[i][j] = Integer.max(sol[i - 1][j], values[i - 1] + sol[i - 1][j - weights[i - 1]]);
				}

			}

		}

		for (int i = 0; i < sol.length; i++) {

			for (int j = 0; j < sol[0].length; j++) {

				System.out.print(sol[i][j] + "\t");

			}

			System.out.println();
		}

		return sol[values.length][W];
	}
}
