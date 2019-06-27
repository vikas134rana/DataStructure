package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DisjointSet {

	private List<Map<Integer, Set<GraphNode>>> collection;
	
	public DisjointSet() {
		collection = new ArrayList<>();
	}

	public void makeSet(List<GraphNode> nodes) {

		for (int i = 0; i < nodes.size(); i++) {

			GraphNode node = nodes.get(i);
			Map<Integer, Set<GraphNode>> map = new HashMap<Integer, Set<GraphNode>>();
			Set<GraphNode> set = new HashSet<>();
			set.add(node);
			map.put(i, set);
			collection.add(map);
		}

	}

	public int find(GraphNode node) {

		for (int i = 0; i < collection.size(); i++) {
			Map<Integer, Set<GraphNode>> map = collection.get(i);

			for (Entry<Integer, Set<GraphNode>> entry : map.entrySet()) {
				Set<GraphNode> set = entry.getValue();
				if (set.contains(node)) {
					return entry.getKey();
				}
			}
		}

		return -1;
	}

	public void union(GraphNode first, GraphNode second) {

		int firstIndex = find(first);
		int secondIndex = find(second);
		Set<GraphNode> set1 = null;
		Set<GraphNode> set2 = null;

		if (firstIndex != secondIndex) {

			for (int i = 0; i < collection.size(); i++) {
				Map<Integer, Set<GraphNode>> map = collection.get(i);

				if (map.containsKey(firstIndex)) {
					set1 = map.get(firstIndex);
				} else if (map.containsKey(secondIndex)) {
					set2 = map.get(secondIndex);
				}
			}
		}

		if (set1 != null && set2 != null) {
			set1.addAll(set2);
		}

		if (firstIndex != secondIndex) {

			for (int i = 0; i < collection.size(); i++) {
				Map<Integer, Set<GraphNode>> map = collection.get(i);

				if (map.containsKey(firstIndex)) {
					map.put(firstIndex, set1);
				} else if (map.containsKey(secondIndex)) {
					set2 = map.remove(secondIndex);
				}
			}
		}

	}
}
