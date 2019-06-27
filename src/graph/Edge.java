package graph;

public class Edge {

	private GraphNode first;
	private GraphNode second;
	private int weight;

	public Edge(GraphNode first, GraphNode second, int weight) {
		super();
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	public GraphNode getFirst() {
		return first;
	}

	public void setFirst(GraphNode first) {
		this.first = first;
	}

	public GraphNode getSecond() {
		return second;
	}

	public void setSecond(GraphNode second) {
		this.second = second;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
