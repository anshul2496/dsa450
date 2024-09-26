package a1_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1
 * https://www.youtube.com/watch?v=V_QB59AaeCk
 */
public class B92_RearrangePosNegWithOrder {
	public static void main(String[] args) {
		int[] a = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
		rearrange(a, a.length); // Array solution
		//rearrange((ArrayList<Integer>) Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2)); // Linked List soln
		System.out.println(Arrays.toString(a));
	}

	static void rearrange(ArrayList<Integer> arr) {
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) >= 0)
				pos.add(arr.get(i));
			else
				neg.add(arr.get(i));
		}
		int p = 0, n = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (i % 2 == 0 && p < pos.size()) {
				ans.add(pos.get(p++));
			} else if (n < neg.size()) {
				ans.add(neg.get(n++));
			}
		}
		while (p < pos.size())
			ans.add(pos.get(p++));
		while (n < neg.size())
			ans.add(neg.get(n++));
		arr.clear();
		arr.addAll(ans);
	}

	static void rearrange(int a[], int n) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n && j < n && k < n) {
			if (k % 2 == 0) {
				// Even index must have pos number
				if (a[k] < 0) {
					i = k;
					j = k;
					while (j < n && a[j] < 0)
						j++;
					if (j >= n)
						break;
					else
						rotate(a, i, j);
				}
			} else {
				// Odd index must have neg number
				if (a[k] >= 0) {
					i = k;
					j = k;
					while (i < n && a[i] >= 0)
						i++;
					if (i >= n)
						break;
					else
						rotate(a, j, i);
				}
			}
			k++;
		}
	}

	private static void rotate(int[] a, int start, int end) {
		int temp = a[end];
		for (int x = end - 1; x >= start; x--) {
			a[x + 1] = a[x];
		}
		a[start] = temp;
	}
}
