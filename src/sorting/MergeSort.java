
package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 30, 10, 20, 50, 40 };
		System.out.println("Actual Array");
		print(a);

		sort(a, 0, a.length-1);

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

		if (r > l) {

			int m = (l + r) / 2;
			sort(a, l, m);
			sort(a, m + 1, r);
			merge(a, l, m, r);
		}
	}

	private static void merge(int[] a, int l, int m, int r) {

		System.out.println(l + " " + m + " " + r);

		int[] left = new int[m - l + 1];
		int[] right = new int[r - m];

		for (int i = 0; i < left.length; i++) {
			left[i] = a[l + i];
		}

		for (int j = 0; j < right.length; j++) {
			System.out.println(m);
			right[j] = a[m + 1 + j];
		}

		int i = 0;
		int j = 0;
		int c = l;

		while (i < left.length && j < right.length) {

			if (left[i] <= right[j]) {
				a[c] = left[i];
				i++;
			} else {
				a[c] = right[j];
				j++;
			}
			c++;
		}

		while (i < left.length) {
			a[c] = left[i];
			i++;
			c++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < right.length) {
			a[c] = right[j];
			j++;
			c++;
		}

	}

}
