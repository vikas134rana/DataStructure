package datastructure;

public class CSLL {

	private Node head;
	private Node tail;
	private int size;

	public void insertAtStart(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			size++;
			return;
		}

		newNode.next = head;
		head = newNode;
		tail.next = head;
		size++;
	}

	public void insertAtEnd(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		tail.next = head;
		size++;
	}

	public void insertAt(int data, int index) throws Exception {

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

		newNode.next = tempHead.next;
		tempHead.next = newNode;
		size++;
	}

	public void deleteAtStart() {

		if (head == null) {
			System.out.println("Cant delete. List is Empty");
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			tail.next = head;
		}
		size--;
	}

	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("Cant delete. List is Empty");
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
		}

		Node tempHead = head;
		int i = 1;
		while (i < size - 1) {
			tempHead = tempHead.next;
			i++;
		}

		tempHead.next = null;
		tail = tempHead;
		tail.next = head;
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

		tempHead.next = tempHead.next.next;
		size--;
	}

	public boolean search(int data) {
		Node tempHead = head;

		while (tempHead != null) {
			if (tempHead.data == data)
				return true;

			if (tempHead == tail)
				break;

			tempHead = tempHead.next;
		}
		return false;
	}

	public void display() {
		Node tempHead = head;

		while (tempHead != null) {
			System.out.print(tempHead.data + " --> ");

			if (tempHead == tail)
				break;

			tempHead = tempHead.next;
		}
		System.out.println("NULL");
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws Exception {

		CSLL list = new CSLL();

		System.out.println("INSERTING");

		list.insertAtStart(7);
		list.insertAtStart(6);
		list.display();

		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		list.insertAtEnd(100);
		list.insertAtEnd(101);
		list.display();
		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		list.insertAt(10, 2);
		list.insertAt(11, 3);
		list.display();
		System.out.println("Found 10 : " + list.search(10));
		System.out.println(list.size());

		// list.insertAt(44, 40);

		// *********************************************************

		System.out.println("DELETING");

		list.deleteAtStart();
		list.display();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAtEnd();
		list.display();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAt(2);
		list.display();
		System.out.println("Found 101 : " + list.search(101));
		System.out.println(list.size());

		list.deleteAt(40);
	}

}
