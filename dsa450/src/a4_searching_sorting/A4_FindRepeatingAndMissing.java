package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * https://www.youtube.com/watch?v=buOBkLADSxk
 */
public class A4_FindRepeatingAndMissing {
	public static void main(String[] args) {
		int[] a = { 1, 3, 3 };
		int[] ans = new int[2];
		int origSum = 0;
		int currSum = 0;
		for (int i = 0; i < a.length; i++) {
			int origElement = Math.abs(a[i]);
			int index = origElement - 1;
			if (a[index] < 0)
				ans[0] = origElement;
			a[index] = -a[index];
			origSum += (i + 1);
			currSum += origElement;
		}
		ans[1] = origSum - (currSum - ans[0]);
		System.out.println(Arrays.toString(ans));
	}
}
