package data_structure;

import java.util.LinkedList;

public class Hash {

	private LinkedList<String>[] hashTable;

	@SuppressWarnings("unchecked")
	public Hash(int size) {
		hashTable = new LinkedList[size];
	}

	private int hashFunction(String str) {
		char[] ch = str.toCharArray();
		int sum = 0;
		for (int i = 0; i < ch.length; i++) {
			sum += ch[i];
		}
		return sum % hashTable.length;
	}

	public void insert(String data) {
		int index = hashFunction(data);
		if (hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
			hashTable[index].add(data);
		} else {
			hashTable[index].add(data);
		}
	}

	public void delete(String data) {
		int index = hashFunction(data);
		if (hashTable[index] != null) {
			hashTable[index].remove(data);
		}
	}

	public void print() {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print(i+" => ");
			if(hashTable[i]==null) {
				System.out.println("NULL");
				continue;
			}
			hashTable[i].forEach(v -> System.out.print(v + " "));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Hash hash = new Hash(20);
		
		hash.insert("a");
		hash.insert("b");
		hash.insert("d");
		hash.insert("ab");
		hash.insert("ba");
		
		hash.print();
		
		hash.delete("ba");
		hash.print();
	}
	
}
