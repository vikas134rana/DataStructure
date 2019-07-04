package algo.divideandconquer;

public class NumberFactor {

	static int i = 0;

	public int waysToGet(int n) {
		i++;
		if (n == 0 || n == 1 || n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}

		return waysToGet(n - 1) + waysToGet(n - 3) + waysToGet(n - 4);
	}

	public static void main(String[] args) {

		NumberFactor nf = new NumberFactor();
		System.out.println(nf.waysToGet(15));
		System.out.println("Iteration: " + i);
	}

}
