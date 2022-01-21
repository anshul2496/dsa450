package a2_matrix;

import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/max-rectangle/1
 * https://www.youtube.com/watch?v=bgWt2qtFhbQ -> Maximum Rectangle Area
 * https://www.youtube.com/watch?v=0do2734xhnU -> Largest Histogram Area
 * Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.
	Example 1:
	Input:
	n = 4, m = 4
	M[][] = {{0 1 1 0},
	         {1 1 1 1},
	         {1 1 1 1},
	         {1 1 0 0}}
	Output: 8
	Explanation: For the above test case the
	matrix will look like
	0 1 1 0
	1 1 1 1
	1 1 1 1
	1 1 0 0
	the max size square is 
	1 1 1 1
	1 1 1 1
	and area is 4*2 = 8.
 */
public class A6_MaximumSizeRectangleSubArray {
	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int rows = a.length;
		int cols = a[0].length;
		int area = 0;
		int[] heights = new int[cols];

		for (int i = 0; i < cols; i++) {
			heights[i] = a[0][i];
		}
		area = largestHistogramArea(heights);

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (a[i][j] == 0)
					heights[j] = 0;
				else
					heights[j]++;
			}
			area = Math.max(area, largestHistogramArea(heights));
		}
		System.out.println(area);
	}

	private static int largestHistogramArea(int[] heights) {
		// Next smallest index on the right
		int[] rightBoundary = new int[heights.length];
		Stack<Integer> stack = new Stack<>(); // Store indices
		stack.push(heights.length - 1);
		rightBoundary[heights.length - 1] = heights.length; // default spot for smallest element on the right
		// Go from right to left
		for (int i = heights.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) { // Jab tak bada hai tb tak pop kro
				stack.pop();
			}
			if (stack.isEmpty())
				rightBoundary[i] = heights.length;
			else
				rightBoundary[i] = stack.peek();
			stack.push(i);
		}

		// Next smallest index on the left
		int[] leftBoundary = new int[heights.length];
		stack = new Stack<>(); // Store indices
		stack.push(0);
		leftBoundary[0] = -1; // default spot for smallest element on the left
		// Go from left to right
		for (int i = 1; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				leftBoundary[i] = -1;
			else
				leftBoundary[i] = stack.peek();
			stack.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int width = rightBoundary[i] - leftBoundary[i] - 1;
			int area = heights[i] * width;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
}
