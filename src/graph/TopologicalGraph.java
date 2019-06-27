package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalGraph {

	private List<GraphNode> graphNodes;

	public TopologicalGraph() {
		graphNodes = new ArrayList<>();
	}

	public void addNodes(GraphNode node) {
		graphNodes.add(node);
	}

	public void addEdge(int i, int j) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
	}

	public void traverse() {
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : graphNodes) {
			if (!node.isVisited()) {
				traverse(node, stack);
			}
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
	}

	private void traverse(GraphNode node, Stack<GraphNode> stack) {

		for (GraphNode neighbour : node.getNeighbours()) {
			if (!neighbour.isVisited()) {
				traverse(neighbour, stack);
			}
		}

		node.setVisited(true);
		stack.push(node);

	}

}
