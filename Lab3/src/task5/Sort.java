package task5;

public class Sort {
	private static <E> void swap(E [] array, int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static <E extends Comparable<E>> void quickSort(E [] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static <E extends Comparable<E>> void quickSort(E [] array, int begin, int end) {
		if (begin < end) {
			int pivot = partition(array, begin, end);
			quickSort(array, begin, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {
		E pivot = array[end];
		int i = begin;

		for (int j = begin; j < end; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				swap(array, i, j);
				i++;
			}
		}

		swap(array, i, end);

		return i;
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private static <E extends Comparable<E>> void mergeSort(E[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
	
	private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		E[] L = (E[]) new Comparable[n1];
		E[] R = (E[]) new Comparable[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = array[left + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = array[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;
		
		while (i < n1 || j < n2) {
			if(i == n1) {
				array[k]= R[j++];
			}
			else if(j == n2) {
				array[k] = L[i++];
			}
			else if (L[i].compareTo(R[j]) <= 0) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
	}

}


