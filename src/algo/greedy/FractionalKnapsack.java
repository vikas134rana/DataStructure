package algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

	private List<Item> items;
	private float W;

	public FractionalKnapsack(List<Item> items, int knapsackWeigth) {
		this.items = items;
		this.W = knapsackWeigth;
	}

	public float solution() {

		List<Item> knapsackItems = new ArrayList<>();

		Comparator<Item> comparator = new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return (int) ((o2.getValue() / o2.getWeight()) - (o1.getValue() / o1.getWeight()));
			}
		};

		Collections.sort(items, comparator);
		
		System.out.println(items);

		float total = 0;

		for (Item item : items) {

			if (item.getWeight() <= W) {
				knapsackItems.add(item);
				W = W - item.getWeight();
				total += item.getValue();
			} else {
				total += (W / item.getWeight()) * item.getValue();
				W = 0;
				break;
			}

		}

		return total;
	}

}
