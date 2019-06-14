package data_structure;

public class CirQueue {

	private int[] queue;
	private int maxSize;
	private int size;
	private int front;
	private int rear;

	public CirQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
		front = -1;
		rear = -1;
		size = 0;
	}

	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Cant Insert. Queue is Full");
		} else {
			if (isEmpty())
				front = 0;
			rear = (rear + 1) % maxSize;
			queue[rear] = data;
			size++;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Cant Delete. Queue is Empty");
			return -1;
		} else {
			int data = queue[front];
			front = (front + 1) % maxSize;
			size--;
			return data;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Cant Delete. Queue is Empty");
			return -1;
		} else {
			return queue[front];
		}
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public boolean isFull() {
		if (size == maxSize)
			return true;
		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Cant Display. Queue is Empty");
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		CirQueue stack = new CirQueue(5);

		// stack underflow
		stack.dequeue();

		// insert
		stack.enqueue(10);
		stack.enqueue(2);
		stack.enqueue(3);
		stack.enqueue(4);
		stack.enqueue(5);

		// display
		stack.display();

		// peek
		System.out.println("Peek: " + stack.peek());

		// delete
		System.out.println("Pop: " + stack.dequeue());
		System.out.println("Pop: " + stack.dequeue());

		// display
		stack.display();

		// delete
		System.out.println("Pop: " + stack.dequeue());
		System.out.println("Pop: " + stack.dequeue());
		System.out.println("Pop: " + stack.dequeue());
		System.out.println("Pop: " + stack.dequeue());

		// display
		stack.display();

		// peek
		System.out.println("Peek: " + stack.peek());

		stack.enqueue(9);
		stack.enqueue(14);
		stack.enqueue(15);
		stack.enqueue(14);
		stack.enqueue(15);
		stack.enqueue(14);
		stack.enqueue(15);

		// display
		stack.display();

	}

}
