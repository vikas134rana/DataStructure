package data_structure;

public class StackGeneric<E> {

	private int maxSize;
	private int top = -1;
	private int size = 0;
	E[] stack;

	@SuppressWarnings("unchecked")
	public StackGeneric(int maxSize) {
		this.maxSize = maxSize;
		stack = (E[]) new Object[maxSize];
	}

	public void push(E data) {
		if (isFull()) {
			System.out.println("Cant push. Stack Overflow");
		} else {
			stack[++top] = data;
			size++;
		}
	}

	public E pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cant pop. Stack underflow");
		} else {
			E data = stack[top--];
			size--;
			return data;
		}

	}

	public E peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cant peek. Stack is empty");
		} else {
			E data = stack[top];
			return data;
		}

	}

	public boolean isFull() {
		if (size >= maxSize)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Cant Display. Stack is empty");
		} else {
			for (int i = 0; i <= top; i++) {
				System.out.print(stack[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {

		StackGeneric<Integer> stack = new StackGeneric<Integer>(5);

		// stack underflow
//		stack.pop();

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

		// stack overerflow
//		stack.push(15);

	}

}
