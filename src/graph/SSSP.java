package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SSSP {

	List<GraphNode> graphNodes;

	public SSSP() {
		this.graphNodes = new ArrayList<>();
	}

	public void add(GraphNode node) {
		graphNodes.add(node);
	}

	public void addEdge(int i, int j) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
	}

	public void bfs(int index) {
		GraphNode srcNode = graphNodes.get(index);
		bfs(srcNode);
	}

	private void bfs(GraphNode srcNode) {

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(srcNode);
		srcNode.setVisited(true);
		srcNode.setParent(null);

		while (!queue.isEmpty()) {

			GraphNode node = queue.remove();

			for (GraphNode neighbour : node.getNeighbours()) {

				if (!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setVisited(true);
					neighbour.setParent(node);
				}
			}
		}

	}

	public void printPath(GraphNode node) {
		while (node != null) {
			System.out.print(node + " ");
			node = node.getParent();
		}
		System.out.println();

	}

}
