package graph;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

	private List<GraphNode> graphNodes;
	private int[][] a;
	private static final int maxInt = Integer.MAX_VALUE / 10;

	public FloydWarshall() {
		graphNodes = new ArrayList<>();
	}

	public void add(GraphNode node) {
		node.setIndex(graphNodes.size());
		graphNodes.add(node);
	}

	public void addEdge(int i, int j, int d) {
		GraphNode first = graphNodes.get(i);
		GraphNode second = graphNodes.get(j);

		first.getNeighbours().add(second);
		first.getWeightMap().put(second, d);
	}

	public void calculate() {
		int size = graphNodes.size();
		a = new int[size][size];

		// set each cell value to infinity
		// copy distance from nodes to 2D array
		for (int i = 0; i < a.length; i++) {
			GraphNode currNode = graphNodes.get(i);
			for (int j = 0; j < a[0].length; j++) {
				if (i == j) {
					a[i][j] = 0;
					continue;
				}
				a[i][j] = maxInt;

				if (currNode.getWeightMap().containsKey(graphNodes.get(j))) {
					a[i][j] = currNode.getWeightMap().get(graphNodes.get(j));
				}
			}
		}

		// floyd algo
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					a[i][j] = Integer.min(a[i][j], a[i][k] + a[k][j]);
				}
			}
		}

	}

	public void printDistance() {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {

				System.out.print(a[i][j] + " ");

			}
			System.out.println();
		}

	}

}
