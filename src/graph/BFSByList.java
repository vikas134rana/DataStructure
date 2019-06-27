package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSByList {

	private List<GraphNode> graphNodes;

	public BFSByList() {
		graphNodes = new ArrayList<>();
	}

	public void addNode(GraphNode node) {
		graphNodes.add(node);
	}

	public void bfs() {

		for (GraphNode node : graphNodes) {
			if (!node.isVisited()) {
				bfs(node);
			}
		}
		
		System.out.println();

	}

	private void bfs(GraphNode graphNode) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(graphNode);

		while (!queue.isEmpty()) {
			
			GraphNode node = queue.remove();
			if(node.isVisited())
				continue;
			
			System.out.print(node.getName() + " ");
			node.setVisited(true);

			for (GraphNode neighbour : graphNode.getNeighbours()) {
				if (!neighbour.isVisited()) {
					queue.add(neighbour);
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

}
