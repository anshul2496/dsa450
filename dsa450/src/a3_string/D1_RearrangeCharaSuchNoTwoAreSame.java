package a3_string;

import java.util.HashMap;
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
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (y.f - x.f));
		// Can also be written as - PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Integer.compare(b.f,a.f));
		for (Character c : map.keySet()) {
			Pair p = new Pair(c, map.get(c));
			pq.add(p);
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