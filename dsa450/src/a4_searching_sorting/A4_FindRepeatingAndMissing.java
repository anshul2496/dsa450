package a4_searching_sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * https://www.youtube.com/watch?v=2D0D8HE6uak
 */
public class A4_FindRepeatingAndMissing {
	public static void main(String[] args) {
		int[] arr = { 2, 2 };
		ArrayList<Integer> ans = new ArrayList<>();
		long num1 = 0;
		long num2 = 0;
		long n = arr.length;
		// S-SN
		// S2-S2N
		long SN = (n * (n + 1)) / 2;
		long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
		long S = 0;
		long S2 = 0;
		for (int i = 0; i < n; i++) {
			S += arr[i];
			S2 += (long) arr[i] * (long) arr[i];
		}
		long val1 = S - SN;
		long val2 = S2 - S2N;
		val2 = val2 / val1;
		num1 = (val1 + val2) / 2;
		num2 = val2 - num1;
		ans.add((int) num1);
		ans.add((int) num2);
		System.out.println(ans);
	}

	// With O(n) space
	int[] findTwoElement(int a[], int n) {
		int[] temp = new int[n + 1];
		int[] ans = new int[2];
		for (int i = 0; i < n; i++) {
			int num = a[i];
			if (temp[num] == -1)
				ans[0] = num;
			else
				temp[num] = -1;
		}
		for (int i = 1; i <= n; i++) {
			if (temp[i] == 0)
				ans[1] = i;
		}
		return ans;
	}
}
