package algo.divideandconquer;

public class Knapsack01 {

	public static int maxValue(int[] values, int[] weights, int start, int end, int W) {

		if (start > end || W == 0) {
			return 0;
		}

		int first = 0;
		if (W >= weights[start])
			first = values[start] + maxValue(values, weights, start + 1, end, W - weights[start]);
		int second = maxValue(values, weights, start + 1, end, W);

		return Integer.max(first, second);

	}

	public static void main(String[] args) {
		/*- int[] values = { 50, 40, 45, 80, 15 };
		int[] weights = { 3, 4, 3, 6, 2 };*/

		int[] values = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };

		System.out.println("Max Knapsack Value:");
		System.out.println(maxValue(values, weights, 0, values.length - 1, 7));
	}

}
