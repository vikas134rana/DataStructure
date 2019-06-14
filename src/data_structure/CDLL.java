package data_structure;

public class CDLL {

	private Node1 head;
	private Node1 tail;
	private int size;

	public void insertAtStart(int data) {

		Node1 newNode = new Node1(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}

		head.prev = tail;
		tail.next = head;

		size++;
	}

	public void insertAtEnd(int data) {

		Node1 newNode = new Node1(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}

		head.prev = tail;
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

		Node1 newNode = new Node1(data);

		Node1 tempHead = head;
		int i = 1;
		while (i < index) {
			tempHead = tempHead.next;
			i++;
		}

		Node1 nextNode = tempHead.next;
		newNode.next = nextNode;
		nextNode.prev = newNode;

		tempHead.next = newNode;
		newNode.prev = tempHead;

		size++;
	}

	public void deleteAtStart() {

		if (head == null) {
			System.out.println("Cant delete. List is Empty");
			return;
		}
		if (head == tail) {
			tail = null;
			head = null;
		} else {
			head = head.next;
			head.prev = tail;
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
			size--;
			return;
		}

		Node1 tempHead = head;
		int i = 1;
		while (i < size - 1) {
			tempHead = tempHead.next;
			i++;
		}

		tempHead.next = null;
		tail = tempHead;

		head.prev = tail;
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

		Node1 tempHead = head;
		int i = 1;
		while (i < index) {
			tempHead = tempHead.next;
			i++;
		}

		Node1 midNode = tempHead.next;
		Node1 nextNode = midNode.next;

		midNode.prev = null;
		midNode.next = null;

		tempHead.next = nextNode;
		nextNode.prev = tempHead;

		midNode = null;
		size--;
	}

	public boolean search(int data) {
		Node1 tempHead = head;

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
		Node1 tempHead = head;

		while (tempHead != null) {
			System.out.print(tempHead.data + " --> ");

			if (tempHead == tail)
				break;

			tempHead = tempHead.next;
		}
		System.out.println("NULL");
	}

	public void displayRev() {
		Node1 tempTail = tail;

		while (tempTail != null) {
			System.out.print(tempTail.data + " --> ");

			if (tempTail == head)
				break;

			tempTail = tempTail.prev;
		}
		System.out.println("NULL");
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws Exception {

		CDLL list = new CDLL();

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
