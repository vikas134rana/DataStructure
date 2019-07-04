package algo.divideandconquer;

public class TraverseLastCellMinCost {

	public static int minCost1(int[][] a, int i, int j) {

		int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
		if (j + 1 < a[0].length)
			right = a[i][j] + minCost(a, i, j + 1);
		if (i + 1 < a.length)
			down = a[i][j] + minCost(a, i + 1, j);

		if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE)
			return a[i][j];

		int min = Integer.min(down, right);
		System.out.println("i:" + i + " j:" + j + "\t\t" + min);
		return min;
	}

	public static void main(String[] args) {

//		int[][] a = { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 }, { 2, 9, 8, 9, 3 } };
		int[][] a = { { 4, 7, 8 }, { 6, 7, 3 }, { 3, 8, 1 } };

		System.out.println("Minimum Cost to Traverse Last Cell:");
		System.out.println(minCost(a, 0, 0));
	}

	private static int minCost(int[][] a, int i, int j) {

		if (i == a.length-1 && j == a[0].length-1)
			return a[i][j];

		int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
		if (j <  a[0].length-1)
			right = a[i][j] + minCost(a, i, j + 1);
		if (i <  a.length-1)
			down = a[i][j] + minCost(a, i + 1, j);

		int min = Integer.min(right, down);
		System.out.println("i:" + i + " j:" + j + "\t\t" + min);
		return min;
	}

}
