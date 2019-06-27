package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	List<GraphNode> graphNodes;

	public Dijkstra() {
		this.graphNodes = new ArrayList<>();
	}

	public void add(GraphNode node) {
		graphNodes.add(node);
	}

	public void addEdge(int i, int j, int d) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
		first.getWeightMap().put(second, d);
	}

	public void traverse(int index) {
		GraphNode srcNode = graphNodes.get(index);
		traverse(srcNode);
	}

	private void traverse(GraphNode srcNode) {
		srcNode.setDistance(0);
		PriorityQueue<GraphNode> queue = new PriorityQueue<>();
		queue.addAll(graphNodes);

		while (!queue.isEmpty()) {

			GraphNode node = queue.remove();

			for (GraphNode neighbour : node.getNeighbours()) {

				if (queue.contains(neighbour)) {

					int currentDistance = node.getDistance() + node.getWeightMap().get(neighbour);
					if (neighbour.getDistance() > currentDistance) {
						neighbour.setDistance(currentDistance); // update distance
						neighbour.setParent(node);
					
						queue.remove(neighbour);
						queue.add(neighbour);
					}

				}

			}

		}
	}

	public void printDistance() {
		for (GraphNode node : graphNodes) {
			System.out.println(node.getName() + ": " + node.getDistance());
		}
	}

}
