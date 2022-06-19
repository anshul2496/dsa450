package a6_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * https://www.youtube.com/watch?v=buOBkLADSxk
 */
public class A4_FindRepeatingAndMissing {
	public static void main(String[] args) {
		int[] a = { 1, 3, 3 };
		int[] result = new int[2];
		int origSum = 0;
		int currSum = 0;
		for (int i = 0; i < a.length; i++) {
			origSum += (i + 1);
			currSum += Math.abs(a[i]);
			int num = Math.abs(a[i]);
			if (a[num - 1] < 0)
				result[0] = Math.abs(a[num - 1]);
			else
				a[num - 1] = -a[i];
		}
		result[1] = origSum - (currSum - result[0]);
		System.out.println(Arrays.toString(result));
	}
}
