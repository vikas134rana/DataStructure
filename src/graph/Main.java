package graph;

public class Main {

	public static void main(String[] args) {
		kruskalsMain();
	}

	public static void topologicalMain() {
		TopologicalGraph graph = new TopologicalGraph();

		for (int i = 65; i < 73; i++) {
			graph.addNodes(new GraphNode("" + (char) i));
		}

		graph.addEdge(0, 2);
		graph.addEdge(1, 2);

		graph.addEdge(1, 3);
		graph.addEdge(2, 4);

		graph.addEdge(3, 5);
		graph.addEdge(4, 5);

		graph.addEdge(5, 6);
		graph.addEdge(4, 7);

		graph.traverse();
	}

	/*- Single Source Shortest  Path 
	 *  1. BFS
	 *  2. Dijkstra
	 *  3. Bellman Ford
	 */
	public static void SSSPMain() {

		SSSP graph = new SSSP();

		for (int i = 0; i <= 9; i++) {
			graph.add(new GraphNode(String.valueOf(i)));
		}

		graph.addEdge(0, 8);
		graph.addEdge(8, 2);
		graph.addEdge(8, 9);
		graph.addEdge(2, 4);
		graph.addEdge(2, 1);
		graph.addEdge(9, 1);
		graph.addEdge(4, 3);
		graph.addEdge(1, 7);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(7, 6);
		graph.addEdge(5, 6);

		graph.bfs(2);

		for (int i = 0; i < graph.graphNodes.size(); i++) {
			GraphNode node = graph.graphNodes.get(i);
			graph.printPath(node);
		}
	}

	public static void dijkstraMain() {
		Dijkstra graph = new Dijkstra();

		for (int i = 65; i < 65 + 5; i++) {
			graph.add(new GraphNode(String.valueOf((char) i)));
		}

		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);

		graph.addEdge(1, 0, 3);

		graph.addEdge(2, 3, 2);

		graph.addEdge(3, 1, 1);
		graph.addEdge(3, 2, 1);

		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 1, 4);

		graph.traverse(4);

		graph.printDistance();

	}

	public static void bellmanFordMain() {
		BellmanFord graph = new BellmanFord();

		for (int i = 65; i < 65 + 5; i++) {
			graph.add(new GraphNode(String.valueOf((char) i)));
		}

		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, -6);

		graph.addEdge(1, 0, 3);

		graph.addEdge(2, 3, 2);

		graph.addEdge(3, 1, 1);
		graph.addEdge(3, 2, 1);

		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 1, 4);

		graph.traverse(4);

		graph.printDistance();

	}

	/*- All Pair Shortest Path
	 *  1. FloydWarshall 
	 */
	public static void floydWarshallMain() {
		FloydWarshall graph = new FloydWarshall();

		for (int i = 65; i < 65 + 4; i++) {
			graph.add(new GraphNode(String.valueOf((char) i)));
		}

		graph.addEdge(0, 1, 8);
		graph.addEdge(0, 3, 1);

		graph.addEdge(1, 2, 1);

		graph.addEdge(2, 0, 4);

		graph.addEdge(3, 1, 2);
		graph.addEdge(3, 2, 9);

		graph.calculate();

		graph.printDistance();

	}

	/*- Minimum Spanning Tree */
	public static void primsMain() {

		Prims graph = new Prims();

		for (int i = 65; i < 65 + 5; i++) {
			graph.add(new GraphNode(String.valueOf((char) i)));
		}

		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 20);

		graph.addEdge(1, 2, 30);
		graph.addEdge(1, 3, 5);

		graph.addEdge(2, 3, 15);
		graph.addEdge(2, 4, 6);

		graph.addEdge(3, 4, 8);

		graph.calculate(0);

	}

	public static void kruskalsMain() {

		Krushkals graph = new Krushkals();

		for (int i = 65; i < 65 + 5; i++) {
			graph.add(new GraphNode(String.valueOf((char) i)));
		}

		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 20);

		graph.addEdge(1, 2, 30);
		graph.addEdge(1, 3, 5);

		graph.addEdge(2, 3, 15);
		graph.addEdge(2, 4, 6);

		graph.addEdge(3, 4, 8);

		graph.calculate();

	}

}
