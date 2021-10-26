package arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 * 	https://leetcode.com/problems/trapping-rain-water/solution/
 * 	Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
	Example 1:
	Input:
	N = 6
	arr[] = {3,0,0,2,0,4}
	Output:
	10
	Explanation: 
	Total trapped water = 3+3+1+3 = 10
 */
public class D2_TrappingRainWater {
	public static void main(String[] args) {
		solution1(); // O(n), O(1)
	}

	private static void solution1() {
		// Leetcode two pointer explaination
		int[] a = { 3, 0, 0, 4, 0, 2 };
		int left = 0, right = a.length - 1;
		int leftMax = 0, rightMax = 0;
		int ans = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, a[left]);
			rightMax = Math.max(rightMax, a[right]);
			if (leftMax < rightMax) {
				ans += leftMax - a[left];
				left++;
			} else {
				ans += rightMax - a[right];
				right--;
			}
		}
		System.out.println(ans);
	}
}
