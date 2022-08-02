package a1_arrays;

/*
 * https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 * https://www.youtube.com/watch?v=jzQ-f2uU0UU
 * The ans will lie in the left subarray or right subarray. 
 * E.g.- {8,-2,4,-9,8,6,-3}
 * The ans will be product of {8,-2,4,-9,8,6} which is left subarray
 * E.g.- {-3,-2,4,-9,8,6,8}
 * The ans will be product of {-2,4,-9,8,6,8} which is right subarray
 */
public class C4_MaxProductSubarray {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 6, -3, -10, 0, 2 };
		int max_so_far = Integer.MIN_VALUE;
		int max_till_now = 1;
		for (int i = 0; i < a.length; i++) {
			max_till_now = max_till_now * a[i];
			if (max_so_far < max_till_now) {
				max_so_far = max_till_now;
			}
			if (max_till_now == 0) {
				max_till_now = 1;
			}
		}
		max_till_now = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			max_till_now = max_till_now * a[i];
			if (max_so_far < max_till_now) {
				max_so_far = max_till_now;
			}
			if (max_till_now == 0) {
				max_till_now = 1;
			}
		}
		System.out.println(max_so_far);
	}

}
