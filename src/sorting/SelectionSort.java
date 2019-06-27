package sorting;

public class SelectionSort {

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

	public static int[] sort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}

		return a;
	}

}
