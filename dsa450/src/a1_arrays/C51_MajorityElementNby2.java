package a1_arrays;

/*
 * https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
 * https://www.youtube.com/watch?v=-s-qtf9flqg
 * Can also be done by frequency map but will take O(n) space
 */
public class C51_MajorityElementNby2 {
	public static void main(String[] args) {
		int[] a = { 3, 1, 3, 3, 2 };
		// Boyer-Moore Voting Algorithm
		int val = getPotentialMajorityElement(a, a.length);
		boolean isMaj = isValMajorityElement(a, val);
		if (isMaj) {
			System.out.println(val);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean isValMajorityElement(int[] a, int val) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == val) {
				count++;
			}
		}
		return count > (a.length / 2);
	}

	public static int getPotentialMajorityElement(int[] a, int n) {
		int candidate = a[0];
		int votes = 1;
		for (int i = 1; i < n; i++) {
			if (votes == 0) {
				candidate = a[i];
				votes = 1;
			} else {
				if (candidate == a[i])
					votes++;
				else
					votes--;
			}
		}
		return candidate;
	}
}
