package algo.dynamic;

public class NumberFactor {

	static int i = 0;

	// 1,3,4
	public static int solution_td(int[] a, int n) {
		i++;
		if (n == 0 || n == 1 || n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		if (a[n] == 0) {
			a[n] = solution_td(a, n - 1) + solution_td(a, n - 3) + solution_td(a, n - 4);
		}

		return a[n];
	}

	public static int solution_bu(int n) {
		int[] a = new int[n + 1];
		a[0] = a[1] = a[2] = 1;
		a[3] = 2;

		for (int i = 4; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 3] + a[i - 4];
		}
		return a[n];
	}

	public static void main(String[] args) {
		int n = 15;
		int[] a = new int[n + 1];
		System.out.println("TD: "+solution_td(a, n));
		System.out.println("BU: " + solution_bu(n));
		System.out.println("iteration: " + i);
	}

}
