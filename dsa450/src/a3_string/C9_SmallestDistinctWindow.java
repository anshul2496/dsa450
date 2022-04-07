package a3_string;

import java.util.HashMap;
import java.util.HashSet;

/*
 * https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1
 * https://www.youtube.com/watch?v=pbUNTDdxomI
 * Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
	For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.
 */
public class C9_SmallestDistinctWindow {
	public static void main(String[] args) {
		String s = "aabcbcdbca";
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}

		int i = -1;
		int j = -1;
		int len = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// acquire till it becomes valid
			while (i < s.length() - 1 && map.size() < set.size()) {
				i++;
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
				f1 = true;
			}

			// collect and release
			while (j < i && map.size() == set.size()) {
				int potentialLen = i - j;
				len = Math.min(potentialLen, len);
				j++;
				char ch = s.charAt(j);
				if (map.get(ch) == 1) {
					map.remove(ch);
				} else {
					map.put(ch, map.get(ch) - 1);
				}
				f2 = true;
			}
			if (!f1 && !f2) {
				break;
			}
		}
		System.out.println(len);
	}
}
