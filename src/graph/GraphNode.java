package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode implements Comparable<GraphNode> {

	private String name;
	private List<GraphNode> neighbours;
	private Map<GraphNode, Integer> weightMap;
	private GraphNode parent;
	private boolean isVisited;
	private int distance;
	private int index;

	public GraphNode(String name) {
		super();
		this.setName(name);
		neighbours = new ArrayList<>();
		setWeightMap(new HashMap<>());
		distance = Integer.MAX_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GraphNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<GraphNode> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public void clearVisited() {
		this.isVisited = false;
	}

	public GraphNode getParent() {
		return this.parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Map<GraphNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(Map<GraphNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	@Override
	public int compareTo(GraphNode o) {
		return this.distance - o.distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
