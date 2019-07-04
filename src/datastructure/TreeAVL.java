package datastructure;

public class TreeAVL {

	private Node root;

	public TreeAVL() {
	}

	private class Node {

		int data;
		Node left;
		Node right;
		int height;

		public Node(int data) {
			this.data = data;
		}

		public boolean isLeafNode() {
			return (this.left == null && this.right == null);
		}

		public boolean hasBothNode() {
			return (this.left != null && this.right != null);
		}

		public boolean hasLeftNode() {
			return (this.left != null);
		}

		/*- public boolean hasRightNode() {
			return (this.right != null);
		}*/

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node rotateLeft(Node node) {
		Node newRoot = node.right;
		node.right = node.right.left;
		newRoot.left = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
		return newRoot;
	}

	private Node rotateRight(Node node) {
		Node newRoot = node.left;
		node.left = node.left.right;
		newRoot.right = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
		return newRoot;
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}

		int heigthDiff = height(node.left) - height(node.right);

		if (heigthDiff > 1) {

			if (height(node.left.left) > height(node.left.right)) { // LL
				node = rotateRight(node);
			} else { // LR
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}

		} else if (heigthDiff < -1) {

			if (height(node.right.right) > height(node.right.left)) { // RR
				node = rotateLeft(node);
			} else { // RL
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}

		}

		if (node.left != null)
			node.left.height = height(node.left);
		if (node.right != null)
			node.right.height = height(node.right);

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	public void delete(int data) {
		innerDelete(root, data);
	}

	public Node innerDelete(Node node, int data) {
		if (node == null)
			return null;

		if (data < node.data) {
			node.left = innerDelete(node.left, data);
		} else if (data > node.data) {
			node.right = innerDelete(node.right, data);
		} else {
			if (node.isLeafNode()) {
				node = null;
			} else if (node.hasBothNode()) {
				Node tempNode = node;
				Node minNode = minimumNodeInSubTree(tempNode.right);
				node.data = minNode.data;
				node.right = innerDelete(node.right, minNode.data);

			} else if (node.hasLeftNode()) {
				node = node.left;
			} else {
				node = node.right;
			}
			return node;
		}

		int heigthDiff = height(node.left) - height(node.right);

		if (heigthDiff > 1) {

			if (height(node.left.left) > height(node.left.right)) { // LL
				node = rotateRight(node);
			} else { // LR
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}

		} else if (heigthDiff < -1) {

			if (height(node.right.right) > height(node.right.left)) { // RR
				node = rotateLeft(node);
			} else { // RL
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}

		}

		if (node.left != null)
			node.left.height = height(node.left);
		if (node.right != null)
			node.right.height = height(node.right);

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	private Node minimumNodeInSubTree(Node node) {
		if (node.left == null)
			return node;
		else
			return minimumNodeInSubTree(node.left);
	}

	public Node search(int data) {
		return innerSearch(root, data);
	}

	public Node innerSearch(Node node, int data) {
		if (node == null)
			return null;

		if (data == node.data) {
			return node;
		} else if (data < node.data) {
			return innerSearch(node.left, data);
		} else {
			return innerSearch(node.right, data);
		}
	}

	public void inOrder() {
		innerInOrder(root);
		System.out.println();
	}

	private void innerInOrder(Node node) {
		if (node == null)
			return;

		innerInOrder(node.left);
		System.out.print(node.data + " ");
		innerInOrder(node.right);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return node.height;
	}

	public void traverseLevel() {
		if (isEmpty()) {
			System.out.println("Cant display. Tree is empty.");
			return;
		}

		QueueLL<Node> queue = new QueueLL<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		TreeAVL avl = new TreeAVL();

		avl.insert(30);
		avl.insert(20);
		avl.insert(40);
		avl.insert(10);
		avl.traverseLevel();

		avl.insert(5);
		avl.traverseLevel();

		avl.insert(3);
		avl.traverseLevel();

		avl.insert(4);
		avl.traverseLevel();

		avl.insert(50);
		avl.traverseLevel();

		avl.insert(60);
		avl.traverseLevel();

		avl.insert(70);
		avl.traverseLevel();

		avl.insert(65);
		avl.traverseLevel();

	}
}
