package graph;

public class TestGraphByList {

	public static void main(String[] args) {

		DFSByList graph = new DFSByList();

		for (int i = 1; i <= 5; i++) {
			graph.addNode(new GraphNode("V" + i));
		}
		
		graph.connectEdges(0, 1);
		graph.connectEdges(0, 2);
		graph.connectEdges(1, 3);
		graph.connectEdges(2, 3);
		graph.connectEdges(2, 4);
		graph.connectEdges(3, 4);
		
		graph.dfs();
		graph.dfs();
		
	}
}
