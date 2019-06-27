package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Krushkals {

	List<GraphNode> graphNodes;
	List<Edge> edges;

	public Krushkals() {
		this.graphNodes = new ArrayList<>();
		this.edges = new ArrayList<>();
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

		edges.add(new Edge(first, second, d));
	}

	public void calculate() {

		int cost = 0;

		Comparator<Edge> comparator = new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		};

		Collections.sort(edges, comparator);

		DisjointSet disjointSet = new DisjointSet();
		disjointSet.makeSet(graphNodes);

		for (Edge edge : edges) {
			GraphNode first = edge.getFirst();
			GraphNode second = edge.getSecond();

			if (disjointSet.find(first) != disjointSet.find(second)) {
				disjointSet.union(first, second);
				cost += edge.getWeight();
			}
		}

		System.out.println("Mininum Cost: " + cost);
	}

}
