package a1_arrays;

/*
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * 	Given an array of integers. Find the Inversion Count in the array. 
	Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. 
	If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
	Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
	Example 1:
	Input: N = 5, arr[] = {2, 4, 1, 3, 5}
	Output: 3
	Explanation: The sequence 2, 4, 1, 3, 5 
	has three inversions (2, 1), (4, 1), (4, 3).
 */
public class C5_CountInversion {
	public static void main(String[] args) {
		int[] a = { 2, 4, 1, 3, 5 };
		System.out.println(mergeSortAndCount(a, 0, a.length - 1));
	}

	private static int mergeSortAndCount(int[] a, int low, int high) {
		int count = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			count = count + mergeSortAndCount(a, low, mid);
			count = count + mergeSortAndCount(a, mid + 1, high);
			count = count + mergeAndCount(a, low, mid, high);
		}
		return count;
	}

	private static int mergeAndCount(int[] a, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;
		int[] b = new int[high + 1];
		int count = 0;
		while (i <= mid && j <= high) {
			if (a[i] < a[j])
				b[k++] = a[i++];
			else {
				b[k++] = a[j++];
				count = count + mid - low;
			}
		}
		while (i <= mid) {
			b[k++] = a[i++];
		}
		while (j <= high) {
			b[k++] = a[j++];
		}
		for (i = low; i <= high; i++)
			a[i] = b[i];
		return count;
	}
}
