package data_structure;

public class BinaryHeap {

	private int[] a;
	int lastUsedIndex = 0;
	int size;

	public BinaryHeap(int maxSize) {
		a = new int[maxSize + 1];
	}

	public void insert(int data) {
		if (isFull()) {
			System.out.println("Heap is Full.");
			return;
		}
		a[++lastUsedIndex] = data;
		size++;

		int i = lastUsedIndex;
		while (i != 1) {
			int p = i / 2;
			if (a[p] > a[i]) {
				int temp = a[p];
				a[p] = a[i];
				a[i] = temp;
			}
			i = p;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Heap is Empty.");
			return -1;
		}
		return a[1];
	}

	public int extract() {
		if (isEmpty()) {
			System.out.println("Heap is Empty.");
			return -1;
		}
		int value = a[1];
		size--;

		a[1] = a[lastUsedIndex--];

		int i = 1;
		while (2 * i <= lastUsedIndex) {
			
			// index out of left and right which contains minimum value
			int minLRIndex = ((2 * i) + 1) > lastUsedIndex ? 2 * i : (a[2 * i] < a[2 * i + 1] ? 2 * i : 2 * i + 1);
			
			// 
			if (a[i] > a[minLRIndex]) {
				int temp = a[i];
				a[i] = a[minLRIndex];
				a[minLRIndex] = temp;
			}
			i = minLRIndex;
		}

		return value;
	}

	public void print() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return lastUsedIndex == 0;
	}

	public boolean isFull() {
		return lastUsedIndex == a.length - 1;
	}

	public static void main(String[] args) {

		BinaryHeap heap = new BinaryHeap(15);
		heap.insert(1);
		heap.insert(5);
		heap.insert(7);
		heap.insert(11);
		heap.insert(9);
		heap.insert(13);
		heap.insert(15);
		heap.insert(20);

		heap.print();

		heap.extract();
		heap.print();
		
		System.out.println("Peek: "+heap.peek());
		System.out.println("Size: "+heap.size);
	}

}
