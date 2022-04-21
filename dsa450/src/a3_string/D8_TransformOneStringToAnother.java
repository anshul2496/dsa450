package a3_string;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/transform-string5648/1/
 * https://www.youtube.com/watch?v=V4mwu1Gs8Sg&t=42s
 */
public class D8_TransformOneStringToAnother {
	public static void main(String[] args) {
		String A = "abd";
		String B = "bad";
		System.out.println(transform(A, B));
	}

	private static int transform(String A, String B) {
		if (A.length() != B.length()) {
			return -1;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			char ch1 = B.charAt(i);
			map.put(ch1, map.getOrDefault(ch1, 0) - 1);
		}
		if (map.values().stream().anyMatch(i -> i != 0)) {
			return -1;
		}
		int res = 0;
		int p1 = A.length() - 1;
		int p2 = B.length() - 1;
		while (p1 >= 0) {
			if (A.charAt(p1) != B.charAt(p2)) {
				res++;
			} else {
				p2--;
			}
			p1--;
		}
		return res;
	}
}
