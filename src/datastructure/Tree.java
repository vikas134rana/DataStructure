package datastructure;

public class Tree {

	private int[] arr;
	private int maxSize;
	private int lastUsedIndex;

	public Tree(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}

	public void insert(int data) {
		if (isFull()) {
			System.out.println("Can't Insert. Tree is full");
			return;
		}
		arr[++lastUsedIndex] = data;
	}

	public void delete(int data) {
		if (isEmpty()) {
			System.out.println("Can't Delete. Tree is empty");
			return;
		}
		int matchIndex = -1;
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == data) {
				matchIndex = i;
			}
		}

		if (matchIndex == -1) {
			System.out.println("Can't Delete. Data(" + data + ") not found.");
		}

		arr[matchIndex] = arr[lastUsedIndex--];
	}

	public boolean search(int data) {
		if (isEmpty()) {
			System.out.println("Can't Search. Tree is empty");
			return false;
		}

		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == data) {
				return true;
			}
		}
		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Can't Display. Tree is empty");
			return;
		}

		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return lastUsedIndex < 1;
	}

	public boolean isFull() {
		return lastUsedIndex == maxSize - 1;
	}

	public static void main(String[] args) {
		Tree tree = new Tree(50);

		tree.delete(5);
		
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);

		tree.display();

		System.out.println("Search 7: " + tree.search(7));

		tree.delete(7);
		tree.display();
		System.out.println("Search 7: " + tree.search(7));
	}

}
