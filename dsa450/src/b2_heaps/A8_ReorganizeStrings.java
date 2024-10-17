package b2_heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/reorganize-string/
 * https://www.youtube.com/watch?v=D_jE64CJ5UE
 */
public class A8_ReorganizeStrings {
	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
	}

	public static String reorganizeString(String s) {
		StringBuilder ans = new StringBuilder();
		// Frequency Map
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		// Max Heap
		PriorityQueue<Pairr> pq = new PriorityQueue<>();
		for (char ch : map.keySet()) {
			Pairr p = new Pairr(ch, map.get(ch));
			pq.add(p);
		}
		Pairr block = pq.poll();
		ans.append(block.ch);
		block.f--;
		while (!pq.isEmpty()) {
			Pairr temp = pq.poll();
			ans.append(temp.ch);
			temp.f--;
			if (block.f > 0) {
				pq.add(block);
			}
			block = temp;
		}
		if (block.f > 0)
			return "";
		return ans.toString();
	}
}

class Pairr implements Comparable<Pairr> {
	char ch;
	int f;

	public Pairr(char ch, int f) {
		this.ch = ch;
		this.f = f;
	}

	public int compareTo(Pairr o) {
		return o.f - this.f;
	}

	@Override
	public String toString() {
		return "Pairr [ch=" + ch + ", f=" + f + "]";
	}
	
}
