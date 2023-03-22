package a1_arrays;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://www.youtube.com/watch?v=afwPSXmRsGs
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained 
 * after merging the above 2 arrays(i.e. array of length 2n). 
 * The complexity should be O(log(n)). 
 * Input : a1[] = {1,12,15,26,38}
 * a2[] = {2,13,17,30,45}
 * Output = 16
 * Explanation: After merging two arrays we get {1,2,12,13,15,17,26,30,38,45}
 * Middle two elements are 15 and 17.  Average of middle elements is (15+17)/2 which is equal to 16
 */
public class D5_MedianOf2SortedArrays {
	public static void main(String[] args) {
		int[] a = { 1, 12, 15, 26, 38 };
		int[] b = { 2, 13, 17, 30, 45 };
		double median = solution(a, b); // O(log(m+n))
		System.out.println(median);
	}

	private static double solution(int[] a, int[] b) {
		if (a.length > b.length) {
			return solution(b, a);
		}
		int n1 = a.length;
		int n2 = b.length;
		int low = 0; 
		int high = n1;
		while (low <= high) { // Note "<=" and high=a.length
			// Initialize the cuts or partitions
			int cut1 = low + (high - low) / 2;

			// Total required - already present
			int cut2 = ((n1 + n2) / 2) - cut1;

			// Initialize l1,l2,r1,r2
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
			int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
			int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

			// Shift elements to the left
			if (l1 > r2)
				high = cut1 - 1;
			else if (l2 > r1)
				low = cut1 + 1;
			else {
				// Check for even length
				if ((n1 + n2) % 2 == 0) {
					return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
				} else {
					return (double) Math.min(r1, r2);
				}
			}
		}
		return 0.0;
	}
}
