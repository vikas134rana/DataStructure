package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 20, 30, 10, 50, 40 };
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

		for(int i=1;i<a.length;i++) {
			
			int j=i-1;
			while(j>=0) {
				
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				j--;
			}
		}

		return a;
	}
	
}
