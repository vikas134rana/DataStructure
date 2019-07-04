package algo.dynamic;

public class PathToLastCellGivenCost {

	static int count = 0;

	public static void main1(String[] args) {

		int[][] a = { { 4, 7, 1, 6 }, { 5, 7, 3, 9 }, { 3, 2, 1, 2 }, { 7, 1, 6, 3 } };
		int cost = 25;

		Integer[][][] sol = new Integer[a.length][a[0].length][cost + 1];

		System.out.println("Paths to Traverse Last Cell in given cost:");
		System.out.println(solution_td(sol, a, 0, 0, cost));
		System.out.println("Iteration: " + cost);

	}

	public static int solution_td(Integer[][][] sol, int[][] a, int i, int j, int cost) {

		count++;

		if (cost <= 0)
			return 0;

		if (i == a.length - 1 && j == a[0].length - 1) {
			if (cost - a[i][j] == 0)
				return 1;
			return 0;
		}

		if (sol[i][j][cost] == null) {

			int right = 0, down = 0;

			if (j + 1 != a[0].length)
				right = solution_td(sol, a, i, j + 1, cost - a[i][j]);
			if (i + 1 != a.length)
				down = solution_td(sol, a, i + 1, j, cost - a[i][j]);

			sol[i][j][cost] = right + down;
		}
		return sol[i][j][cost];
	}

	// *****************************

	public static int numberOfPaths(int array[][], int row, int col, int cost) {
		int[][] dp = new int[row + 1][col + 1];
		return numberOfPathsAux(dp, array, row, col, cost);
	}// End of method

	public static int numberOfPathsAux(int dp[][], int array[][], int row, int col, int cost) {

		

		if (cost < 0) {// BASE CASE
			return 0;
		}
		if (row == 0 && col == 0) { // BASE CASE
			return (array[0][0] - cost == 0) ? 1 : 0;
		}
		
		count++;
		
		if (dp[row][col] == 0) {// If we have not solved this problem previously, only then solve it
			if (row == 0) { // BASE CASE: If we're at first row, we can only go left
				dp[row][col] = numberOfPaths(array, 0, col - 1, cost - array[row][col]);
			} else if (col == 0) { // BASE CASE: if we're at first column, we can only go up
				dp[row][col] = numberOfPaths(array, row - 1, 0, cost - array[row][col]);
			} else {
				int noOfPathsFromPreviousRow = numberOfPaths(array, row - 1, col, cost - array[row][col]); // Find Paths till last Row
				int noOfPathsFromPreviousCol = numberOfPaths(array, row, col - 1, cost - array[row][col]); // Find Paths till last Col
				dp[row][col] = noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
			}
		} // end of if-else block
		return dp[row][col];
	}// End of method

	public static void main(String[] args) {
		int[][] array = { { 4, 7, 1, 6 }, { 5, 7, 3, 9 }, { 3, 2, 1, 2 }, { 7, 1, 6, 3 } };
		int cost = 25;
		System.out.println("Total paths with cost " + cost + " are " + numberOfPaths(array, array.length - 1, array[0].length - 1, cost));
		System.out.println("Iteration: " + count);
	}

}
