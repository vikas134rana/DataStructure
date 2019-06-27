package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class BellmanFord {

	List<GraphNode> graphNodes;

	public BellmanFord() {
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

		Outer: for (int i = 1; i <= graphNodes.size(); i++) {
			for (GraphNode node : graphNodes) {

				if (node.getDistance() != Integer.MAX_VALUE) { // if not infinity

					for (Entry<GraphNode, Integer> entry : node.getWeightMap().entrySet()) {

						GraphNode neighbour = entry.getKey();
						int neighbourWeight = entry.getValue();
						int newDistance = node.getDistance() + neighbourWeight;

						if (newDistance < neighbour.getDistance()) {

							if (i == graphNodes.size()) {
								System.out.println("Negative Cycle");
								break Outer;
							} else {
								neighbour.setDistance(newDistance);
							}
						}

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
