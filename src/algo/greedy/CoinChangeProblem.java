package algo.greedy;

public class CoinChangeProblem {

	private int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	private int value;

	public CoinChangeProblem(int value) {
		this.value = value;
	}

	public int solution() {

		int totalCoins = 0;

		for (int i = coins.length - 1; i >= 0; i--) {
			if (value >= coins[i]) {
				int f = value / coins[i];
				totalCoins += f;
				value = value % coins[i];
				System.out.println(coins[i] + "\t: " + f);
			}
		}

		return totalCoins;
	}

}
