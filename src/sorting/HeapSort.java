package sorting;

import data_structure.BinaryHeap;

public class HeapSort {

	
	public static void main(String[] args) {
		int[] a = { 30, 10, 20, 50, 40 };
		System.out.println("Actual Array");
		print(a);

		sort(a);

		System.out.println("Sorted Array");
		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void sort(int[] a) {

		BinaryHeap heap = new BinaryHeap(a.length);
		for (int i = 0; i < a.length; i++) {
			heap.insert(a[i]);
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] = heap.extract();
		}

	}
}
