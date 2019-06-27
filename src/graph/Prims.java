package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

	List<GraphNode> graphNodes;

	public Prims() {
		this.graphNodes = new ArrayList<>();
	}

	public void add(GraphNode node) {
		node.setIndex(graphNodes.size());
		graphNodes.add(node);
	}

	public void addEdge(int i, int j, int d) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
		second.getNeighbours().add(first);

		first.getWeightMap().put(second, d);
		second.getWeightMap().put(first, d);
	}

	public void calculate(int index) {
		GraphNode srcNode = graphNodes.get(index);

		srcNode.setDistance(0);
		srcNode.setVisited(true);

		PriorityQueue<GraphNode> queue = new PriorityQueue<>();
		queue.addAll(graphNodes);

		while (!queue.isEmpty()) {

			GraphNode node = queue.remove();
			node.setVisited(true);

			for (GraphNode neighbour : node.getNeighbours()) {

				if (!neighbour.isVisited()) {

					int currDistance = node.getWeightMap().get(neighbour);

					if (neighbour.getDistance() > currDistance) {
						neighbour.setDistance(currDistance);
						neighbour.setParent(node);
						queue.remove(neighbour);
						queue.add(neighbour);
					}
				}

			}

		}

		int minDistance = 0;
		for (int i = 0; i < graphNodes.size(); i++) {
			minDistance += graphNodes.get(i).getDistance();
			GraphNode node = graphNodes.get(i);
			System.out.print(node + " ");
			node = node.getParent();
		}
		System.out.println("\nMinimum Spanning Distance: " + minDistance);
	}

}
