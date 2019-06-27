package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSByList {

	List<GraphNode> graphNodes;

	public DFSByList() {
		graphNodes = new ArrayList<>();
	}

	public void addNode(GraphNode node) {
		graphNodes.add(node);
	}

	public void dfs() {

		for (GraphNode node : graphNodes) {
			if (!node.isVisited()) {
				dfs(node);
			}
		}

		System.out.println();

		clearVisited();

	}

	private void dfs(GraphNode graphNode) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(graphNode);

		while (!stack.isEmpty()) {

			GraphNode node = stack.pop();
			node.setVisited(true);
			System.out.print(node.getName() + " ");

			for (GraphNode neighbour : node.getNeighbours()) {
				if (!neighbour.isVisited()) {
					stack.push(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}

	public void connectEdges(int i, int j) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
	}

	public void clearVisited() {
		for (GraphNode graphNode : graphNodes) {
			graphNode.clearVisited();
		}
	}

}
