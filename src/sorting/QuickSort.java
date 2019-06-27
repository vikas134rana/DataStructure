package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 30, 10, 20, 50, 40 };
		System.out.println("Actual Array");
		print(a);

		sort(a, 0, a.length - 1);

		System.out.println("Sorted Array");
		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void sort(int[] a, int l, int r) {

		if (l < r) {

			int p = partition(a, l, r);
			sort(a, l, p-1);
			sort(a, p+1, r);
		}

	}

	public static int partition(int[] a, int l, int r) {

		int pivot = a[r];
		int i = l - 1;

		for (int j = l; j <= r; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return i;
	}

}
