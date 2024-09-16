package a1_arrays;

/*
 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1 
 * https://www.youtube.com/watch?v=D3BcHWmNX18
 * Given an array of N integers arr[] where each element represents
 * the max number of steps that can be made forward from that element. Find the
 * minimum number of jumps to reach the end of the array (starting from the
 * first element). If an element is 0, then you cannot move through that
 * element. Example 1: Input: N = 11 arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 Explanation: First jump from 1st element to 2nd element with value
 * 3. Now, from here we jump to 5th element with value 9, and from here we will
 * jump to last.
 */
public class B1_MinJumpsToReachArrayEnd {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 0, 0, 0 };
		int ans = minJumps(arr);
		System.out.println(ans);
	}

	static int minJumps(int[] a) {
		if (a.length == 1)
			return 0;
		if (a[0] == 0)
			return -1;
		int max = 0, jump = 0, halt = 0;
		for (int i = 0; i < a.length - 1; i++) {
			max = Math.max(max, i + a[i]);
			if (i == halt) {
				halt = max;
				jump++;
				if (halt >= a.length - 1)
					break;
			}
		}
		if (halt >= a.length - 1)
			return jump;
		return -1;
	}
}
