package datastructure;

public class DLL<E> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {

		E data;
		Node next;
		Node prev;

		public Node(E data) {
			this.data = data;
		}

	}

	public void insertAtStart(E data) {

		Node newNode = new Node(data);

		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void insertAtEnd(E data) {

		Node newNode = new Node(data);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size++;
	}

	public void insertAt(E data, int index) throws Exception {

		if (index > size) {
			throw new Exception("Not Valid Index. Max index can be " + size);
		}

		if (index == 0) {
			insertAtStart(data);
			return;
		} else if (index == size) {
			insertAtEnd(data);
			return;
		}

		Node newNode = new Node(data);

		Node tempHead = head;
		int i = 1;
		while (i < index) {
			tempHead = tempHead.next;
			i++;
		}

		Node nextNode = tempHead.next;
		newNode.next = nextNode;
		nextNode.prev = newNode;

		tempHead.next = newNode;
		newNode.prev = tempHead;

		size++;
	}

	public void deleteAtStart() {

		if (isEmpty()) {
			System.out.println("Cant delete. List is Empty");
			return;
		}
		if (head == tail) {
			tail = null;
			head = null;
		} else {
			head = head.next;
			head.prev = null;
		}

		size--;
	}

	public void deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("Cant delete. List is Empty");
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		Node tempHead = head;
		int i = 1;
		while (i < size - 1) {
			tempHead = tempHead.next;
			i++;
		}

		Node nextNode = tempHead.next;
		nextNode.prev = null;
		nextNode.next = null;
		tempHead.next = null;
		nextNode = null;

		tail = tempHead;
		size--;
	}

	public void deleteAt(int index) throws Exception {

		if (index >= size) {
			throw new Exception("Not Valid Index. Max index can be " + (size - 1));
		}

		if (index == 0) {
			deleteAtStart();
			return;
		} else if (index == size - 1) {
			deleteAtEnd();
			return;
		}

		Node tempHead = head;
		int i = 1;
		while (i < index) {
			tempHead = tempHead.next;
			i++;
		}

		Node midNode = tempHead.next;
		Node nextNode = midNode.next;

		midNode.prev = null;
		midNode.next = null;

		tempHead.next = nextNode;
		nextNode.prev = tempHead;

		midNode = null;
		size--;
	}

	public E search(E data) {
		Node tempHead = head;

		while (tempHead != null) {
			if (tempHead.data == data)
				return tempHead.data;
			tempHead = tempHead.next;
		}
		return null;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void display() {
		Node tempHead = head;

		while (tempHead != null) {
			System.out.print(tempHead.data + " --> ");
			tempHead = tempHead.next;
		}
		System.out.println("NULL");
	}

	public void displayRev() {
		Node tempHead = tail;

		while (tempHead != null) {
			System.out.print(tempHead.data + " --> ");
			tempHead = tempHead.prev;
		}
		System.out.println("NULL");
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws Exception {

		DLL<Integer> list = new DLL<Integer>();

		System.out.println("INSERTING");

		list.insertAtStart(7);
		list.insertAtStart(6);
		list.display();
		list.displayRev();
		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		list.insertAtEnd(100);
		list.insertAtEnd(101);
		list.display();
		list.displayRev();
		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		list.insertAt(10, 2);
		list.insertAt(11, 3);
		list.display();
		list.displayRev();
		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		// list.insertAt(44, 40);

		// *********************************************************

		System.out.println("DELETING");

		list.deleteAtStart();
		list.display();
		list.displayRev();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAtEnd();
		list.display();
		list.displayRev();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAt(2);
		list.display();
		list.displayRev();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAt(40);
	}

}
