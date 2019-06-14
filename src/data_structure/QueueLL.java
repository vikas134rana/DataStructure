package data_structure;

public class QueueLL<E> {

	private class Node {
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
		}

	}

	Node front;
	Node rear;
	int size;

	public void enqueue(E data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	public E dequeue() {
		if (isEmpty()) {
			System.out.println("Cant delete. Queue underflow.");
			return null;
		}

		E data = front.data;
		if (size == 1) {
			front = rear = null;
		} else {
			front = front.next;
		}
		size--;
		return data;
	}

	public E peek() {
		if (isEmpty()) {
			System.out.println("Cant Peek. Queue is empty.");
			return null;
		}
		return front.data;
	}

	public boolean isEmpty() {
		if (front == null && rear == null)
			return true;
		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Cant Display. Queue is empty.");
		} else {
			Node tempNode = front;
			while (tempNode != null) {
				System.out.print(tempNode.data + " --> ");
				tempNode = tempNode.next;
			}
			System.out.println("NULL");
		}
	}

	public static void main(String[] args) {
		QueueLL<Integer> stack = new QueueLL<Integer>();

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

		// display
		stack.display();
	}

}
