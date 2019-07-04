package algo.greedy;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		fractionalKnapsackMain();
	}

	public static void activitySelectionMain() {

		ActivitySelection activitySelection = new ActivitySelection();
		activitySelection.add(new Activity(0, 6));
		activitySelection.add(new Activity(3, 4));
		activitySelection.add(new Activity(1, 2));
		activitySelection.add(new Activity(5, 8));
		activitySelection.add(new Activity(5, 7));
		activitySelection.add(new Activity(8, 9));

		List<Activity> list = activitySelection.solution();

		System.out.println(list);
	}

	public static void coinChangeProblemMain() {
		CoinChangeProblem ccp = new CoinChangeProblem(886);
		System.out.println(ccp.solution() + " coins");
	}

	public static void fractionalKnapsackMain() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(100, 20));
		items.add(new Item(120, 30));
		items.add(new Item(60, 10));

		FractionalKnapsack fractionalKnapsack = new FractionalKnapsack(items, 50);
		System.out.println("Knapsack Value: " + fractionalKnapsack.solution());
	}

}
