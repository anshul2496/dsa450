package arrays;

public class B1_MinJumpsToReachArrayEnd {
	/*
	 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1 
	 * Given an array of N integers arr[] where each element represents
	 * the max number of steps that can be made forward from that element. Find the
	 * minimum number of jumps to reach the end of the array (starting from the
	 * first element). If an element is 0, then you cannot move through that
	 * element.
	 * Example 1:
	 * Input: N = 11 arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} Output: 3
	 * Explanation: First jump from 1st element to 2nd element with value 3. Now,
	 * from here we jump to 5th element with value 9, and from here we will jump to
	 * last.
	 */
	public static void main(String[] args) {
		solution1();
		//jump();
	}

	public static void jump() {
		int[] A = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		System.out.println(jumps);
	}
	
	private static void solution1() {
		int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			System.out.println("Jump not possible");

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < arr.length; i++) {
			// Check if we have reached the end of the array
			if (i == arr.length - 1)
				break;

			// updating maxReach
			maxReach = Math.max(maxReach, i + arr[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump 
				jump++;

				// Check if the current index or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					break;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = arr[i];
			}
		}
		System.out.println("Jumps needed = " + jump);
	}
}
