package a3_string;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
 * https://www.youtube.com/watch?v=e1HlptlipB0&t=11s
 * Input:
	S = "timetopractice"
	P = "toc"
	Output: 
	toprac
	Explanation: "toprac" is the smallest substring in which "toc" can be found.
 */
public class D4_SmallestWindowOfString {
	public static void main(String[] args) {
		String s1 = "timetopractice";
		String s2 = "toc";
		String ans = "";

		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

		int matchCount = 0;
		int desiredMatchCount = s2.length();
		HashMap<Character, Integer> map1 = new HashMap<>();
		int i = -1;
		int j = -1;

		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// acquire
			while (i < s1.length() - 1 && matchCount < desiredMatchCount) {
				i++;
				char ch = s1.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);

				if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					matchCount++;
				}
				f1 = true;
			}

			// collect answers and release
			while (j < i && matchCount == desiredMatchCount) {
				String potentialAns = s1.substring(j + 1, i + 1);
				if (ans.length() == 0 || potentialAns.length() < ans.length()) {
					ans = potentialAns;
				}
				j++;
				char ch = s1.charAt(j);
				if (map1.get(ch) == 1) {
					map1.remove(ch);
				} else {
					map1.put(ch, map1.get(ch) - 1);
				}
				if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					matchCount--;
				}
				f2 = true;
			}
			if (!f1 && !f2) {
				break;
			}
		}

		System.out.println(ans);
	}
}
