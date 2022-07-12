package a1_arrays;

/*
 * https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
 * https://www.youtube.com/watch?v=-s-qtf9flqg
 * Can also be done by frequency map but will take O(n) space
 */
public class C71_MajorityElement {
	public static void main(String[] args) {
		int[] a = { 3, 1, 3, 3, 2 };
		int val = getPotentialMajorityElement(a);
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

	private static int getPotentialMajorityElement(int[] a) {
		int val = a[0];
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (val == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				val = a[i];
				count = 1;
			}
		}
		return val;
	}
}
