package a4_searching_sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1
 * https://www.youtube.com/watch?v=U2adJaXhYDs
 */
public class B2_SortBySetBitCount {
	public static void main(String[] args) {
		Integer[] a = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				Integer aa = Integer.bitCount(a);
				Integer bb = Integer.bitCount(b);
				// The output demands decreasing order so "bb,aa"
				return Integer.compare(bb, aa);
			}
		});
		System.out.println(Arrays.toString(a));
	}
}
