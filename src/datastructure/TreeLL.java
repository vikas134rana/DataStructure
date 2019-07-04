package datastructure;

public class TreeLL {

	private Node root;

	public TreeLL() {
	}

	private class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			root = newNode;
			return;
		}
		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
			if (node.left == null) {
				node.left = newNode;
				return;
			} else if (node.right == null) {
				node.right = newNode;
				return;
			} else {
				queue.enqueue(node.left);
				queue.enqueue(node.right);
			}
		}
	}

	public int delete(int data) {
		if (isEmpty()) {
			System.out.println("Cant search. Tree is empty");
			return -1;
		}
		
		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
			if (node.data == data) {
				System.out.println("Deleting data " + data);
				node.data = getDeepestNode().data;
				deleteDeepestNode();
				return data;
			}
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
		return -1;
	}

	public int search(int data) {
		if (isEmpty()) {
			System.out.println("Cant search. Tree is empty");
			return -1;
		}

		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
			if (node.data == data) {
				System.out.println("Found data " + data);
				return data;
			}
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
		System.out.println("Not Found data " + data);
		return -1;
	}

	public boolean deleteDeepestNode() {
		if (isEmpty()) {
			System.out.println("Cant delete deepest node. Tree is empty");
			return false;
		}

		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		Node currNode = null, prevNode = null;
		while (!queue.isEmpty()) {
			prevNode = currNode;
			currNode = queue.dequeue();

			if (currNode.left == null) {
				prevNode.right = null;
				return true;
			}
			if (currNode.right == null) {
				currNode.left = null;
				return true;
			}

			queue.enqueue(currNode.left);
			queue.enqueue(currNode.right);
		}
		return false;
	}

	public Node getDeepestNode() {
		if (isEmpty()) {
			System.out.println("Cant find deepest node. Tree is empty");
			return null;
		}

		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.dequeue();
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
		return node;
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Cant display. Tree is empty.");
			return;
		}

		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
//			System.out.print("(" + node.left + ")" + node.data + "(" + node.right + ")" + " ");
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
		System.out.println();

	}

	public boolean isEmpty() {
		return root == null;
	}

	public static void main(String[] args) {

		TreeLL tree = new TreeLL();

		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);

		tree.display();

		tree.search(11);

		System.out.println("Deepest Node: " + tree.getDeepestNode().data);
		
		System.out.println("Delete Deepest Node: " + tree.delete(7));
		tree.display();
	}
}
