package a3_string;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/reorganize-string/
 * https://www.youtube.com/watch?v=D_jE64CJ5UE
 * Input: s = "aab"
	Output: "aba"
 */
public class D1_RearrangeCharaSuchNoTwoAreSame {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int[] a = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}

		// Max Priority Queue
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (y.f - x.f));
		for (int i = 0; i < 26; i++) {
			if (a[i] > 0) {
				Pair p = new Pair((char) ('a' + i), a[i]);
				pq.add(p);
			}
		}
		StringBuilder ans = new StringBuilder();
		Pair block = pq.poll();
		ans.append(block.ch);
		block.f--;
		while (!pq.isEmpty()) {
			Pair temp = pq.poll();
			ans.append(temp.ch);
			temp.f--;
			if (block.f > 0) {
				pq.add(block);
			}
			block = temp;
		}
		if (block.f > 0) {
			System.out.println("");
		} else {
			System.out.println(ans.toString());
		}
	}
}

class Pair {
	char ch;
	int f;

	public Pair(char ch, int f) {
		this.ch = ch;
		this.f = f;
	}
}