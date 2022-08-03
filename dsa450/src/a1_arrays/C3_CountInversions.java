package a1_arrays;

/*
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/searching-and-sorting/count_inversions/ojquestion
 * https://www.youtube.com/watch?v=uojx--MK_n0
 */
public class C3_CountInversions {
	public static void main(String[] args) {
		int[] a = { 2, 4, 1, 3, 5 };
		mergeSort(a, 0, a.length - 1);
		System.out.println(count);
	}

	static int count = 0;

	static int[] mergeSort(int[] a, int low, int high) {
		if (low == high) {
			int[] ba = new int[1];
			ba[0] = a[low];
			return ba;
		}
		int mid = low + (high - low) / 2;
		int[] left = mergeSort(a, low, mid);
		int[] right = mergeSort(a, mid + 1, high);
		return merge(left, right);
	}

	static int[] merge(int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] merged = new int[left.length + right.length];
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				merged[k++] = left[i++];
			} else {
				count += (left.length - i);
				merged[k++] = right[j++];
			}
		}
		while (i < left.length)
			merged[k++] = left[i++];
		while (j < right.length)
			merged[k++] = right[j++];
		return merged;
	}
}
