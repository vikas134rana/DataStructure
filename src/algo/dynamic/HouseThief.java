package algo.dynamic;

public class HouseThief {

	static int count = 0;

	public static int solution_td(int[] a, int[] sol, int start, int end) {
		count++;
		if (start > end)
			return 0;

		if (sol[start] != 0)
			return sol[start];

		System.out.println("S: " + start);

		int first = a[start] + solution_td(a, sol, start + 2, end);
		int second = solution_td(a, sol, start + 1, end);
		sol[start] = Integer.max(first, second);
		System.out.println("S: " + start + " First: " + first + " & Second: " + second + "\t => Max: " + sol[start]);
		return sol[start];
	}

	public static int solution_bu(int[] a) {

		for (int i = 0; i <= 4; i++) {
			count++;
			int first = a[i] + (i - 2 < 0 ? 0 : a[i - 2]);
			int second = i - 1 < 0 ? 0 : a[i - 1];
			a[i] = Integer.max(first, second);
			System.out.println("i: " + a[i] + "\t F:" + first + " & S:" + second);
		}
		return a[a.length - 1];
	}

	public static void main(String[] args) {
		int[] houseValue = { 50, 60, 30, 15, 10 };
		int[] sol = new int[houseValue.length];
		System.out.println("Max House Profit: " + solution_td(houseValue, sol, 0, houseValue.length - 1));
		System.out.println("Iteration: " + count);
		count = 0;
		System.out.println("Max House Profit BU: " + solution_bu(houseValue));
		System.out.println("Iteration: " + count);
	}
}
