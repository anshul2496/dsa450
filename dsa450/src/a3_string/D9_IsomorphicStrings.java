package a3_string;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1
 * https://www.youtube.com/watch?v=6Qkail843d8
 * Input:
	str1 = aab
	str2 = xxy
	Output: 1
	Explanation: There are two different charactersin aab and xxy, i.e a and b with frequency 2and 1 respectively.
 */
public class D9_IsomorphicStrings {
	public static void main(String[] args) {
		String str = "aab";
		String target = "xxy";
		System.out.println(isIsomorphic(str, target));
	}

	private static boolean isIsomorphic(String str, String target) {
		if (str.length() != target.length()) {
			return false;
		}
		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Boolean> map2 = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch1 = str.charAt(i);
			char ch2 = target.charAt(i);

			if (map1.containsKey(ch1)) {
				if (map1.get(ch1) != ch2) {
					return false;
				}
			} else {
				if (map2.containsKey(ch2)) {
					return false;
				}
				map1.put(ch1, ch2);
				map2.put(ch2, true);
			}
		}
		return true;
	}
}
