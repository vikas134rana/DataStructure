package sorting;

public class BubbleSort {

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

		for (int i = 0; i < a.length - 1; i++) {

			for (int j = 0; j < a.length - 1 - i; j++) {

				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}

		}

	}

}
