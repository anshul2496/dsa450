package a6_binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/
 * https://www.youtube.com/watch?v=SyIzeO39ZPk
 * https://www.youtube.com/watch?v=m-8_yQao-lI - Minimum Swaps required to sort an array
 */
public class B9_MinSwapConvertBinaryTreeToBST {
	public static void main(String[] args) {
		int[] a = { 5, 6, 7, 8, 9, 10, 11 };
		int ans = getMinimumSwaps(a);
		System.out.println(ans);
	}

	private static int getMinimumSwaps(int[] a) {
		ArrayList<Integer> list = new ArrayList<>();
		inOrder(a, list, a.length, 0);
		return minimumSwaps(a, list);
	}

	private static int minimumSwaps(int[] a, ArrayList<Integer> list) {
		int ans = 0;
		Pairr[] arr = new Pairr[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = new Pairr(list.get(i), i);
		Arrays.sort(arr, new Comparator<Pairr>() {
			public int compare(Pairr p1, Pairr p2) {
				return p1.val - p2.val;
			}
		});
		boolean[] vi = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (vi[i] == true || arr[i].idx == i)
				continue;
			int j = i;
			int clen = 0;
			while (vi[j] == false) {
				vi[j] = true;
				clen++;
				j = arr[j].idx;
			}
			ans += (clen - 1);
		}
		return ans;
	}

	private static void inOrder(int[] a, ArrayList<Integer> list, int n, int index) {
		if (index >= n)
			return;
		inOrder(a, list, n, 2 * index + 1);
		list.add(a[index]);
		inOrder(a, list, n, 2 * index + 2);
	}
}

class Pairr {
	int val;
	int idx;

	public Pairr(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}