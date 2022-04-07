package a3_string;

import java.util.HashMap;
import java.util.Iterator;

/*
 * https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1
 * https://www.youtube.com/watch?v=xVs5FvwMDso
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
	Note: No two strings are the second most repeated, there will be always a single string.
	N = 6
	arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
	Output: bbb
	Explanation: "bbb" is the second most occurring string with frequency 2.
 */
public class C6_SecondMostRepeatedString {
	public static void main(String[] args) {
		String[] a = { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			int v = map.get(it.next());
			if (v > firstMax) {
				secondMax = firstMax;
				firstMax = v;
			} else if (v > secondMax && v != firstMax) {
				secondMax = v;
			}
		}
		it = map.keySet().iterator();
		while (it.hasNext()) {
			String k = it.next();
			int v = map.get(k);
			if (v == secondMax) {
				System.out.println(k);
				break;
			}
		}
	}
}
