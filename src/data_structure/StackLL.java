package data_structure;

public class StackLL {

	private class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	Node top;

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Can't Pop. Stack is empty");
			return -1;
		} else {
			int data = top.data;
			top = top.next;
			return data;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Can't Peek. Stack is empty");
			return -1;
		} else {
			return top.data;
		}
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		return false;
	}

	public static void main(String[] args) {

		StackLL stack = new StackLL();

		// stack underflow
		stack.pop();

		// insert
		stack.push(10);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		// display
		stack.display();

		// peek
		System.out.println("Peek: " + stack.peek());

		// delete
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());

		// display
		stack.display();

		// peek
		System.out.println("Peek: " + stack.peek());

		stack.push(9);
		stack.push(14);

		// display
		stack.display();

	}

	private void display() {
		Node tempTop = top;
		while (tempTop != null) {
			System.out.print(tempTop.data + " --> ");
			tempTop = tempTop.next;
		}
		System.out.println("NULL");
	}

}
