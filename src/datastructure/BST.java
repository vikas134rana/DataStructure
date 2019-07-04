package datastructure;

public class BST {

	private Node root;

	public BST() {
	}

	private class Node {

		int data;
		Node left;
		Node right;

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
		root = innerInsert(root, data);
	}

	private Node innerInsert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (data < node.data) {
			node.left = innerInsert(node.left, data);
		} else if (data > node.data) {
			node.right = innerInsert(node.right, data);
		}

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
		}
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

	public static void main(String[] args) {

		BST bst = new BST();

		bst.insert(10);
		bst.insert(4);
		bst.insert(5);
		bst.insert(15);
		bst.insert(11);
		bst.insert(18);
		bst.insert(13);
		bst.insert(8);
		bst.insert(16);

		bst.inOrder();

		System.out.println("Search 111: " + bst.search(111));
		
		bst.delete(15);
		
		bst.inOrder();

	}
}
