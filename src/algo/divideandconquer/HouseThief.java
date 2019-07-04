package algo.divideandconquer;

public class HouseThief {

	static int i = 0;

	public static int maxProfit(int[] a, int start, int end) {
		i++;
		
		if (start > end)
			return 0;

		int first = a[start] + maxProfit(a, start + 2, end);
		int second = maxProfit(a, start + 1, end);
		return Integer.max(first, second);
	}

	public static void main(String[] args) {
		int[] houseValue = { 50, 60, 30, 15, 10 };
		System.out.println("Max House Profit: " + maxProfit(houseValue, 0, houseValue.length - 1));
		System.out.println("Iteration: " + i);
	}
}
