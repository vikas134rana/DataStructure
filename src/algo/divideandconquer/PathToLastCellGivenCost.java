package algo.divideandconquer;

public class PathToLastCellGivenCost {

	public static int minCost1(int[][] a, int i, int j, int cost) {

		if (cost < 0)
			return 0;

		if (i == 0 && j == 0) {
			return cost - a[i][j] == 0 ? 1 : 0;
		}

		if (i == 0)
			return minCost(a, 0, j - 1, cost - a[i][j]);
		if (j == 0)
			return minCost(a, i - 1, j, cost - a[i][j]);

		int left = minCost(a, i, j - 1, cost - a[i][j]);
		int up = minCost(a, i - 1, j, cost - a[i][j]);

		return left + up;
	}

	private static int minCost(int[][] a, int i, int j, int cost) {

		if (cost < 0)
			return 0;

		if (i == a.length - 1 && j == a[0].length - 1) {
			return cost - a[i][j] == 0 ? 1 : 0;
		}

		int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
		if (j < a[0].length - 1)
			right = minCost(a, i, j + 1, cost - a[i][j]);
		if (i < a.length - 1)
			down = minCost(a, i + 1, j, cost - a[i][j]);

		int min = Integer.min(right, down);
		System.out.println("i:" + i + " j:" + j + "\t\t" + min);
		return min;
	}

	public static void main(String[] args) {

		int[][] a = { { 4, 7, 1, 6 }, { 5, 7, 3, 9 }, { 3, 2, 1, 2 }, { 7, 1, 6, 3 } };
		int cost = 25;

		System.out.println("Minimum Cost to Traverse Last Cell:");
		System.out.println(minCost(a, a.length - 1, a[0].length - 1, cost));
	}

}
